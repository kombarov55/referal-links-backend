package ru.mail.nakombarov.referallinksbackend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.mail.nakombarov.referallinksbackend.data.entity.Partner;

import java.util.List;
import java.util.Optional;

@Repository
public interface PartnerRepository extends PagingAndSortingRepository<Partner, String> {
    Page<Partner> findAll(Pageable pageable);

    @Query("select vo "
            + "from Partner vo "
            + "where vo.account.login like %:login%")
    List<Partner> findByLoginLike(String login);

    Optional<Partner> findByAccountLogin(String login);
}
