package ru.mail.nakombarov.referallinksbackend.endpoint;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mail.nakombarov.referallinksbackend.data.entity.Account;
import ru.mail.nakombarov.referallinksbackend.data.rq.LoginRq;
import ru.mail.nakombarov.referallinksbackend.data.rs.LoginRs;
import ru.mail.nakombarov.referallinksbackend.repository.AccountRepository;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor()
public class AccountEndpoint {
    final AccountRepository accountRepository;

    @PostMapping
    @RequestMapping("/login")
    public LoginRs login(@RequestBody LoginRq rq) {
        Account account = accountRepository.findByLoginAndPwdHash(rq.getLogin(), rq.getPwd());

        if (account == null) {
            return LoginRs.builder()
                    .found(false)
                    .build();
        } else {
            return LoginRs.builder()
                    .found(true)
                    .id(account.getId())
                    .role(account.getRole().name())
                    .login(account.getLogin())
                    .build();
        }
    }
}
