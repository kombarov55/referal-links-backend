package ru.mail.nakombarov.referallinksbackend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.mail.nakombarov.referallinksbackend.data.entity.Client;
import ru.mail.nakombarov.referallinksbackend.data.rq.AddClientRq;

@Mapper
public interface ClientMapper {

    @Mapping(target = "id", expression = "java(ru.mail.nakombarov.referallinksbackend.util.IdGenerator.gen())")
    @Mapping(target = "account.id", expression = "java(ru.mail.nakombarov.referallinksbackend.util.IdGenerator.gen())")
    @Mapping(target = "account.login", source = "login")
    @Mapping(target = "account.pwdHash", expression = "java(ru.mail.nakombarov.referallinksbackend.util.HashUtil.hash(addClientRq.getPwd()))")
    Client toVo(AddClientRq rq);
}
