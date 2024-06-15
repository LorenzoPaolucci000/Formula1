package it.unicam.cs.pa2024.formula1;

/**
 * Questa classe astratta rappresenta un pilota comune.
 */
public abstract class Driver implements DriverInterface {
    protected String name;
    protected Position position;
    protected char displayCharacter;

    /**
     * Costruisce un pilota con il nome specificato, la posizione di partenza e il carattere di visualizzazione (visualizzato nel tracciato durante la gara).
     *
     * @param name             il nome del pilota
     * @param startPosition    la posizione di partenza
     * @param displayCharacter il carattere di visualizzazione
     */
    public Driver(String name, Position startPosition, char displayCharacter) {
        this.name = name;
        this.position = startPosition;
        this.displayCharacter = displayCharacter;
    }

    /**
     * Metodo che verifica il movimento per assicurarsi che dx e dy siano compresi nell'intervallo [-3, 3].
     *
     * @param dx il movimento orizzontale
     * @param dy il movimento verticale
     * @return true se il movimento è valido, false altrimenti
     */
    protected boolean isValidMove(int dx, int dy) {
        return Math.abs(dx) <= 3 && Math.abs(dy) <= 3;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public String getName() {
        return name;
    }

    /**
     * Metodo che restituisce il carattere da utilizzare per visualizzare il pilota sulla pista.
     *
     * @return il carattere di visualizzazione
     */
    public char getDisplayCharacter() {
        return displayCharacter;
    }
}
