package it.unicam.cs.pa2024.formula1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe di test per la classe GameEngine.
 * Verifica il corretto svolgimento della gara avviando una simulazione con tre piloti bot.
 */
class GameEngineTest {


    private Track track;
    private List<Driver> drivers;
    private GameEngine gameEngine;

    /**
     * Metodo che carica un piccolo tracciato (dal file CircuitoTest.txt) e crea una lista di piloti bot per prepare una simulazione di gara.
     *
     * @throws IOException se si verifica un errore durante il caricamento del tracciato
     */
    @BeforeEach
    void setUp() throws IOException {
        // Carica il tracciato dal file CircuitoTest.txt
        track = TrackLoader.loadTrack("CircuitoTest.txt");

        // Crea una lista di driver per i test
        List<Position> movesBot1 = Arrays.asList(new Position(8, 4), new Position(9, 2), new Position(8, 1));
        List<Position> movesBot2 = Arrays.asList(new Position(8, 4), new Position(7, 2), new Position(9, 1));
        List<Position> movesBot3 = Arrays.asList(new Position(10, 4), new Position(9, 2), new Position(10, 1));
        drivers = new ArrayList<>();
        drivers.add(new Bot("Bot1", new Position(8, 6), '1', movesBot1));
        drivers.add(new Bot("Bot2", new Position(9, 6), '2', movesBot2));
        drivers.add(new Bot("Bot3", new Position(10, 6), '3', movesBot3));

        gameEngine = new GameEngine(track, drivers);
    }

    /**
     * Simula la gara e verifica che ci siano state le dovute collisioni tra i bot.
     */
    @Test
    void testCollisionBetweenBots() {
        // Simula la gara fino a verificare la collisione
        boolean collisionDetected = false;
        List<Driver> driversToRemove = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            track.display(drivers);
            gameEngine.processTurn(driversToRemove);
            if (driversToRemove.size()==2) {
                collisionDetected = true;
                track.display(drivers);
                break;
            }
        }
        assertTrue(collisionDetected, "Dovrebbe esserci un incidente tra Bot1 e Bot2 causato da: Bot2 e successivamente un incidente tra Bot1 e Bot3 causato da: Bot3");
    }

    /**
     * Simula la gara fino a verificare la vittoria di un pilota (Bot1 in questo caso)
     */
    @Test
    void testVictory() {

        boolean botVictory = false;

        while (true) {
            gameEngine.processTurn(new ArrayList<>());
            for (Driver driver : drivers) {
                if (driver.getName().equals("Bot1") && track.getGrid()[driver.getPosition().getY()][driver.getPosition().getX()] == 'F') {
                    botVictory = true;
                    break;
                }
            }
            if (botVictory) {
                break;
            }
        }
        assertTrue(botVictory, "Bot1 dovrebbe vincere la gara");
    }


}