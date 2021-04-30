package ru.megalom.spingsecurity.demo.utilites;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        String swd=passwordEncoder.encode("mary123");
        System.out.println(swd);

    }
}
