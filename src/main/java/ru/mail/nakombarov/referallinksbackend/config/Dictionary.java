package ru.mail.nakombarov.referallinksbackend.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "app.dictionary")
public class Dictionary {
    List<String> countries;
}
