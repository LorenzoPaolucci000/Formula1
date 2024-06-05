package it.unicam.cs.pa2024.formula1;

import java.util.Scanner;

/**
 * This class represents a human player in the race.
 */
public class Player implements Driver {
    private Position position;
    private String name;

    /**
     * Constructs a Player with the specified name and starting position.
     *
     * @param name the name of the player
     * @param startPosition the starting position
     */
    public Player(String name, Position startPosition) {
        this.name = name;
        this.position = startPosition;
    }

    @Override
    public void move(Track track) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(name + ", enter your move (dx dy): ");
        int dx = scanner.nextInt();
        int dy = scanner.nextInt();
        Position newPosition = new Position(position.getX() + dx, position.getY() + dy);

        if (track.isValidPosition(newPosition)) {
            this.position = newPosition;
        } else {
            System.out.println("Invalid move, try again.");
            move(track);
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