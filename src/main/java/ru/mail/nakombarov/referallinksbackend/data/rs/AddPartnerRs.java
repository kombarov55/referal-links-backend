package ru.mail.nakombarov.referallinksbackend.data.rs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddPartnerRs {
    String id;
    String login;
    String registerLink;
}
