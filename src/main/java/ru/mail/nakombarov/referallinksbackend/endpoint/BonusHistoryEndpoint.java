package ru.mail.nakombarov.referallinksbackend.endpoint;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.mail.nakombarov.referallinksbackend.data.rs.BonusHistoryRs;
import ru.mail.nakombarov.referallinksbackend.mapper.BonusHistoryMapper;
import ru.mail.nakombarov.referallinksbackend.repository.BonusHistoryRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bonusHistory")
@RequiredArgsConstructor
public class BonusHistoryEndpoint {

    private final BonusHistoryRepository bonusHistoryRepository;
    private final BonusHistoryMapper bonusHistoryMapper;

    @GetMapping
    @RequestMapping("/findByPartnerId")
    public List<BonusHistoryRs> findByPartnerId(@RequestParam("q") String partnerId) {
        return bonusHistoryRepository.findByPartnerId(partnerId).stream()
                .map(bonusHistoryMapper::toRs)
                .collect(Collectors.toList());
    }
}
