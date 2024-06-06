package it.unicam.cs.pa2024.formula1;

import java.util.List;

/**
 * Questa classe gestisce la simulazione della gara.
 */
public class GameEngine {
    private Track track;
    private List<DriverInterface> drivers;

    /**
     * Costruisce un GameEngine con il tracciato e i piloti specificati.
     *
     * @param track il tracciato
     * @param drivers la lista dei driver
     */
    public GameEngine(Track track, List<DriverInterface> drivers) {
        this.track = track;
        this.drivers = drivers;
    }

    /**
     * Avvia la simulazione della gara e controlla le posizioni dei piloti durante il suo svolgimento.
     *
     */
    public void startRace() {
        boolean raceFinished = false;
        int turn = 1;

        while (!raceFinished) {
            System.out.println("Turno " + turn);
            for (DriverInterface driver : drivers) {
                driver.move(track);
                Position pos = driver.getPosition();
                System.out.println(driver.getName() + " è alla posizione (" + pos.getX() + ", " + pos.getY() + ")");
                // Verifica le condizioni di vittoria
                if (track.isValidPosition(pos) && track.getGrid()[pos.getY()][pos.getX()] == 'F') {
                    raceFinished = true;
                    System.out.println(driver.getName() + " ha vinto la gara!");
                    break;
                }
            }
            // Visualizza lo stato attuale della gara
            track.display(drivers);
            System.out.println();

            // Incrementa il turno
            turn++;
        }
    }
}
