package ru.mail.nakombarov.referallinksbackend.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bonus_history")
public class BonusHistory {
    @Id
    String id;
    String partnerId;
    int diff;
    int amount;
    Date creationDate;
}
