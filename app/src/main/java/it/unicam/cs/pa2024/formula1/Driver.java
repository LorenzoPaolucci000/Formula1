package it.unicam.cs.pa2024.formula1;

/**
 * Questa classe astratta rappresenta un pilota comune.
 */
public abstract class Driver implements DriverInterface {
    protected Position position;
    protected String name;

    /**
     * Costruisce un Driver con il nome specificato e la posizione di partenza.
     *
     * @param name il nome del pilota
     * @param startPosition la posizione di partenza
     */
    public Driver(String name, Position startPosition) {
        this.name = name;
        this.position = startPosition;
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
}
