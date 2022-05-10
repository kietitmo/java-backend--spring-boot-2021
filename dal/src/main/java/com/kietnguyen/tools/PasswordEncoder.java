package com.kietnguyen.tools;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
    public String getEncodedPassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }
}
