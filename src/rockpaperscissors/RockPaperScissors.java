/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockpaperscissors;

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Kyle Lukaszek
 * 
 */
public class RockPaperScissors {

    public static String name, result, in, nums;
    public static int round, rounds, playerThrow, aiThrow, pScore, cScore, winCount, count, index;
    public static File playerLog;
    public static BufferedWriter playerWriter;
    public static BufferedReader playerReader;
    public static ArrayList<String> names = new ArrayList();
    public static ArrayList<Integer> wins = new ArrayList();

    /**
     * Prompts user for name, checks log file for previous players and win counts. 
     * Prompts user for desired amount of rounds of rock paper scissors. 
     * Prompts user for play choice (rock, paper, or scissors) and compares to random computer number.
     * Repeat until someone wins. 
     * Prompt user if they would like to play again. Write match information and updated information to log file.
     */
    
    //initiate play method loop
    public static void main(String[] args) {
        play();
    }

    //initialize variables and run game, 
    public static void play() {

        init();
        game();

    }

    //Method that initializes variables, questions user for name and checks file for existing names and scores
    public static void init() {

        wins.clear();
        names.clear();
        winCount = 0;
        index = 0;
        wins = handleFile.readPlayerWins();
        names = handleFile.readPlayerNames();
        name = Player.getName();
        rounds = Player.getRounds();
        pScore = 0;
        cScore = 0;

    }

    //Method that runs game, gets plays and checks if someones has won
    public static void game() {

        round = 1;

        for (int i = 1; i <= rounds; i++) {

            System.out.println("\nRound " + round + ": ");
            Player.getThrow();
            playerThrow = Player.returnThrow();
            System.out.println(name + " throws " + Player.thrown());
            aiThrow = AI.getThrow();
            System.out.println("Computer throws " + AI.thrown());
            System.out.println(check());
            round++;

            if (playerThrow == aiThrow) {           //If round is a tie, round = same
                i--;
                round--;
            }

            if (pScore > rounds / 2) {
                System.out.println("The winner is " + name + "! The computer lost the game.");
                winCount++;
                break;
            } else if (cScore > rounds / 2) {
                System.out.println("The winner is the computer! " + name + " lost the game.");
                break;
            }
        }

        if (pScore == cScore) {
            System.out.println("The game ended in a tie! There is no winner.");
        }

        handleFile.writePlayerLog();
        replay();

    }

    //Method that checks who wins the round and returns this result to the game() method
    public static String check() {

        if (playerThrow == 1 && aiThrow == 3 || playerThrow == 2 && aiThrow == 1 || playerThrow == 3 && aiThrow == 2) {
            result = name + " Wins!";
            pScore++;
        } else if (aiThrow == 1 && playerThrow == 3 || aiThrow == 2 && playerThrow == 1 || aiThrow == 3 && playerThrow == 2) {
            result = "Computer Wins!";
            cScore++;
        } else {
            result = "This round was a tie. Try again.";
        }

        return result;

    }

    //Method that prompts user if they would like to play again
    public static void replay() {

        System.out.println("\nWould you like to play again? (1 = Yes / 2 = No)");
        Scanner in = new Scanner(System.in);
        String input = in.next();

        for (char a : input.toCharArray()) {
            if (!Character.isDigit(a)) {
                System.out.println("Please choose 1 or 2");
                replay();
            }
        }

        int choice = Integer.parseInt(input);

        if (choice == 1) {
            System.out.println();
            play();
        } else if (choice == 2) {
            System.exit(0);

        } else {
            System.out.println("Please choose 1 or 2");
            replay();
        }

    }
}
