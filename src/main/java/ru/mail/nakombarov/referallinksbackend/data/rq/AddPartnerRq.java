package ru.mail.nakombarov.referallinksbackend.data.rq;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddPartnerRq {
    String login;
    String pwd;
}
