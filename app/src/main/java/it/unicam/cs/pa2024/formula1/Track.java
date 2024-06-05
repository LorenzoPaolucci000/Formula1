package it.unicam.cs.pa2024.formula1;

import java.util.List;

/**
 * This class represents the race track.
 */
public class Track {
    private char[][] grid;

    /**
     * Constructs a Track with the specified grid.
     *
     * @param grid the grid representing the track
     */
    public Track(char[][] grid) {
        this.grid = grid;
    }

    /**
     * Returns the grid of the track.
     *
     * @return the grid
     */
    public char[][] getGrid() {
        return grid;
    }

    /**
     * Displays the current state of the track with the drivers' positions.
     *
     * @param drivers the list of drivers
     */
    public void display(List<Driver> drivers) {
        char[][] displayGrid = new char[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            displayGrid[i] = grid[i].clone();
        }

        for (Driver driver : drivers) {
            Position pos = driver.getPosition();
            displayGrid[pos.getX()][pos.getY()] = driver instanceof Bot ? 'B' : 'P';
        }

        for (char[] row : displayGrid) {
            for (char cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }

    /**
     * Checks if the specified position is valid (not a wall or out of bounds).
     *
     * @param position the position to check
     * @return true if the position is valid, false otherwise
     */
    public boolean isValidPosition(Position position) {
        int x = position.getX();
        int y = position.getY();
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] != 'x';
    }
}