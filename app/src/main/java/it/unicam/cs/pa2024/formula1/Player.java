package it.unicam.cs.pa2024.formula1;

/**
 * Questa classe rappresenta un giocatore umano nella gara.
 */
public class Player extends Driver {
    private final InputHandler inputHandler;
    private boolean isFirstTurn;

    /**
     * Costruisce un giocatore con il nome specificato, la posizione di partenza, l'input handler e il carattere di visualizzazione nella pista durante la gara.
     *
     * @param name          il nome del giocatore
     * @param startPosition la posizione di partenza
     * @param inputHandler  l'input handler per il giocatore
     * @param displayCharacter il carattere di visualizzazione
     */
    public Player(String name, Position startPosition, InputHandler inputHandler, char displayCharacter) {
        super(name, startPosition, displayCharacter);
        this.inputHandler = inputHandler;
        this.isFirstTurn = true;
    }

    /**
     * Metodo che serve per far muovere il giocatore nel tracciato in base all'input dell'utente.
     *
     * @param track il tracciato su cui si muove il giocatore
     */
    @Override
    public void move(Track track) {
        boolean validMove = false;

        while (!validMove) {
            System.out.println(this.getName());
            int[] move = inputHandler.getMove();
            int dx = move[0];
            int dy = move[1];

            if (!isValidMove(dx, dy)) {
                System.out.println("Mossa non valida, le coordinate dx e dy devono essere comprese tra -3 e 3. Prova di nuovo.");
                continue;
            }

            Position newPosition = new Position(position.getX() + dx, position.getY() - dy);

            if (!isMoveAllowed(dy, newPosition, track)) {
                continue;
            }

            this.position = newPosition;
            validMove = true;
            isFirstTurn = false;
        }
    }

    /**
     * Metodo che verifica se un movimento è valido.
     * Controlla se il movimento è valido nel primo turno (non permette di muoversi verso il basso)
     * e se la nuova posizione è valida nel tracciato.
     *
     * @param dy lo spostamento verticale della mossa inserita
     * @param newPosition la  posizione da verificare
     * @param track il tracciato su cui si muove il giocatore
     * @return true se il movimento è consentito, false altrimenti
     */
    private boolean isMoveAllowed(int dy, Position newPosition, Track track) {
        if (isFirstTurn && dy < 0) {
            System.out.println("Mossa non valida al primo turno, non puoi muoverti verso il basso. Prova di nuovo.");
            return false;
        }
        if (!track.isValidPosition(newPosition)) {
            System.out.println("Mossa non valida, prova di nuovo.");
            return false;
        }

        return true;
    }
}
