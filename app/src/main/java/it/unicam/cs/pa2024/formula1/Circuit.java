package it.unicam.cs.pa2024.formula1;
import java.util.List;

/**
 * Questa interfaccia rappresenta un circuito permettendo la visualizzazione e di verifica delle posizione al suo interno.
 */
public interface Circuit {

    /**
     * Metodo che restituisce la griglia che rappresenta il circuito.
     *
     * @return la griglia
     */
    char[][] getGrid();

    /**
     * Metodo che visualizza lo stato attuale del circuito con le posizioni dei piloti.
     *
     * @param drivers la lista dei piloti
     */
    void display(List<Driver> drivers);

    /**
     * Metodo che verifica se la posizione specificata è valida.
     *
     * @param position la posizione da verificare
     * @return true se la posizione è valida, false altrimenti
     */
    boolean isValidPosition(Position position);
}