package it.unicam.cs.pa2024.formula1;

import java.util.List;

/**
 * Questa classe rappresenta un bot nella gara.
 */
public class Bot extends Driver {
    private List<Position> moves;
    private int currentMoveIndex;

    /**
     * Costruisce un Bot con il nome specificato, la posizione di partenza, il carattere di visualizzazione (nel tracciato) e la lista delle mosse da eseguire.
     *
     * @param name             il nome del bot
     * @param startPosition    la posizione di partenza
     * @param displayCharacter il carattere di visualizzazione
     * @param moves            la lista delle mosse del bot
     */
    public Bot(String name, Position startPosition, char displayCharacter, List<Position> moves) {
        super(name, startPosition, displayCharacter);
        this.moves = moves;
        this.currentMoveIndex = 0;
    }

    /**
     * Metodo che serve per far muovere il bot nel tracciato secondo la lista delle mosse che possiede.
     *
     * @param track il tracciato su cui si muove il bot
     */
    @Override
    public void move(Track track) {
        if (currentMoveIndex < moves.size()) {
            Position nextMove = moves.get(currentMoveIndex);
            if (track.isValidPosition(nextMove)) {
                this.position = nextMove;
            }
            currentMoveIndex++;
        }
    }
}
