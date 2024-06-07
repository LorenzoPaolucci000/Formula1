package it.unicam.cs.pa2024.formula1;

import java.util.Objects;

/**
 * Questa classe rappresenta una posizione nella griglia del tracciato.
 */
public class Position {
    private int x;
    private int y;

    /**
     * Costruisce una posizione con le coordinate specificate.
     *
     * @param x la coordinata x
     * @param y la coordinata y
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Restituisce la coordinata x della posizione.
     *
     * @return la coordinata x
     */
    public int getX() {
        return x;
    }

    /**
     * Restituisce la coordinata y della posizione.
     *
     * @return la coordinata y
     */
    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
