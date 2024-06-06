package it.unicam.cs.pa2024.formula1;

import java.util.List;
import java.util.Scanner;
/**
 * Questa classe gestisce la visualizzazione del menu e delle regole del gioco.
 */
public class Menu {
    /**
     * Visualizza il menu e le regole del gioco.
     */
    public static void displayMenu() {
        System.out.println("****************************************************");
        System.out.println("*                     FORMULA 1                    *");
        System.out.println("****************************************************");
        System.out.println("*                                                  *");
        System.out.println("*               BENVENUTO NEL GIOCO DI             *");
        System.out.println("*                   FORMULA 1                      *");
        System.out.println("*                                                  *");
        System.out.println("*                di Lorenzo Paolucci               *");
        System.out.println("*                                                  *");
        System.out.println("****************************************************");
        System.out.println("*                  REGOLE DEL GIOCO                *");
        System.out.println("*                                                  *");
        System.out.println("* 1. Ogni giocatore sceglie una direzione          *");
        System.out.println("*    da muovere la propria macchina.               *");
        System.out.println("* 2. Puoi muoverti di massimo tre caselle per volta*"); //TODO Da rivedere
        System.out.println("*    nelle direzioni: su, giù, sinistra, destra.   *");
        System.out.println("* 3. Non è possibile andare fuori dal confine del  *");
        System.out.println("*    circuito.                                     *");
        System.out.println("*                                                  *");
        System.out.println("*                   COME GIOCARE                   *");
        System.out.println("* - Ad ogni turno, inserisci le coordinate del     *");
        System.out.println("*   tuo movimento.                                 *");
        System.out.println("* - Esempio: per muoverti in alto verso destra,    *");
        System.out.println("*   digita: '1 2' (dx e dy)                        *");
        System.out.println("*                                                  *");
        System.out.println("*                   OBIETTIVO                      *");
        System.out.println("* L'obiettivo è arrivare per primo al traguardo.   *");
        System.out.println("*                                                  *");
        System.out.println("*                  BUONA FORTUNA!                  *");
        System.out.println("****************************************************");
        System.out.println();

        System.out.println("Seleziona il circuito che preferisci");
        System.out.println("Digita: 'CircuitoAperto' oppure 'CircuitoAdAnello' e premi invio per confermare la scelta");
    }

    /**
     * Ottiene l'input validato dall'utente.
     *
     * @param scanner lo scanner per legger l'input
     * @param validOptions le opzioni valide (CircuitoAperto o CircuitoAdAnello)
     * @return l'opzione selezionata dall'utente
     */
    public static String getValidatedInput(Scanner scanner, List<String> validOptions) {
        String trackSelected = "";
        boolean validInput = false;

        while (!validInput) {
            trackSelected = scanner.nextLine().trim();
            if (validOptions.contains(trackSelected)) {
                validInput = true;
            } else {
                System.out.println("Input non valido. Per favore, digita una delle seguenti opzioni: " + validOptions);
            }
        }

        return trackSelected;
    }
}

