package ru.mail.nakombarov.referallinksbackend.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "partner")
public class Partner {
    @Id
    String id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    Account account;

    Integer points;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "partnerId")
    List<Client> clients;
}
