package it.unicam.cs.pa2024.formula1;

import java.util.ArrayList;
import java.util.List;

/**
 * Questa classe gestisce la simulazione della gara.
 */
public class GameEngine {
    private Track track;
    private List<Driver> drivers;

    /**
     * Costruisce un GameEngine con il tracciato e i piloti specificati.
     *
     * @param track il tracciato
     * @param drivers la lista dei driver
     */
    public GameEngine(Track track, List<Driver> drivers) {
        this.track = track;
        this.drivers = new ArrayList<>(drivers);
    }

    /**
     * Metodo che avvia la simulazione della gara e controlla le posizioni dei piloti durante il suo svolgimento verificandone la validità.
     *
     */
    public void startRace() {
        boolean raceFinished = false;
        int turn = 1;

        while (!raceFinished) {
            System.out.println("Turno " + turn);

            for (Driver driver : drivers) {
                driver.move(track);
                Position pos = driver.getPosition();
                System.out.println(driver.getName() + " è alla posizione (" + pos.getX() + ", " + pos.getY() + ")");
                // Verifica condizioni di vittoria
                if (track.getGrid()[pos.getX()][pos.getY()] == 'F') {
                    raceFinished = true;
                    System.out.println(driver.getName() + " ha vinto la gara!");
                    break;
                }
            }

            // Controlla collisioni e rimuovi i driver che causano collisioni
            checkCollisions();

            // Visualizza lo stato attuale della gara
            track.display(drivers);
            System.out.println();

            // Incrementa il turno
            turn++;
        }
    }


    /**
     * Metodo che controlla se ci sono collisioni tra i piloti e rimuove quelli che hanno causato incidenti.
     */
    private void checkCollisions() {
        List<Driver> driversToRemove = new ArrayList<>();

        for (int i = 0; i < drivers.size(); i++) {
            Driver driver1 = drivers.get(i);
            for (int j = i + 1; j < drivers.size(); j++) {
                Driver driver2 = drivers.get(j);
                if (driver1.getPosition().equals(driver2.getPosition())) {
                    System.out.println("Incidente tra " + driver1.getName() + " e " + driver2.getName() + " alla posizione (" + driver1.getPosition().getX() + ", " + driver1.getPosition().getY() + ")");
                    driversToRemove.add(driver1);
                    break;
                }
            }
        }

        drivers.removeAll(driversToRemove);
    }

}

