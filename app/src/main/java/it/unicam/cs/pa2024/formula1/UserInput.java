package it.unicam.cs.pa2024.formula1;
/**
 * Questa interfaccia rappresenta le funzionalità gestire gli input dell'utente durante la gara.
 */
public interface UserInput {

    /**
     * Metodo che richiede all'utente di inserire le coordinate dx e dy della prossima mossa
     * e restituisce un array di due interi dx e dy.
     *
     * @return un array di due interi che rappresenta lo spostamento dx e dy
     */
    int[] getMove();
}