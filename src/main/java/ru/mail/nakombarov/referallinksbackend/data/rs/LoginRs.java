package ru.mail.nakombarov.referallinksbackend.data.rs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginRs {
    boolean found;
    String id;
    String login;
    String role;
}
