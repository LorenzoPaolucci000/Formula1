package it.unicam.cs.pa2024.formula1;
/**
 * This class represents a position in the track grid.
 */
public class Position {
    private int x;
    private int y;

    /**
     * Constructs a Position with the specified coordinates.
     *
     * @param x the x-coordinate
     * @param y the y-coordinate
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the x-coordinate of the position.
     *
     * @return the x-coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Returns the y-coordinate of the position.
     *
     * @return the y-coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * Moves the position by the specified delta values.
     *
     * @param dx the delta x
     * @param dy the delta y
     */
    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
}

