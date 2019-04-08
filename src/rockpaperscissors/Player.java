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
public class Player {

    public static String name, choice;
    public static int playerThrow, rounds;
    public static Scanner in = new Scanner(System.in);
    public static boolean check = false;

    public Player() {

    }

    public static String getName() {

        System.out.println("Please enter your name: ");
        name = in.next();

        return name;
    }

    public static int getRounds() {
        System.out.println("Please enter the # of rounds you would like to play: ");
        rounds = in.nextInt();

        return rounds;
    }

    public static void getThrow() {
        System.out.println("1 = Rock / 2 = Paper / 3 = Scissors");
        System.out.println("Please enter your throw: ");
        playerThrow = in.nextInt();
        if (playerThrow == 0 || playerThrow > 3) {
                System.out.println("Please input 1, 2, or 3");
                Player.getThrow();
            } 
    }

    public static String thrown() {
        if (playerThrow == 1) {
            choice = "Rock";
        }else if(playerThrow == 2){
            choice = "Paper";
        }else if (playerThrow == 3){
            choice = "Scissors";
        }
        return choice;
    }
    
    public static int returnThrow(){
            
            return playerThrow;
    }
    
}


