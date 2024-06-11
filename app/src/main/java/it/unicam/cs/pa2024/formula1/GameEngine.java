package it.unicam.cs.pa2024.formula1;

import java.util.ArrayList;
import java.util.Iterator;
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
     * Metodo che avvia la simulazione della gara e controlla il corretto processo dei turni di gioco dei piloti.
     *
     */
    public void startRace() {
        boolean raceFinished = false;
        int turn = 1;

        while (!raceFinished) {
            System.out.println("Turno " + turn);

            List<Driver> driversToRemove = new ArrayList<>();
            raceFinished = processTurn(driversToRemove);

            // Rimuovi i piloti che hanno causato collisioni
            drivers.removeAll(driversToRemove);

            // Visualizza lo stato attuale della gara
            track.display(drivers);
            System.out.println();

            // Incrementa il turno
            turn++;
        }
    }

    /**
     * Metodo che elabora i controlli durante un turno di gioco durante la gara analizzando le posizioni dei piloti durante il suo svolgimento verificandone la validità.
     *
     * @param driversToRemove la lista dei piloti da rimuovere a causa di collisioni (incidenti)
     * @return true se la gara è finita, false altrimenti
     */
    private boolean processTurn(List<Driver> driversToRemove) {
        boolean raceFinished = false;
        Iterator<Driver> iterator = drivers.iterator();

        while (iterator.hasNext()) {
            Driver driver = iterator.next();
            driver.move(track);
            Position pos = driver.getPosition();
            System.out.println(driver.getName() + " è alla posizione (" + pos.getX() + ", " + pos.getY() + ")");

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

    /**
     * Metodo che controlla se il pilota ha causato una collisione.
     *
     * @param driver il pilota che ha appena effettuato una mossa
     * @return true se è avvenuta una collisione, false altrimenti
     */
    private boolean checkCollisions(Driver driver) {
        for (Driver otherDriver : drivers) {
            if (!driver.equals(otherDriver) && driver.getPosition().equals(otherDriver.getPosition())) {
                System.out.println("Incidente tra " + driver.getName() + " e " + otherDriver.getName() + " alla posizione (" + driver.getPosition().getX() + ", " + driver.getPosition().getY() + ")");
                System.out.println("Pilota rimosso: " + driver.getName());
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo che verifica se un pilota ha raggiunto il traguardo.
     *
     * @param driver il pilota da verificare
     * @return true se il pilota ha vinto, false altrimenti
     */
    private boolean checkVictory(Driver driver) {
        Position pos = driver.getPosition();
        if (track.isValidPosition(pos) && track.getGrid()[pos.getY()][pos.getX()] == 'F') {
            System.out.println(driver.getName() + " ha vinto la gara!");
            return true;
        }
        return false;
    }

}

