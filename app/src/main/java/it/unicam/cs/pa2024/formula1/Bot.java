package it.unicam.cs.pa2024.formula1;

import java.util.Random;

/**
 * Questa classe rappresenta un bot driver nella gara.
 */
public class Bot extends Driver {
    private Random random;

    /**
     * Costruisce un Bot con il nome specificato e la posizione di partenza.
     *
     * @param name il nome del bot
     * @param startPosition la posizione di partenza
     */
    public Bot(String name, Position startPosition) {
        super(name, startPosition);
        this.random = new Random();
    }

    @Override
    public void move(Track track) {
        boolean validMove = false;

        while (!validMove) {
            int dx = random.nextInt(7) - 3; // Movimento casuale tra -3 e 3
            int dy = random.nextInt(7) - 3; // Movimento casuale tra -3 e 3

            if (!isValidMove(dx, dy)) {
                continue;
            }

            Position newPosition = new Position(position.getX() + dx, position.getY() - dy); // Inverti il segno di dy

            if (track.isValidPosition(newPosition)) {
                this.position = newPosition;
                validMove = true;
            }
        }
    }
}
