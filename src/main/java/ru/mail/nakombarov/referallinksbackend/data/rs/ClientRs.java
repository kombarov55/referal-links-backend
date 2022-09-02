package ru.mail.nakombarov.referallinksbackend.data.rs;

import lombok.Data;

@Data
public class ClientRs {
    String id;
    String login;
    String partnerId;
    String fio;
    String address;
    String postIndex;
    String email;
    String phone;
    String country;
}
