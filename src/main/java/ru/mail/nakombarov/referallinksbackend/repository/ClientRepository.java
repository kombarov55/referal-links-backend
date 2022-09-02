package ru.mail.nakombarov.referallinksbackend.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.mail.nakombarov.referallinksbackend.data.entity.Client;

import java.util.List;

public interface ClientRepository extends PagingAndSortingRepository<Client, String> {
    @Query("select vo "
            + "from Client vo "
            + "where vo.id like %:id%")
    List<Client> findWithIdLike(String id);
}
