package ru.mail.nakombarov.referallinksbackend.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.mail.nakombarov.referallinksbackend.data.entity.Client;

public interface ClientRepository extends PagingAndSortingRepository<Client, String> {
}
