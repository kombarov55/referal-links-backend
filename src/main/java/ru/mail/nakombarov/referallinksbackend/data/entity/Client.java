package ru.mail.nakombarov.referallinksbackend.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "client")
public class Client {
    @Id
    String id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    Account account = new Account();

    String partnerId;

    String lastName;
    String firstName;
    String middleName;
    String address;
    String postIndex;
    String email;
    String phone;
    String country;
}
