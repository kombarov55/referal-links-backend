package ru.mail.nakombarov.referallinksbackend.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "client")
public class Client {
    @Id
    String id;

    String partnerId;
    String fio;
    String address;
    String region;
    String postIndex;
    String email;
    String phone;
    String country;
}
