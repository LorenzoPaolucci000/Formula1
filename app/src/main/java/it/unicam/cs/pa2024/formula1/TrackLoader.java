package it.unicam.cs.pa2024.formula1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class provides functionality to load a track from a file.
 */
public class TrackLoader {
    /**
     * Loads a track from the specified resource file.
     *
     * @param fileName the name of the resource file
     * @return the loaded Track
     * @throws IOException if an I/O error occurs
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