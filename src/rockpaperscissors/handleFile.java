/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockpaperscissors;

import java.io.*;
import java.util.ArrayList;
import static rockpaperscissors.RockPaperScissors.*;

/**
 *
 * @author Kyle's PC
 */
public class handleFile {

    public handleFile() {

    }

    //Method that returns an integer arraylist of wins to init() method
    public static ArrayList<Integer> readPlayerWins() {

        count = 0;
        in = "";

        //Check if log file exists, if not, create one
        try {
            playerLog = new File("src/rockpaperscissors/PlayerLogs/playerLog.txt");
            if (!playerLog.exists()) {
                playerLog.createNewFile();
            }
            playerReader = new BufferedReader(new FileReader(playerLog));

        } catch (Exception e) {
            System.out.print("Error Missing File");
            e.printStackTrace();
        }

        //Add win counts from past players to arraylist from log file 
        do {

            try {
                in = (playerReader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("An Error Has Occured. Please Restart.");
            }

            if (in != null) {
                nums = "";
                for (int i = 0; i < in.length(); i++) {
                    if (Character.isDigit(in.charAt(i))) {
                        nums += in.charAt(i);

                    }
                }
                winCount = Integer.parseInt(nums);
                wins.add(winCount);

                count++;
            }

        } while (in != null);

        try {
            playerReader.close();
        } catch (IOException e) {
            System.out.println("An Error Has Occured. Please Restart.");
        }

        winCount = 0;
        return wins;

    }

    //Method that returns a string arraylist of names to init() method
    public static ArrayList<String> readPlayerNames() {

        count = 0;
        in = "";

        try {
            playerReader = new BufferedReader(new FileReader(playerLog));

        } catch (Exception e) {
            System.out.print("Error Missing File");
            e.printStackTrace();
        }

        //Add past player names to arraylist from log file
        do {

            try {
                in = (playerReader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (in != null) {
                names.add(in.substring(0, in.indexOf(":")));
                count++;
            }

        } while (in != null);

        try {
            playerReader.close();
        } catch (IOException e) {
            System.out.println("An Error Has Occured. Please Restart.");
        }

        return names;

    }

    //Method that writes new match information to log file, updates past information if necessary
    public static void writePlayerLog() {

        try {
            playerWriter = new BufferedWriter(new FileWriter(playerLog));

            for (int i = 0; i < names.size(); i++) {
                if (name.equalsIgnoreCase(names.get(i))) {
                    wins.set(index, winCount);
                }
                playerWriter.write(names.get(i) + ": Won " + wins.get(i) + " time(s)");
                playerWriter.newLine();

            }
        } catch (IOException e) {
            System.out.println("An Error Has Occured. Please Restart.");
        }

        try {
            playerWriter.close();
        } catch (IOException e) {
            System.out.println("An Error Has Occured. Please Restart.");
        }

    }
}
