package ru.mail.nakombarov.referallinksbackend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.mail.nakombarov.referallinksbackend.data.entity.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, String> {
    Account findByLoginAndPwdHash(String login, String pwdHash);
}
