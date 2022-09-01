package ru.mail.nakombarov.referallinksbackend.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mail.nakombarov.referallinksbackend.data.AccountRole;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account")
public class Account {
    @Id
    String id;

    String login;

    String pwdHash;

    @Enumerated(EnumType.STRING)
    AccountRole role;
}
