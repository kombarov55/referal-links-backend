package ru.mail.nakombarov.referallinksbackend.mapper;

import org.mapstruct.Mapper;
import ru.mail.nakombarov.referallinksbackend.data.entity.BonusHistory;
import ru.mail.nakombarov.referallinksbackend.data.rs.BonusHistoryRs;

@Mapper
public interface BonusHistoryMapper {
    BonusHistoryRs toRs(BonusHistory vo);
}
