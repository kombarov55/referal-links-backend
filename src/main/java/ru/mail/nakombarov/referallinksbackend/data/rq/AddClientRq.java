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
    String login;
    String pwd;
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
