package ru.mail.nakombarov.referallinksbackend.util;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import ru.mail.nakombarov.referallinksbackend.config.MailProperties;
import ru.mail.nakombarov.referallinksbackend.data.entity.Client;

@Component
@RequiredArgsConstructor()
public class MailService {

    private final JavaMailSender javaMailSender;
    private final MailProperties mailProperties;

    public void send(String email, Client client) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(mailProperties.getUsername());
        msg.setTo(email);
        msg.setSubject("Регистрация на 'Выкуп Брендов'");
        msg.setText("Спасибо за регистрацию! Номер телефона " + client.getPhone() + " указанный при регистрации будет являться Вашим номером пользователя");
        javaMailSender.send(msg);
    }

}
