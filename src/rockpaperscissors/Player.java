/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockpaperscissors;

import java.util.Scanner;
import static rockpaperscissors.RockPaperScissors.*;

/**
 *
 * @author Kyle's PC
 */
public class Player {

    public static String name, choice, numb;
    public static int playerThrow, rounds;
    public static Scanner in = new Scanner(System.in);
    public static boolean check = false;

    public Player() {

    }

    //Get player name and check if name already exists in leaderboard, if so, match their statistics, then return name to init() as String
    public static String getName() {

        System.out.println("Please enter your name: ");
        name = in.next();

        for (int i = 0; i < names.size(); i++) {
            if (name.equalsIgnoreCase(names.get(i))) {
                winCount = wins.get(i);
                System.out.println("You have won " + winCount + " times.");
                index = i;
                return name;
            }
        }

        names.add(name);
        wins.add(0);
        System.out.println("You have won " + winCount + " times.");
        return name;
    }

    //Get amount of rounds from player and return to init() method as int
    public static int getRounds() {
        System.out.println("\nPlease enter the # of rounds you would like to play: ");
        
        numb = in.next();
        
        for(char a : numb.toCharArray()){
            if(!Character.isDigit(a)){
                getRounds();
            }
        }
        
        rounds = Integer.parseInt(numb);

        return rounds;
    }

    //Get play from player
    public static void getThrow() {
        System.out.println("1 = Rock / 2 = Paper / 3 = Scissors");
        System.out.println("Please enter your throw: ");
        
        numb = in.next();
        
        for(char a : numb.toCharArray()){
            if(!Character.isDigit(a)){
                getThrow();
            }
        }
        
        playerThrow = Integer.parseInt(numb);
        
        if (playerThrow == 0 || playerThrow > 3) {
            System.out.println("Please input 1, 2, or 3");
            getThrow();
        }
    }

    //Get name of play from player and return it to game() method as string
    public static String thrown() {
        if (playerThrow == 1) {
            choice = "Rock";
        } else if (playerThrow == 2) {
            choice = "Paper";
        } else {
            choice = "Scissors";
        }
        return choice;
    }

    //Return play from player as int to game() method after having it checked
    public static int returnThrow() {

        return playerThrow;
    }

}
