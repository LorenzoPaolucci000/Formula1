package it.unicam.cs.pa2024.formula1;

import java.util.Scanner;

/**
 *  Questa classe gestisce gli input del giocatore durante la gara.
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
        while (true) {
            System.out.print("Inserisci le coordinate della tua prossima mossa (dx dy): ");
            String input = scanner.nextLine().trim();
            int[] move = parseInput(input);
            if (move != null) {
                return move;
            }
            System.out.println("Input non valido. Per favore, inserisci due numeri interi separati da uno spazio.");
        }
    }

    /**
     * Metodo che converte l'input dell'utente in un array di due interi.
     *
     * @param input l'input dell'utente
     * @return un array di due interi se l'input è valido, altrimenti null
     */
    private int[] parseInput(String input) {
        String[] parts = input.split(" ");
        if (parts.length == 2) {
            try {
                int dx = Integer.parseInt(parts[0]);
                int dy = Integer.parseInt(parts[1]);
                return new int[]{dx, dy};
            } catch (NumberFormatException e) {
                return null;
            }
        }
        return null;
    }

}
