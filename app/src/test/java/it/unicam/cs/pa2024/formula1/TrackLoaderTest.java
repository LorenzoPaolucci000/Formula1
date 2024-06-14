package it.unicam.cs.pa2024.formula1;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe di test per la classe TrackLoader.
 * Verifica il corretto caricamento dei tracciati dai relativi file di risorse.
 */
class TrackLoaderTest {

    /**
     * Verifica che il tracciato "CircuitoAperto.txt" venga caricato correttamente.
     * Controlla che il tracciato non sia null e che le posizioni di partenza e traguardo siano corrette.
     *
     * @throws IOException se si verifica un errore durante il caricamento del tracciato
     */
    @Test
    void testLoadTrackCircuitoAperto() throws IOException {
        // Assumendo che il file "CircuitoAperto.txt" esista nel classpath
        Track track = TrackLoader.loadTrack("CircuitoAperto.txt");
        assertNotNull(track, "Il tracciato non dovrebbe essere null");

        // Verifica delle posizioni della partenza e del traguardo
        char[][] grid = track.getGrid();
        assertEquals('S', grid[16][6], "La posizione di partenza dovrebbe essere 'S' alla posizione (16, 6)");
        assertEquals('S', grid[16][7], "La posizione di partenza dovrebbe essere 'S' alla posizione (16, 7)");
        assertEquals('S', grid[16][8], "La posizione di partenza dovrebbe essere 'S' alla posizione (16, 8)");
        assertEquals('S', grid[16][9], "La posizione di partenza dovrebbe essere 'S' alla posizione (16, 9)");
        assertEquals('S', grid[16][10], "La posizione di partenza dovrebbe essere 'S' alla posizione (16, 10)");
        assertEquals('S', grid[16][11], "La posizione di partenza dovrebbe essere 'S' alla posizione (16, 11)");
        assertEquals('S', grid[16][12], "La posizione di partenza dovrebbe essere 'S' alla posizione (16, 12)");
        assertEquals('S', grid[16][13], "La posizione di partenza dovrebbe essere 'S' alla posizione (16, 13)");
        assertEquals('F', grid[30][44], "La posizione del traguardo dovrebbe essere 'F' alla posizione (30, 44)");
        assertEquals('F', grid[30][45], "La posizione del traguardo dovrebbe essere 'F' alla posizione (30, 45)");
        assertEquals('F', grid[30][46], "La posizione del traguardo dovrebbe essere 'F' alla posizione (30, 46)");
        assertEquals('F', grid[30][47], "La posizione del traguardo dovrebbe essere 'F' alla posizione (30, 47)");
        assertEquals('F', grid[30][48], "La posizione del traguardo dovrebbe essere 'F' alla posizione (30, 48)");
        assertEquals('F', grid[30][49], "La posizione del traguardo dovrebbe essere 'F' alla posizione (30, 49)");
        assertEquals('F', grid[30][50], "La posizione del traguardo dovrebbe essere 'F' alla posizione (30, 50)");
        assertEquals('F', grid[30][51], "La posizione del traguardo dovrebbe essere 'F' alla posizione (30, 51)");
    }

    /**
     * Verifica che il tracciato "CircuitoAdAnello.txt" venga caricato correttamente.
     * Controlla che il tracciato non sia null e che le posizioni di partenza e traguardo siano corrette.
     *
     * @throws IOException se si verifica un errore durante il caricamento del tracciato
     */
    @Test
    void testLoadTrackCircuitoAdAnello() throws IOException {
        // Assumendo che il file "CircuitoAdAnello.txt" esista nel classpath
        Track track = TrackLoader.loadTrack("CircuitoAdAnello.txt");
        assertNotNull(track, "Il tracciato non dovrebbe essere null");

        // Verifica delle posizioni della partenza e del traguardo
        char[][] grid = track.getGrid();
        assertEquals('S', grid[16][6], "La posizione di partenza dovrebbe essere 'S' alla posizione (16, 6)");
        assertEquals('S', grid[16][7], "La posizione di partenza dovrebbe essere 'S' alla posizione (16, 7)");
        assertEquals('S', grid[16][8], "La posizione di partenza dovrebbe essere 'S' alla posizione (16, 8)");
        assertEquals('S', grid[16][9], "La posizione di partenza dovrebbe essere 'S' alla posizione (16, 9)");
        assertEquals('S', grid[16][10], "La posizione di partenza dovrebbe essere 'S' alla posizione (16, 10)");
        assertEquals('S', grid[16][11], "La posizione di partenza dovrebbe essere 'S' alla posizione (16, 11)");
        assertEquals('S', grid[16][12], "La posizione di partenza dovrebbe essere 'S' alla posizione (16, 12)");
        assertEquals('S', grid[16][13], "La posizione di partenza dovrebbe essere 'S' alla posizione (16, 13)");
        assertEquals('F', grid[17][6], "La posizione di partenza dovrebbe essere 'S' alla posizione (17, 6)");
        assertEquals('F', grid[17][7], "La posizione di partenza dovrebbe essere 'S' alla posizione (17, 7)");
        assertEquals('F', grid[17][8], "La posizione di partenza dovrebbe essere 'S' alla posizione (17, 8)");
        assertEquals('F', grid[17][9], "La posizione di partenza dovrebbe essere 'S' alla posizione (17, 9)");
        assertEquals('F', grid[17][10], "La posizione di partenza dovrebbe essere 'S' alla posizione (17, 10)");
        assertEquals('F', grid[17][11], "La posizione di partenza dovrebbe essere 'S' alla posizione (17, 11)");
        assertEquals('F', grid[17][12], "La posizione di partenza dovrebbe essere 'S' alla posizione (17, 12)");
        assertEquals('F', grid[17][13], "La posizione di partenza dovrebbe essere 'S' alla posizione (17, 13)");
    }

    /**
     * Verifica che venga lanciata un'eccezione IOException quando si tenta di caricare un file.txt che non esiste.
     */
    @Test
    void testLoadNonExistentTrack() {
        // Assicurandosi che venga sollevata un'eccezione quando si tenta di caricare un file che non esiste
        assertThrows(IOException.class, () -> TrackLoader.loadTrack("CircuitoNonEsistente.txt"),
                "Dovrebbe essere lanciata un'eccezione IOException per un file non esistente");
    }

}