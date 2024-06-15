package it.unicam.cs.pa2024.formula1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;     //Evita le interazioni di input con un utente reale ,simulando l'InputHandler
/**
 * Classe di test per la classe Player ed in parte per la classe InputHandler (dato che sono strettamente connesse).
 * Verifica se le mosse del giocatore sono corrette.
 */
class PlayerTest {

    private Track track;
    private Player player;
    private InputHandler inputHandler;

    /**
     * Metodo che carica un piccolo tracciato dal file CircuitoTest.txt e crea un Mock per simulare l'input del giocatore.
     *
     * @throws IOException se si verifica un errore durante il caricamento del tracciato
     */
    @BeforeEach
    void setUp() throws IOException {
        track = TrackLoader.loadTrack("CircuitoTest.txt");

        // Mock dell'InputHandler
        inputHandler = Mockito.mock(InputHandler.class);

        // Crea un player per i test
        player = new Player("Player1", new Position(5, 5), inputHandler, 'P');
    }

    /**
     * Test che verifica che il giocatore si sia spostato nella posizione corretta dopo una mossa valida.
     */
    @Test
    void testValidMove() {
        // Simula un input di una mossa valida
        when(inputHandler.getMove()).thenReturn(new int[]{1, 1});

        player.move(track);

        assertEquals(new Position(6, 4), player.getPosition());
    }

    /**
     * Test che verifica una mossa non valida del giocatore al di fuori dei limiti della pista ('x').
     */
    @Test
    void testInvalidMoveOutOfBounds() {
        when(inputHandler.getMove()).thenReturn(new int[]{-3, -3}).thenReturn(new int[]{1, 1});

        player.move(track);

        assertEquals(new Position(6, 4), player.getPosition());
    }

    /**
     * Test che verifica una mossa non valida del giocatore fuori dal range consentito [-3, 3].
     */
    @Test
    void testInvalidMoveOutOfRange() {
        when(inputHandler.getMove()).thenReturn(new int[]{4, 4}).thenReturn(new int[]{1, 1});

        player.move(track);

        assertEquals(new Position(6, 4), player.getPosition());
    }

    /**
     * Test che verifica il comportamento del giocatore con più mosse non valide seguite da una mossa valida.
     */
    @Test
    void testMultipleInvalidMoves() {
        // Simula più mosse non valide
        when(inputHandler.getMove())
                .thenReturn(new int[]{-4, -4})          // fuori range
                .thenReturn(new int[]{1, 5})            // fuori dai limiti della pista
                .thenReturn(new int[]{1, 1});           // mossa valida

        player.move(track);

        assertEquals(new Position(6, 4), player.getPosition());
    }
}