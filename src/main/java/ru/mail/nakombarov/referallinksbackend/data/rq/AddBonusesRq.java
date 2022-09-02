package ru.mail.nakombarov.referallinksbackend.data.rq;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddBonusesRq {
    String id;
    int points;
}
