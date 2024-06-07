package it.unicam.cs.pa2024.formula1;

import java.util.List;

/**
 * Questa classe rappresenta il tracciato di gara.
 */
public class Track {
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
    public char[][] getGrid() {
        return grid;
    }

    /**
     * Metodo che fa visualizzare lo stato attuale del tracciato con le posizioni dei piloti all'interno del tracciato.
     *
     * @param drivers la lista dei piloti
     */
    public void display(List<Driver> drivers) {
        char[][] displayGrid = new char[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            displayGrid[i] = grid[i].clone();
        }

        for (DriverInterface driver : drivers) {
            Position pos = driver.getPosition();
            displayGrid[pos.getY()][pos.getX()] = driver instanceof Bot ? 'B' : 'P';
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
    public boolean isValidPosition(Position position) {
        int x = position.getX();
        int y = position.getY();
        return x >= 0 && x < grid[0].length && y >= 0 && y < grid.length && grid[y][x] != 'x';
    }
}