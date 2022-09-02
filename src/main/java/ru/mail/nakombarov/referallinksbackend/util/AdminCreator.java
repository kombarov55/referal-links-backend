package ru.mail.nakombarov.referallinksbackend.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mail.nakombarov.referallinksbackend.data.AccountRole;
import ru.mail.nakombarov.referallinksbackend.data.entity.Account;
import ru.mail.nakombarov.referallinksbackend.repository.AccountRepository;

import javax.annotation.PostConstruct;
import java.util.UUID;

@Component
public class AdminCreator {

    @Autowired
    AccountRepository accountRepository;

    @PostConstruct
    public void init() {
        if (accountRepository.count() == 0) {
            Account account = Account.builder()
                    .id(UUID.randomUUID().toString())
                    .login("admin")
                    .pwdHash("admin")
                    .role(AccountRole.MANAGER)
                    .build();

            accountRepository.save(account);
        }
    }

}
