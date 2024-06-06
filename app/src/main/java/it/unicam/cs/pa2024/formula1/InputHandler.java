package it.unicam.cs.pa2024.formula1;

import java.util.Scanner;

/**
 *  Questa classe gestisce gli input del giocatore durante la gara del gioco.
 */
public class InputHandler {
    private Scanner scanner;

    /**
     * Metodo costruttore per la classe InputHandler.
     *
     * @param scanner per inserire gli input
     */
    public InputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Metodo che richiede all'utente di inserire le coordinate dx e dy della prossima mossa
     * e restituisce un array di due interi dx e dy.
     *
     * @return un array di due interi che rappresenta lo spostamento dx e dy
     */
    public int[] getMove() {
        System.out.println("Inserisci le coordinate della tua prossima mossa (dx dy): ");
        int dx = scanner.nextInt();
        int dy = scanner.nextInt();
        return new int[]{dx, dy};
    }
}
