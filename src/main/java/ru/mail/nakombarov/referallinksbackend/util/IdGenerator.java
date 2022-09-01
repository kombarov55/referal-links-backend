package ru.mail.nakombarov.referallinksbackend.util;

import java.util.UUID;

public class IdGenerator {

    public static String gen() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

}
