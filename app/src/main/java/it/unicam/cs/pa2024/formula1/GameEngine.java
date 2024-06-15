package it.unicam.cs.pa2024.formula1;
import java.util.List;

/**
 * Questa interfaccia rapprensenta un generico GameEngine per gestire la simulazione della gara.
 */
public interface GameEngine {

    /**
     * Metodo che avvia la simulazione della gara e controlla il corretto processo dei turni di gioco dei piloti.
     */
    void startRace();

    /**
     * Metodo che elabora i controlli durante un turno di gioco durante la gara analizzando le posizioni dei piloti durante il suo svolgimento verificandone la validità.
     *
     * @param driversToRemove la lista dei piloti da rimuovere a causa di collisioni (incidenti)
     * @return true se la gara è finita, false altrimenti
     */
    boolean processTurn(List<Driver> driversToRemove);

    /**
     * Metodo che verifica se un pilota ha raggiunto il traguardo.
     *
     * @param driver il pilota da verificare
     * @return true se il pilota ha vinto, false altrimenti
     */
    boolean checkVictory(Driver driver);

    /**
     * Metodo che controlla se il pilota ha causato una collisione.
     *
     * @param driver il pilota che ha appena effettuato una mossa
     * @return true se è avvenuta una collisione, false altrimenti
     */
    boolean checkCollisions(Driver driver);
}