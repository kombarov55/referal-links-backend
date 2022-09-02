package ru.mail.nakombarov.referallinksbackend.data.rs;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class BonusHistoryRs {
    int diff;
    int amount;
    Date creationDate;
}
