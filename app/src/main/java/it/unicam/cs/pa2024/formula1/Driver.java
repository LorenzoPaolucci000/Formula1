package it.unicam.cs.pa2024.formula1;

/**
 * Questa classe astratta rappresenta un pilota comune.
 */
public abstract class Driver implements IDriver {
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


    @Override
    public boolean isValidMove(int dx, int dy) {
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

    @Override
    public char getDisplayCharacter() {
        return displayCharacter;
    }
}
