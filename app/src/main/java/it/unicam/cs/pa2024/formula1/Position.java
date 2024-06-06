package it.unicam.cs.pa2024.formula1;

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

    /**
     * Sposta la posizione dei valori delta specificati.
     *
     * @param dx il delta x
     * @param dy il delta y
     */
    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
}
