package ru.mail.nakombarov.referallinksbackend.data.rs;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PartnerByIdRs {
    boolean found;
    String id;
    String login;
    int points;
    int clientsCount;
}
