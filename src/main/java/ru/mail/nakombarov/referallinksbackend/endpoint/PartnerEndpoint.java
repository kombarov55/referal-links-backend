package ru.mail.nakombarov.referallinksbackend.endpoint;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import ru.mail.nakombarov.referallinksbackend.data.AccountRole;
import ru.mail.nakombarov.referallinksbackend.data.entity.Account;
import ru.mail.nakombarov.referallinksbackend.data.entity.Partner;
import ru.mail.nakombarov.referallinksbackend.data.rq.AddPartnerRq;
import ru.mail.nakombarov.referallinksbackend.data.rs.AddPartnerRs;
import ru.mail.nakombarov.referallinksbackend.data.rs.PartnerRs;
import ru.mail.nakombarov.referallinksbackend.repository.PartnerRepository;
import ru.mail.nakombarov.referallinksbackend.util.HashUtil;
import ru.mail.nakombarov.referallinksbackend.util.IdGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/partner")
@RequiredArgsConstructor()
public class PartnerEndpoint {

    @Value("${app.register-link}")
    private String registerLink;

    private final PartnerRepository partnerRepository;

    @PostMapping
    public AddPartnerRs post(@RequestBody AddPartnerRq rq) {
        Partner vo = Partner.builder()
                .id(IdGenerator.gen())
                .account(Account.builder()
                        .id(IdGenerator.gen())
                        .login(rq.getLogin())
                        .pwdHash(HashUtil.hash(rq.getPwd()))
                        .role(AccountRole.PARTNER)
                        .build())
                .points(0)
                .build();

        partnerRepository.save(vo);

        return AddPartnerRs.builder()
                .id(vo.getId())
                .login(rq.getLogin())
                .registerLink(registerLink + vo.getId())
                .build();
    }

    @GetMapping
    public List<PartnerRs> getAll(@RequestParam("page") int page, @RequestParam("size") int size) {
        return StreamSupport.stream(partnerRepository.findAll(PageRequest.of(page, size)).spliterator(), false)
                .map(v -> PartnerRs.builder()
                        .login(v.getAccount().getLogin())
                        .points(v.getPoints())
                        .id(v.getId())
                        .registerLink(registerLink + v.getId())
                        .build())
                .collect(Collectors.toList());
    }

    @GetMapping
    @RequestMapping("/find")
    public List<PartnerRs> findByLogin(@RequestParam("login") String login) {
        return partnerRepository.findByLogin(login).stream()
                .map(v -> PartnerRs.builder()
                        .login(v.getAccount().getLogin())
                        .points(v.getPoints())
                        .id(v.getId())
                        .registerLink(registerLink + v.getId())
                        .build())
                .collect(Collectors.toList());
    }

}
