package it.unicam.cs.pa2024.formula1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe di test per la classe Track.
 * Verifica che il tracciato, la griglia e le posizioni in cui si possono muovere i piloti siano corretti.
 */
class TrackTest {

    private Track track;

    /**
     * Metodo che carica un piccolo tracciato dal file CircuitoTest.txt .
     *
     * @throws IOException se si verifica un errore durante il caricamento del tracciato
     */
    @BeforeEach
    void setUp() throws IOException {
        track = TrackLoader.loadTrack("CircuitoTest.txt");
    }

    /**
     * Metodo che controlla se la griglia del tracciato corrisponde correttamente.
     *
     */
    @Test
    void testGetGrid() {
        char[][] expectedGrid = {
                {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                {'x', 'x', 'x', 'x', 'x', '-', '-', '-', 'F', 'F', 'F', '-', '-', '-', 'x', 'x', 'x', 'x', 'x'},
                {'x', 'x', 'x', 'x', 'x', '-', '-', '-', '-', '-', '-', '-', '-', '-', 'x', 'x', 'x', 'x', 'x'},
                {'x', 'x', 'x', 'x', 'x', '-', '-', '-', '-', '-', '-', '-', '-', '-', 'x', 'x', 'x', 'x', 'x'},
                {'x', 'x', 'x', 'x', 'x', '-', '-', '-', '-', '-', '-', '-', '-', '-', 'x', 'x', 'x', 'x', 'x'},
                {'x', 'x', 'x', 'x', 'x', '-', '-', '-', '-', '-', '-', '-', '-', '-', 'x', 'x', 'x', 'x', 'x'},
                {'x', 'x', 'x', 'x', 'x', '-', '-', '-', 'S', 'S', 'S', '-', '-', '-', 'x', 'x', 'x', 'x', 'x'},
                {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}
        };

        assertArrayEquals(expectedGrid, track.getGrid(), "La griglia del tracciato non corrisponde a quella attesa");
    }

    /**
     * Metodo che controlla se le varie posizioni all'interno e all'esterno del tracciato sono valide oppure no.
     * Si ricorda che il carattere '-' indica il tracciato e il carattere 'x' indica le zone fuori pista.
     */
    @Test
    void testIsValidPosition() {
        assertTrue(track.isValidPosition(new Position(6, 3)), "La posizione (6, 3) dovrebbe essere valida");
        assertFalse(track.isValidPosition(new Position(0, 0)), "La posizione (0, 0) non dovrebbe essere valida ('x')");
        assertFalse(track.isValidPosition(new Position(10, 10)), "La posizione (10, 10) non dovrebbe essere valida (fuori dal confine della griglia)");
        assertTrue(track.isValidPosition(new Position(8, 6)), "La posizione (8, 6) dovrebbe essere valida");
    }

}
