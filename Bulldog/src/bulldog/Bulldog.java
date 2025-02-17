/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bulldog;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Organizes the game of bulldog
 * @author James Tedder
 */
public class Bulldog {
    /**
     * This method runs the game of bulldog by using the various player classes.
     * @author James Tedder
     */
    public void run() {
        ArrayList<Player> players = new ArrayList<>();
        System.out.println("How many players?");
        Scanner scnr = new Scanner(System.in);
        int numPlayers = scnr.nextInt();
        
        for (int i = 1; i < numPlayers+1; i++) {
            System.out.println("What kind of player would you like Player " + i 
                    + " to be? Human, Random, Fifteen, or Unique");
            
            String type = scnr.next();
            while (!type.equals("Human") && !type.equals("Random") 
                    && !type.equals("Fifteen") && !type.equals("Unique")) {
                System.out.println("Please enter Human," 
                        + "Random, Fifteen, or Unique");
            }
            
            System.out.println("What would you like to name Player " + i + "?");
            String name = scnr.next();
            
            if (type.equals("Human")) {
                HumanPlayer human = new HumanPlayer(name);
                players.add(human);
            } else if (type.equals("Random")) {
                RandomPlayer random = new RandomPlayer(name);
                players.add(random);
            } else if (type.equals("Fifteen")) {
                FifteenPlayer fifteen = new FifteenPlayer(name);
                players.add(fifteen);
            } else if (type.equals("Unique")) {
                UniquePlayer unique = new UniquePlayer(name);
                players.add(unique);
            }
        }
        Player currPlayer = players.get(0);
        int highestScore = 0;
        while (highestScore < 104) {
            for (int i = 0; i < numPlayers; i++) {
                currPlayer = players.get(i);
                System.out.println("Player " + (i+1) + ", " 
                        + currPlayer.getName() + "'s turn");
                int turnScore = currPlayer.play();
                currPlayer.setScore(currPlayer.getScore() + turnScore);
                if (highestScore < currPlayer.getScore()) {
                    highestScore = currPlayer.getScore();
                }
                System.out.println("Player " + (i+1) + " ended the turn with " 
                        + currPlayer.getScore() + " points");
            }
        }
        System.out.println("Congratulations Player " + currPlayer.getName() 
                + " you win");
    }
    
    /**
     * Calls the run method
     * @param args the command line arguments
     * @author James Tedder
     */
    public static void main(String[] args) {
        Bulldog game = new Bulldog();
        game.run();
    }
    
}
