package ru.mail.nakombarov.referallinksbackend.util;

import lombok.SneakyThrows;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

public class HashUtil {

    private static PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @SneakyThrows
    public static String hash(String pwd) {
        return passwordEncoder.encode(pwd);
    }
}
