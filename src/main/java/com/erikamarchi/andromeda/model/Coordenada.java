package com.erikamarchi.andromeda.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordenada that = (Coordenada) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Coordenada{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
