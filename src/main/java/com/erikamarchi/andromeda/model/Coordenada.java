package com.erikamarchi.andromeda.model;

public class Coordenada {
    private int x;
    private int y;

    public Coordenada(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Coordenada subir() {
        return new Coordenada(x, y + 1);
    }

    public Coordenada descer() {
        return new Coordenada(x, y - 1);
    }

    public Coordenada deslocarParaEsquerda() {
        return new Coordenada(x - 1, y);
    }

    public Coordenada deslocarParaDireita() {
        return new Coordenada(x + 1, y);
    }

}
