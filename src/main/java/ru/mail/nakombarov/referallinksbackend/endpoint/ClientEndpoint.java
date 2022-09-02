package ru.mail.nakombarov.referallinksbackend.endpoint;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import ru.mail.nakombarov.referallinksbackend.data.entity.Account;
import ru.mail.nakombarov.referallinksbackend.data.entity.Client;
import ru.mail.nakombarov.referallinksbackend.data.rq.AddClientRq;
import ru.mail.nakombarov.referallinksbackend.data.rs.AddClientRs;
import ru.mail.nakombarov.referallinksbackend.data.rs.ClientRs;
import ru.mail.nakombarov.referallinksbackend.mapper.ClientMapper;
import ru.mail.nakombarov.referallinksbackend.repository.ClientRepository;
import ru.mail.nakombarov.referallinksbackend.util.IdGenerator;
import ru.mail.nakombarov.referallinksbackend.util.MailService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@RestController
@RequestMapping("/client")
@RequiredArgsConstructor()
public class ClientEndpoint {

    private final ClientMapper clientMapper;
    private final ClientRepository clientRepository;
    private final MailService mailService;

    @PostMapping
    public AddClientRs addClient(@RequestBody AddClientRq rq) throws Exception {
        Client client = clientMapper.toVo(rq).toBuilder()
                .id(IdGenerator.gen())
                .account(Account.builder()
                        .id(IdGenerator.gen())
                        .login(rq.getLogin())
                        .pwdHash(rq.getPwd())
                        .build())
                .build();
        clientRepository.save(client);
        mailService.send(client.getEmail(), client.getId());

        return AddClientRs.builder()
                .id(client.getId())
                .email(client.getEmail())
                .build();
    }

    @GetMapping
    public List<ClientRs> findAll(@RequestParam("page") int page, @RequestParam("size") int size) {
        return StreamSupport.stream(clientRepository.findAll(PageRequest.of(page, size)).spliterator(), false)
                .map(clientMapper::toRs)
                .collect(Collectors.toList());
    }

    @GetMapping
    @RequestMapping("/findById")
    public List<ClientRs> findById(@RequestParam("q") String q) {
        return clientRepository.findWithIdLike(q).stream()
                .map(clientMapper::toRs)
                .collect(Collectors.toList());
    }

}
