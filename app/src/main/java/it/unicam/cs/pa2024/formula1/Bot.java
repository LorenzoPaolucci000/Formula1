package it.unicam.cs.pa2024.formula1;

import java.util.Random;

/**
 * This class represents a bot driver in the race.
 */
public class Bot implements Driver {
    private Position position;
    private String name;
    private Random random;

    /**
     * Constructs a Bot with the specified name and starting position.
     *
     * @param name the name of the bot
     * @param startPosition the starting position
     */
    public Bot(String name, Position startPosition) {
        this.name = name;
        this.position = startPosition;
        this.random = new Random();
    }

    @Override
    public void move(Track track) {
        int dx = random.nextInt(3) - 1; // Random move: -1, 0, 1
        int dy = random.nextInt(3) - 1; // Random move: -1, 0, 1
        Position newPosition = new Position(position.getX() + dx, position.getY() + dy);

        if (track.isValidPosition(newPosition)) {
            this.position = newPosition;
        }
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public String getName() {
        return name;
    }
}

