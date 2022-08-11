package com.erikamarchi.andromeda.exception;

import com.erikamarchi.andromeda.model.Coordenada;

public class CoordenadaIndisponivelException extends RuntimeException {
    public CoordenadaIndisponivelException(Coordenada coordenada) {
        super(String.format("A coordenada %s está indisponível!",coordenada.toString()));
    }
}
