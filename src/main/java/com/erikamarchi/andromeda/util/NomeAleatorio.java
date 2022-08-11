package com.erikamarchi.andromeda.util;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class NomeAleatorio {
    public String criaNomeAleatorio() {

        Random r = new Random();

        StringBuilder nome = new StringBuilder();
        String letras = "ABCDEFGHWXYZ";
        nome.append(letras.charAt(r.nextInt(0, 11)));
        nome.append(letras.charAt(r.nextInt(0, 11)));
        nome.append(letras.charAt(r.nextInt(0, 11)));
        nome.append(r.nextInt(1000));

        return nome.toString();
    }

}
