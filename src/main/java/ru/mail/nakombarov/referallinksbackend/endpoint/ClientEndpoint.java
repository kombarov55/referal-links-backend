package ru.mail.nakombarov.referallinksbackend.endpoint;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mail.nakombarov.referallinksbackend.data.entity.Account;
import ru.mail.nakombarov.referallinksbackend.data.entity.Client;
import ru.mail.nakombarov.referallinksbackend.data.rq.AddClientRq;
import ru.mail.nakombarov.referallinksbackend.mapper.ClientMapper;
import ru.mail.nakombarov.referallinksbackend.repository.ClientRepository;
import ru.mail.nakombarov.referallinksbackend.util.HashUtil;
import ru.mail.nakombarov.referallinksbackend.util.IdGenerator;
import ru.mail.nakombarov.referallinksbackend.util.MailService;

@Slf4j
@RestController
@RequestMapping("/client")
@RequiredArgsConstructor()
public class ClientEndpoint {

    private final ClientMapper clientMapper;
    private final ClientRepository clientRepository;
    private final MailService mailService;

    @PostMapping
    public void save(@RequestBody AddClientRq rq) throws Exception {
        Client client = clientMapper.toVo(rq).toBuilder()
                .id(IdGenerator.gen())
                .account(Account.builder()
                        .id(IdGenerator.gen())
                        .login(rq.getLogin())
                        .pwdHash(HashUtil.hash(rq.getPwd()))
                        .build())
                .build();
        log.info("{}", new ObjectMapper().writeValueAsString(client));
        clientRepository.save(client);
        mailService.send(client.getEmail(), client.getId());
    }

}
