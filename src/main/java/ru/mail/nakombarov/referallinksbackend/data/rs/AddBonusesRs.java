package ru.mail.nakombarov.referallinksbackend.data.rs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddBonusesRs {
    boolean success;
    int points;
}
