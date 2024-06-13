package it.unicam.cs.pa2024.formula1;

import java.util.Arrays;
import java.util.List;
/**
 * Questa classe serve per raccogliere le posizioni dei vari Bot in modo da renderli competitivi in entrambi i tracciati.
 *
 */
public class BotMoves {

    /**
     * Restituisce la lista delle posizioni per il Bot1.
     *
     * @return una lista di posizioni che rappresentano le mosse del Bot1.
     */
    public static List<Position> getMovesBot1() {
        return Arrays.asList(
                new Position(8, 14), new Position(10, 11), new Position(13, 9), new Position(16, 7),
                new Position(19, 6), new Position(22, 5), new Position(25, 4), new Position(28, 4),
                new Position(31, 4), new Position(34, 4), new Position(37, 4), new Position(40, 4),
                new Position(43, 6), new Position(46, 7), new Position(49, 8), new Position(52, 9),
                new Position(55, 10), new Position(58, 11), new Position(61, 12), new Position(64, 13),
                new Position(67, 15), new Position(70, 16), new Position(73, 19), new Position(70, 21),
                new Position(67, 23), new Position(64, 23), new Position(61, 24), new Position(58, 25),
                new Position(55, 27), new Position(52, 28), new Position(50, 30), new Position(47, 30),
                new Position(44, 30), new Position(41, 30), new Position(38, 30), new Position(36, 28),
                new Position(33, 28), new Position(30, 28), new Position(27, 28), new Position(25, 27),
                new Position(22, 26), new Position(19, 25), new Position(16, 24), new Position(13, 23),
                new Position(10, 22), new Position(11, 19), new Position(11, 17)
        );
    }

    /**
     * Restituisce la lista delle posizioni per il Bot2.
     *
     * @return una lista di posizioni che rappresentano le mosse del Bot2.
     */
    public static List<Position> getMovesBot2() {
        return Arrays.asList(
                new Position(9, 14), new Position(12, 11), new Position(15, 9), new Position(18, 6),
                new Position(21, 5), new Position(24, 4), new Position(27, 4), new Position(30, 4),
                new Position(33, 4), new Position(36, 4), new Position(39, 4), new Position(42, 6),
                new Position(45, 7), new Position(48, 8), new Position(51, 9), new Position(54, 10),
                new Position(57, 11), new Position(60, 13), new Position(63, 14), new Position(66, 14),
                new Position(69, 15), new Position(72, 17), new Position(73, 20), new Position(70, 21),
                new Position(67, 23), new Position(64, 23), new Position(61, 24), new Position(58, 25),
                new Position(55, 27), new Position(52, 28), new Position(49, 29), new Position(46, 29),
                new Position(45, 30), new Position(42, 29), new Position(39, 29), new Position(36, 28),
                new Position(33, 27), new Position(30, 26), new Position(27, 26), new Position(24, 26),
                new Position(21, 25), new Position(18, 24), new Position(15, 23), new Position(13, 21),
                new Position(12, 18), new Position(12, 17)
        );
    }

    /**
     * Restituisce la lista delle posizioni per il Bot3.
     *
     * @return una lista di posizioni che rappresentano le mosse del Bot3.
     */
    public static List<Position> getMovesBot3() {
        return Arrays.asList(
                new Position(10, 14), new Position(13, 11), new Position(16, 8), new Position(19, 5),
                new Position(22, 4), new Position(25, 4), new Position(28, 4), new Position(31, 4),
                new Position(34, 4), new Position(37, 4), new Position(40, 5), new Position(43, 7),
                new Position(46, 8), new Position(49, 8), new Position(52, 9), new Position(55, 10),
                new Position(58, 11), new Position(61, 14), new Position(64, 14), new Position(67, 15),
                new Position(70, 16), new Position(73, 19), new Position(70, 22), new Position(67, 23),
                new Position(64, 23), new Position(61, 23), new Position(58, 25), new Position(55, 27),
                new Position(52, 28), new Position(49, 29), new Position(46, 30), new Position(43, 30),
                new Position(40, 29), new Position(37, 28), new Position(34, 27), new Position(31, 26),
                new Position(28, 26), new Position(25, 27), new Position(22, 24), new Position(19, 24),
                new Position(16, 23), new Position(13, 22), new Position(13, 19), new Position(13, 17)
        );
    }
}
