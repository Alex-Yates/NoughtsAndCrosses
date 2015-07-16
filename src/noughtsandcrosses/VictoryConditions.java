/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noughtsandcrosses;

import java.util.*;

/**
 *
 * @author Alex
 */
public abstract class VictoryConditions {

    static Map<Integer, String> vc1set = new HashMap<>();
    static Map<Integer, String> vc2set = new HashMap<>();
    static Map<Integer, String> vc3set = new HashMap<>();
    static Map<Integer, String> vc4set = new HashMap<>();
    static Map<Integer, String> vc5set = new HashMap<>();
    static Map<Integer, String> vc6set = new HashMap<>();
    static Map<Integer, String> vc7set = new HashMap<>();
    static Map<Integer, String> vc8set = new HashMap<>();
    static Map<Integer, Map<Integer,String>> victoryConditions = new HashMap<>();

    static void refreshVcSets() {
        vc1set.clear();
        vc2set.clear();
        vc3set.clear();
        vc4set.clear();
        vc5set.clear();
        vc6set.clear();
        vc7set.clear();
        vc8set.clear();
        victoryConditions.clear();
        vc1set.put(0, (String) NoughtsAndCrosses.grid.get(0));
        vc1set.put(1, (String) NoughtsAndCrosses.grid.get(1));
        vc1set.put(2, (String) NoughtsAndCrosses.grid.get(2));
        vc2set.put(3, (String) NoughtsAndCrosses.grid.get(3));
        vc2set.put(4, (String) NoughtsAndCrosses.grid.get(4));
        vc2set.put(5, (String) NoughtsAndCrosses.grid.get(5));
        vc3set.put(6, (String) NoughtsAndCrosses.grid.get(6));
        vc3set.put(7, (String) NoughtsAndCrosses.grid.get(7));
        vc3set.put(8, (String) NoughtsAndCrosses.grid.get(8));
        vc4set.put(0, (String) NoughtsAndCrosses.grid.get(0));
        vc4set.put(3, (String) NoughtsAndCrosses.grid.get(3));
        vc4set.put(6, (String) NoughtsAndCrosses.grid.get(6));
        vc5set.put(1, (String) NoughtsAndCrosses.grid.get(1));
        vc5set.put(4, (String) NoughtsAndCrosses.grid.get(4));
        vc5set.put(7, (String) NoughtsAndCrosses.grid.get(7));
        vc6set.put(2, (String) NoughtsAndCrosses.grid.get(2));
        vc6set.put(5, (String) NoughtsAndCrosses.grid.get(5));
        vc6set.put(8, (String) NoughtsAndCrosses.grid.get(8));
        vc7set.put(0, (String) NoughtsAndCrosses.grid.get(0));
        vc7set.put(4, (String) NoughtsAndCrosses.grid.get(4));
        vc7set.put(8, (String) NoughtsAndCrosses.grid.get(8));
        vc8set.put(2, (String) NoughtsAndCrosses.grid.get(2));
        vc8set.put(4, (String) NoughtsAndCrosses.grid.get(4));
        vc8set.put(6, (String) NoughtsAndCrosses.grid.get(6));
        victoryConditions.put(0, vc1set);
        victoryConditions.put(1, vc2set);
        victoryConditions.put(2, vc3set);
        victoryConditions.put(3, vc4set);
        victoryConditions.put(4, vc5set);
        victoryConditions.put(5, vc6set);
        victoryConditions.put(6, vc7set);
        victoryConditions.put(7, vc8set);
    }

    static boolean vcSetComplete(Map vc) {
        if (!vc.get(0).equals(vc.get(1)) || !vc.get(1).equals(vc.get(2))) {
            return false;
        } else if (vc.containsValue(" ")) {
            return false;
        }
        return true;
    }

    static boolean gameWon() {
        refreshVcSets();
        boolean gameWon = false;
        for (Map vcSet : victoryConditions.values()) {
            if (vcSetComplete(vcSet)) {
                gameWon = true;
            }
        }
        if (gameWon){
            System.out.println("Game over!");
        }
        return gameWon;
    }
}
