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

    static List vc1set = new ArrayList();
    static List vc2set = new ArrayList();
    static List vc3set = new ArrayList();
    static List vc4set = new ArrayList();
    static List vc5set = new ArrayList();
    static List vc6set = new ArrayList();
    static List vc7set = new ArrayList();
    static List vc8set = new ArrayList();
    static Map<Integer, List> victoryConditions = new HashMap<>();

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
        vc1set.add(NoughtsAndCrosses.grid.get(0));
        vc1set.add(NoughtsAndCrosses.grid.get(1));
        vc1set.add(NoughtsAndCrosses.grid.get(2));
        vc2set.add(NoughtsAndCrosses.grid.get(3));
        vc2set.add(NoughtsAndCrosses.grid.get(4));
        vc2set.add(NoughtsAndCrosses.grid.get(5));
        vc3set.add(NoughtsAndCrosses.grid.get(6));
        vc3set.add(NoughtsAndCrosses.grid.get(7));
        vc3set.add(NoughtsAndCrosses.grid.get(8));
        vc4set.add(NoughtsAndCrosses.grid.get(0));
        vc4set.add(NoughtsAndCrosses.grid.get(3));
        vc4set.add(NoughtsAndCrosses.grid.get(6));
        vc5set.add(NoughtsAndCrosses.grid.get(1));
        vc5set.add(NoughtsAndCrosses.grid.get(4));
        vc5set.add(NoughtsAndCrosses.grid.get(7));
        vc6set.add(NoughtsAndCrosses.grid.get(2));
        vc6set.add(NoughtsAndCrosses.grid.get(5));
        vc6set.add(NoughtsAndCrosses.grid.get(8));
        vc7set.add(NoughtsAndCrosses.grid.get(0));
        vc7set.add(NoughtsAndCrosses.grid.get(4));
        vc7set.add(NoughtsAndCrosses.grid.get(8));
        vc8set.add(NoughtsAndCrosses.grid.get(2));
        vc8set.add(NoughtsAndCrosses.grid.get(4));
        vc8set.add(NoughtsAndCrosses.grid.get(6));
        victoryConditions.put(0, vc1set);
        victoryConditions.put(1, vc2set);
        victoryConditions.put(2, vc3set);
        victoryConditions.put(3, vc4set);
        victoryConditions.put(4, vc5set);
        victoryConditions.put(5, vc6set);
        victoryConditions.put(6, vc7set);
        victoryConditions.put(7, vc8set);
    }

    static boolean vcSetComplete(List vc) {
        if (!vc.get(0).equals(vc.get(1)) || !vc.get(1).equals(vc.get(2))) {
            return false;
        } else if (vc.contains(" ")) {
            return false;
        }
        return true;
    }

    static boolean gameWon() {
        refreshVcSets();
        boolean gameWon = false;
        for (List vcSet : victoryConditions.values()) {
            if (vcSetComplete(vcSet)) {
                gameWon = gameWon && vcSetComplete(vcSet);
            }
        }
        if (gameWon){
            System.out.println("Game over!");
        }
        return gameWon;
    }    
}
