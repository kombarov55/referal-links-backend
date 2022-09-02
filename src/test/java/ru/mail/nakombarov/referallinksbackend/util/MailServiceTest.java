package ru.mail.nakombarov.referallinksbackend.util;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MailServiceTest {

    @Autowired
    MailService mailService;

    @Test
    public void test() {
        mailService.send("kombarov55@gmail.com", "ab0001");
    }

}
