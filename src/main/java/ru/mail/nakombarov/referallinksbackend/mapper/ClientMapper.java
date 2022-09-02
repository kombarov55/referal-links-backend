package ru.mail.nakombarov.referallinksbackend.mapper;

import org.mapstruct.Mapper;
import ru.mail.nakombarov.referallinksbackend.data.entity.Client;
import ru.mail.nakombarov.referallinksbackend.data.rq.AddClientRq;

@Mapper
public interface ClientMapper {
    Client toVo(AddClientRq rq);
}
