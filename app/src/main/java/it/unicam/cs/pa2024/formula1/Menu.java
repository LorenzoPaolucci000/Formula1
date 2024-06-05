package it.unicam.cs.pa2024.formula1;

import java.util.List;
import java.util.Scanner;

public class Menu {

    public static void displayMenu() {
        System.out.println("****************************************************");
        System.out.println("*                     FORMULA 1                    *");
        System.out.println("****************************************************");
        System.out.println("*                                                  *");
        System.out.println("*               BENVENUTO NEL GIOCO DI             *");
        System.out.println("*                   FORMULA 1                      *");
        System.out.println("*                                                  *");
        System.out.println("****************************************************");
        System.out.println("*                  REGOLE DEL GIOCO                *");
        System.out.println("*                                                  *");
        System.out.println("* 1. Ogni giocatore sceglie una direzione          *");
        System.out.println("*    da muovere la propria macchina.               *");
        System.out.println("* 2. Puoi muoverti di una casella per volta nelle  *"); //TODO Da rivedere
        System.out.println("*    direzioni: su, giù, sinistra, destra.         *");
        System.out.println("* 3. Non è possibile attraversare le barriere del  *");
        System.out.println("*    circuito.                                     *");
        System.out.println("*                                                  *");
        System.out.println("*                   COME GIOCARE                   *");
        System.out.println("* - Ad ogni turno, inserisci le coordinate del    *");
        System.out.println("*   tuo movimento.                                 *");
        System.out.println("* - Esempio: per muoverti verso destra, digita     *");
        System.out.println("*   '1,0'.                                         *");
        System.out.println("*                                                  *");
        System.out.println("*                   OBIETTIVO                      *");
        System.out.println("* L'obiettivo è arrivare al traguardo per primo.   *");
        System.out.println("*                                                  *");
        System.out.println("*                  BUONA FORTUNA!                  *");
        System.out.println("****************************************************");
        System.out.println();

        // Visualizzare il menu per la selezione del circuito
        System.out.println("Seleziona il circuito che preferisci");
        System.out.println("Digita: 'CircuitoAperto' oppure 'CircuitoAdAnello' e premi invio per confermare la scelta");
    }

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

