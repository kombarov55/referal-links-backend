package ru.mail.nakombarov.referallinksbackend.data.rs;

import lombok.Data;

@Data
public class ClientRs {
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
