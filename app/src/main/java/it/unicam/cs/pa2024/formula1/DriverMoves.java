package it.unicam.cs.pa2024.formula1;

/**
 * Questa interfaccia rappresenta i movimenti del pilota durante la gara.
 */
public interface DriverMoves {
    /**
     * Muove il pilota basandosi sullo stato attuale del tracciato.
     *
     * @param track il tracciato della pista su cui il pilota si muove
     */
    void move(Track track);

    /**
     * Metodo che verifica il movimento per assicurarsi che dx e dy siano compresi nell'intervallo [-3, 3].
     *
     * @param dx il movimento orizzontale
     * @param dy il movimento verticale
     * @return true se il movimento è valido, false altrimenti
     */
    boolean isValidMove(int dx, int dy);

}
