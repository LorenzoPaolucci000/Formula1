package it.unicam.cs.pa2024.formula1;

/**
 * Questa classe rappresenta un giocatore umano nella gara.
 */
public class Player extends Driver {
    private InputHandler inputHandler;

    /**
     * Costruisce un Player con il nome specificato, la posizione di partenza e l'input handler.
     *
     * @param name il nome del giocatore
     * @param startPosition la posizione di partenza
     * @param inputHandler l'input handler per il giocatore
     */
    public Player(String name, Position startPosition, InputHandler inputHandler) {
        super(name, startPosition);
        this.inputHandler = inputHandler;
    }

    @Override
    public void move(Track track) {
        boolean validMove = false;

        while (!validMove) {
            int[] move = inputHandler.getMove();
            int dx = move[0];
            int dy = move[1];

            if (!isValidMove(dx, dy)) {
                System.out.println("Mossa non valida, le coordinate dx e dy devono essere comprese tra -3 e 3. Prova di nuovo.");
                continue;
            }

            Position newPosition = new Position(position.getX() + dx, position.getY() - dy); // Inverti il segno di dy

            if (track.isValidPosition(newPosition)) {
                this.position = newPosition;
                validMove = true;
            } else {
                System.out.println("Mossa non valida, prova di nuovo.");
            }
        }
    }
}
