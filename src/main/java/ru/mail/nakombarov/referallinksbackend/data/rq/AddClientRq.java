package ru.mail.nakombarov.referallinksbackend.data.rq;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddClientRq {
    String partnerId;
    String fio;
    String address;
    String region;
    String postIndex;
    String email;
    String phone;
    String country;
}
