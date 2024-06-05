package it.unicam.cs.pa2024.formula1;

import java.util.List;

/**
 * This class manages the race simulation.
 */
public class GameEngine {
    private Track track;
    private List<Driver> drivers;

    /**
     * Constructs a GameEngine with the specified track and drivers.
     *
     * @param track the track
     * @param drivers the list of drivers
     */
    public GameEngine(Track track, List<Driver> drivers) {
        this.track = track;
        this.drivers = drivers;
    }

    /**
     * Starts the race simulation.
     */
    public void startRace() {
        boolean raceFinished = false;
        int turn = 1;

        while (!raceFinished) {
            System.out.println("Turn " + turn);
            for (Driver driver : drivers) {
                driver.move(track);
                Position pos = driver.getPosition();
                System.out.println(driver.getName() + " is at position (" + pos.getX() + ", " + pos.getY() + ")");
                // Verifica condizioni di vittoria
                if (track.getGrid()[pos.getX()][pos.getY()] == 'F') {
                    raceFinished = true;
                    System.out.println(driver.getName() + " has won the race!");
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