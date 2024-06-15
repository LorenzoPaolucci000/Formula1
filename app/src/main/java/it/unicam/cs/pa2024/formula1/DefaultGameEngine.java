package it.unicam.cs.pa2024.formula1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Questa classe gestisce la simulazione della gara.
 */
public class DefaultGameEngine implements GameEngine{
    private Track track;
    private List<Driver> drivers;

    /**
     * Costruisce un DefaultGameEngine con il tracciato e i piloti specificati.
     *
     * @param track il tracciato
     * @param drivers la lista dei driver
     */
    public DefaultGameEngine(Track track, List<Driver> drivers) {
        this.track = track;
        this.drivers = new ArrayList<>(drivers);
    }

    @Override
    public void startRace() {
        boolean raceFinished = false;
        int turn = 1;

        while (!raceFinished) {
            System.out.println("Turno " + turn);

            List<Driver> driversToRemove = new ArrayList<>();
            raceFinished = processTurn(driversToRemove);

            // Rimuove i piloti che hanno causato collisioni
            drivers.removeAll(driversToRemove);

            // Visualizza lo stato attuale della gara
            track.display(drivers);
            System.out.println();

            // Incrementa il turno
            turn++;
        }
    }
    @Override
    public boolean processTurn(List<Driver> driversToRemove) {
        boolean raceFinished = false;
        Iterator<Driver> iterator = drivers.iterator();

        while (iterator.hasNext()) {
            Driver driver = iterator.next();
            driver.move(track);
            Position pos = driver.getPosition();
            System.out.println(driver.getName() + " si trova alla posizione (" + pos.getX() + ", " + pos.getY() + ")");

            // Verifica condizioni di vittoria
            if (track.isValidPosition(pos) && checkVictory(driver)) {
                raceFinished = true;
                break;
            }

            // Controlla collisioni dopo ogni mossa
            if (checkCollisions(driver)) {
                driversToRemove.add(driver);
            }
        }

        return raceFinished;
    }

    @Override
    public boolean checkCollisions(Driver driver) {
        for (Driver otherDriver : drivers) {
            if (!driver.equals(otherDriver) && driver.getPosition().equals(otherDriver.getPosition())) {
                System.out.println("Incidente tra " + driver.getName() + " e " + otherDriver.getName() + " alla posizione (" + driver.getPosition().getX() + ", " + driver.getPosition().getY() + ")");
                System.out.println("Pilota rimosso: " + driver.getName());
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean checkVictory(Driver driver) {
        Position pos = driver.getPosition();
        if (track.isValidPosition(pos) && track.getGrid()[pos.getY()][pos.getX()] == 'F') {
            System.out.println(driver.getName() + " ha vinto la gara!");
            return true;
        }
        return false;
    }

}

