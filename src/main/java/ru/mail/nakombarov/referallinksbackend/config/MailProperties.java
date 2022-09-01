package ru.mail.nakombarov.referallinksbackend.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "app.mail")
public class MailProperties {
    String host;
    String port;
    String username;
    String password;
}
