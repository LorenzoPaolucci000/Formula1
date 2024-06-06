package it.unicam.cs.pa2024.formula1;

/**
 * Questa interfaccia rappresenta un pilota durante la gara.
 */
public interface DriverInterface {
    /**
     * Muove il pilota basandosi sullo stato attuale del tracciato.
     *
     * @param track il tracciato della pista su cui il pilota si muove
     */
    void move(Track track);

    /**
     * Restituisce la posizione attuale del driver.
     *
     * @return la posizione (x,y)
     */
    Position getPosition();

    /**
     * Restituisce il nome del pilota.
     *
     * @return il nome
     */
    String getName();
}
