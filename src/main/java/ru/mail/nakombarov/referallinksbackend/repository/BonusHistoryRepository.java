package ru.mail.nakombarov.referallinksbackend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.mail.nakombarov.referallinksbackend.data.entity.BonusHistory;

import java.util.List;

@Repository
public interface BonusHistoryRepository extends CrudRepository<BonusHistory, String> {
    List<BonusHistory> findByPartnerId(String partnerId);
}
