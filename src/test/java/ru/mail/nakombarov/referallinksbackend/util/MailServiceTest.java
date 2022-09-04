package ru.mail.nakombarov.referallinksbackend.util;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.mail.nakombarov.referallinksbackend.data.entity.Client;

@SpringBootTest
public class MailServiceTest {

    @Autowired
    MailService mailService;

    @Test
    public void test() {
        mailService.send("kombarov55@gmail.com", Client.builder()
                .phone("ab0001")
                .build());
    }

}
