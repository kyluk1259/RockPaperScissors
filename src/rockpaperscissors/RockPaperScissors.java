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
public class RockPaperScissors {

    public static String name, result;
    public static int round, rounds, playerThrow, aiThrow, pScore, cScore;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        play();
    }
    
    public static void play(){
        init();
        game();
    } 

    public static void init() {
        name = Player.getName();
        rounds = Player.getRounds();
        pScore = 0;
        cScore = 0;
    }

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
            
            if (playerThrow == aiThrow) {
                i--;
                round--;
            }
        }

        if (pScore > cScore) {
            System.out.println("The winner is " + name + "! The computer lost the game.");
        } else if (pScore < cScore) {
            System.out.println("The winner is the computer! " + name + " lost the game.");
        } else {
            System.out.println("The game ended in a tie! There is no winner.");
        }
        
        replay();

    }

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

    public static void replay(){
        System.out.println("\nWould you like to play again? (1 = Yes / 2 = No)");
        Scanner in = new Scanner(System.in);
        String input = in.next();
        
        int choice = Integer.parseInt(input);
        
        if(choice == 1){
            play();
        }else if(choice == 2){
            System.exit(0);
        }else{
           System.out.println("Please choose 1 or 2");
           replay();
        }
}
    
}


