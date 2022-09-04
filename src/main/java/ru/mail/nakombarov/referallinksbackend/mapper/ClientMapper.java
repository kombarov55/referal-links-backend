package ru.mail.nakombarov.referallinksbackend.mapper;

import org.mapstruct.Mapper;
import ru.mail.nakombarov.referallinksbackend.data.entity.Client;
import ru.mail.nakombarov.referallinksbackend.data.rq.AddClientRq;
import ru.mail.nakombarov.referallinksbackend.data.rs.ClientRs;

@Mapper
public interface ClientMapper {
    Client toVo(AddClientRq rq);

    ClientRs toRs(Client vo);
}
