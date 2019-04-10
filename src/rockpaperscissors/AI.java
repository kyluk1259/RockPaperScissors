/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockpaperscissors;

import java.util.Scanner;

/**
 *
 * @author Kyle's PC
 */
public class AI {

    public static int aiThrow, rand;
    public static String choice;
    public static Scanner in = new Scanner(System.in);

    public AI() {

    }

    //Get random play from computer and return it to game() method as int
    public static int getThrow() {

        rand = (int) (Math.random() * 2) + 1;
        aiThrow = rand;

        return aiThrow;
    }

    //Get name of random play from computer and return it to game() method
    public static String thrown() {
        if (aiThrow == 1) {
            choice = "Rock";
        } else if (aiThrow == 2) {
            choice = "Paper";
        } else {
            choice = "Scissors";
        }
        return choice;
    }
}
