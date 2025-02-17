/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bulldog;

import java.util.Scanner;

/**
 * This class allows a human to play bulldog
 * @author James Tedder
 */
public class HumanPlayer extends Player {
    
    /**
     * Constructor for when no name is provided
     */
    public HumanPlayer() {
        super("Human");
    }
    
    /**
     * Constructor for when a name is provided
     * @param name the name of the player
     */
    public HumanPlayer(String name) {
        super(name);
    }
    
    /**
     * Allows the Human to control the actions during play 
     * @return 
     */
    @Override
    public int play() {
        Scanner scnr =  new Scanner(System.in);
        int turnScore = 0;
        int roll = (int) (Math.random()*6 + 1);
        turnScore += roll;
        while (roll != 6) {
            System.out.println("  Player " + getName() + " rolled a " 
                    + roll + " do they wish to continue? n to stop");
            if (scnr.next().equals("n")) {
                System.out.println("  Player " + getName() 
                        + " chose not to continue");
                return turnScore;
            }
            System.out.println("  Player " + getName() + " chose to continue");
            roll = (int) (Math.random()*6 + 1);
            turnScore += roll; 
        }
        if (roll == 6) {
            System.out.println("  Player " + getName() + " rolled a " 
                    + roll + " and gets no points.");
            return 0;
        }
        return turnScore;
    }
}
