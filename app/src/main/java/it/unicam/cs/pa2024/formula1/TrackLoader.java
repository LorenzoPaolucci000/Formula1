package it.unicam.cs.pa2024.formula1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Questa classe fornisce funzionalità per caricare un tracciato da un file.txt.
 */
public class TrackLoader {
    /**
     * Carica un tracciato dal file di risorsa specificato.
     *
     * @param fileName il nome del file di risorsa
     * @return il tracciato caricato
     * @throws IOException se si verifica un errore di I/O
     */
    public static Track loadTrack(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                TrackLoader.class.getClassLoader().getResourceAsStream(fileName), StandardCharsets.UTF_8))) {
            List<String> lines = reader.lines().toList();
            int rows = lines.size();
            int cols = lines.get(0).length();
            char[][] grid = new char[rows][cols];

            for (int i = 0; i < rows; i++) {
                grid[i] = lines.get(i).toCharArray();
            }

            return new Track(grid);
        }
    }
}
