package ru.mail.nakombarov.referallinksbackend.endpoint;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import ru.mail.nakombarov.referallinksbackend.data.AccountRole;
import ru.mail.nakombarov.referallinksbackend.data.entity.Account;
import ru.mail.nakombarov.referallinksbackend.data.entity.BonusHistory;
import ru.mail.nakombarov.referallinksbackend.data.entity.Partner;
import ru.mail.nakombarov.referallinksbackend.data.rq.AddBonusesRq;
import ru.mail.nakombarov.referallinksbackend.data.rq.AddPartnerRq;
import ru.mail.nakombarov.referallinksbackend.data.rq.RemoveBonusesRq;
import ru.mail.nakombarov.referallinksbackend.data.rs.AddBonusesRs;
import ru.mail.nakombarov.referallinksbackend.data.rs.AddPartnerRs;
import ru.mail.nakombarov.referallinksbackend.data.rs.PartnerByIdRs;
import ru.mail.nakombarov.referallinksbackend.data.rs.PartnerRs;
import ru.mail.nakombarov.referallinksbackend.repository.BonusHistoryRepository;
import ru.mail.nakombarov.referallinksbackend.repository.PartnerRepository;
import ru.mail.nakombarov.referallinksbackend.util.IdGenerator;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/partner")
@RequiredArgsConstructor()
public class PartnerEndpoint {

    private final PartnerRepository partnerRepository;
    private final BonusHistoryRepository bonusHistoryRepository;

    @PostMapping
    public AddPartnerRs post(@RequestBody AddPartnerRq rq) {
        Partner vo = Partner.builder()
                .id(IdGenerator.gen())
                .account(Account.builder()
                        .id(IdGenerator.gen())
                        .login(rq.getLogin())
                        .pwdHash(rq.getPwd())
                        .role(AccountRole.PARTNER)
                        .build())
                .points(0)
                .build();

        partnerRepository.save(vo);

        return AddPartnerRs.builder()
                .id(vo.getId())
                .login(rq.getLogin())
                .build();
    }

    @GetMapping
    public List<PartnerRs> getAll(@RequestParam("page") int page, @RequestParam("size") int size) {
        return StreamSupport.stream(partnerRepository.findAll(PageRequest.of(page, size)).spliterator(), false)
                .map(v -> PartnerRs.builder()
                        .login(v.getAccount().getLogin())
                        .points(v.getPoints())
                        .id(v.getId())
                        .clientsCount(v.getClients().size())
                        .build())
                .collect(Collectors.toList());
    }

    @GetMapping
    @RequestMapping("/find")
    public List<PartnerRs> findByLogin(@RequestParam("login") String login) {
        return partnerRepository.findByLoginLike(login).stream()
                .map(v -> PartnerRs.builder()
                        .login(v.getAccount().getLogin())
                        .points(v.getPoints())
                        .id(v.getId())
                        .clientsCount(v.getClients().size())
                        .build())
                .collect(Collectors.toList());
    }

    @GetMapping
    @RequestMapping("/byId")
    public PartnerByIdRs findById(@RequestParam("q") String id) {
        return partnerRepository.findById(id)
                .map(v -> PartnerByIdRs.builder()
                        .found(true)
                        .id(v.getId())
                        .points(v.getPoints())
                        .login(v.getAccount().getLogin())
                        .clientsCount(v.getClients().size())
                        .build())
                .orElse(PartnerByIdRs.builder()
                        .found(false)
                        .build());
    }

    @GetMapping
    @RequestMapping("/byLogin")
    public PartnerByIdRs findByLoginStrict(@RequestParam("q") String login) {
        return partnerRepository.findByAccountLogin(login)
                .map(v -> PartnerByIdRs.builder()
                        .found(true)
                        .id(v.getId())
                        .points(v.getPoints())
                        .login(v.getAccount().getLogin())
                        .clientsCount(v.getClients().size())
                        .build())
                .orElse(null);
    }

    @PostMapping
    @RequestMapping("/addBonuses.do")
    @Transactional
    public AddBonusesRs addBonuses(@RequestBody AddBonusesRq rq) {
        Optional<Partner> optional = partnerRepository.findById(rq.getId());

        if (optional.isPresent()) {
            Partner partner = optional.get();
            partner.setPoints(partner.getPoints() + rq.getPoints());
            partnerRepository.save(partner);

            bonusHistoryRepository.save(BonusHistory.builder()
                    .id(IdGenerator.gen())
                    .partnerId(partner.getId())
                    .amount(partner.getPoints())
                    .diff(rq.getPoints())
                    .creationDate(new Date())
                    .build());

            return AddBonusesRs.builder()
                    .success(true)
                    .points(partner.getPoints())
                    .build();
        } else {
            return AddBonusesRs.builder()
                    .success(false)
                    .build();
        }
    }

    @PostMapping
    @RequestMapping("/removeBonuses.do")
    @Transactional
    public boolean removeBonuses(@RequestBody RemoveBonusesRq rq) {
        Optional<Partner> optional = partnerRepository.findById(rq.getId());

        if (optional.isPresent()) {
            Partner partner = optional.get();

            int prevPoints = partner.getPoints();

            partner.setPoints(0);
            partnerRepository.save(partner);

            bonusHistoryRepository.save(BonusHistory.builder()
                    .id(IdGenerator.gen())
                    .partnerId(partner.getId())
                    .amount(0)
                    .diff(prevPoints * -1)
                    .creationDate(new Date())
                    .build());

            return true;
        } else {
            return false;
        }
    }

}
