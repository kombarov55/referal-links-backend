package ru.mail.nakombarov.referallinksbackend.util;

import lombok.SneakyThrows;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class HashUtil {

    private static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @SneakyThrows
    public static String hash(String pwd) {
        return passwordEncoder.encode(pwd);
    }
}
