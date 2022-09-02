package ru.mail.nakombarov.referallinksbackend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.mail.nakombarov.referallinksbackend.data.entity.Client;
import ru.mail.nakombarov.referallinksbackend.data.rq.AddClientRq;
import ru.mail.nakombarov.referallinksbackend.data.rs.ClientRs;

@Mapper
public interface ClientMapper {
    Client toVo(AddClientRq rq);

    @Mapping(target = "login", source = "account.login")
    @Mapping(target = "fio", expression = "java(vo.getLastName() + \" \" + vo.getFirstName() + \" \" + vo.getMiddleName())")
    ClientRs toRs(Client vo);
}
