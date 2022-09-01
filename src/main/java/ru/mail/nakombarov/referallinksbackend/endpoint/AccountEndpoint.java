package ru.mail.nakombarov.referallinksbackend.endpoint;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mail.nakombarov.referallinksbackend.data.entity.Account;
import ru.mail.nakombarov.referallinksbackend.data.rq.LoginRq;
import ru.mail.nakombarov.referallinksbackend.data.rs.LoginRs;
import ru.mail.nakombarov.referallinksbackend.repository.AccountRepository;
import ru.mail.nakombarov.referallinksbackend.util.HashUtil;

import java.util.Map;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AccountEndpoint {
    final AccountRepository accountRepository;

    @PostMapping
    @RequestMapping("/login")
    public LoginRs login(@RequestBody LoginRq rq) {
        String pwdHash = HashUtil.hash(rq.getPwd());
        Account account = accountRepository.findByLoginAndPwdHash(rq.getLogin(), pwdHash);

        if (account == null) {
            return LoginRs.builder()
                    .found(false)
                    .id(null)
                    .build();
        } else {
            return LoginRs.builder()
                    .found(true)
                    .id(account.getId())
                    .build();
        }
    }

    @PostMapping
    @RequestMapping("/add")
    public void create(@RequestBody Map<String, String> data) {

    }
}
