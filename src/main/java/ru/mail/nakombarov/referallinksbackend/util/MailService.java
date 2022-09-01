package ru.mail.nakombarov.referallinksbackend.util;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import ru.mail.nakombarov.referallinksbackend.config.MailProperties;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MailService {

    private final JavaMailSender javaMailSender;
    private final MailProperties mailProperties;

    public void send(String email, String id) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(mailProperties.getUsername());
        msg.setTo(email);
        msg.setSubject("Регистрация на домене XXXXXXX");
        msg.setText("Благодарим за регистрацию, ваш уникальный номер: " + id);
        javaMailSender.send(msg);
    }

}
