package it.unicam.cs.pa2024.formula1;

import java.util.List;

/**
 * Questa classe rappresenta il tracciato di una gara.
 */
public class Track implements Circuit{
    private char[][] grid;

    /**
     * Costruisce un tracciato di gara con la griglia specificata.
     *
     * @param grid la griglia che rappresenta il tracciato
     */
    public Track(char[][] grid) {
        this.grid = grid;
    }

    /**
     * Metodo che restituisce la griglia del tracciato.
     *
     * @return la griglia
     */
    @Override
    public char[][] getGrid() {
        return grid;
    }

    /**
     * Metodo che fa visualizzare lo stato attuale del tracciato con le posizioni dei piloti all'interno del tracciato.
     *
     * @param drivers la lista dei piloti
     */
    @Override
    public void display(List<Driver> drivers) {
        char[][] displayGrid = new char[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            displayGrid[i] = grid[i].clone();
        }

        for (Driver driver : drivers) {
            Position pos = driver.getPosition();
            displayGrid[pos.getY()][pos.getX()] = driver.getDisplayCharacter();
        }

        for (char[] row : displayGrid) {
            for (char cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }

    /**
     * Metodo che verifica se la posizione specificata è valida (ad esempio fuori dai limiti della pista).
     *
     * @param position la posizione da verificare
     * @return true se la posizione è valida, false altrimenti
     */
    @Override
    public boolean isValidPosition(Position position) {
        int x = position.getX();
        int y = position.getY();
        return y >= 0 && y < grid.length && x >= 0 && x < grid[0].length && grid[y][x] != 'x';
    }
}