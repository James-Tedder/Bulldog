/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bulldog;

/**
 * This player will only stop after throwing the die 6 times
 * @author James Tedder
 */
public class UniquePlayer extends Player {
    
    /**
     * Constructor for when no name is provided
     */
    public UniquePlayer() {
        super("Unique");
    }
    
    /**
     * Constructor for when a name is provided
     * @param name the name of the player
     */
    public UniquePlayer(String name) {
        super(name);
    }
    
    /**
     * Makes it so this player only stops after 6 rolls
     * @return 
     */
    @Override
    public int play() {
        int turnScore = 0;
        int roll = (int) (Math.random()*6 + 1);
        turnScore += roll;
        int i = 0;
        while (roll != 6 && i < 5) {
            System.out.println("  Player " + getName() + " rolled a " 
                    + roll + " and chose to continue.");
            roll = (int) (Math.random()*6 + 1);
            turnScore += roll; 
            i++;
        }
        if (roll == 6) {
            System.out.println("  Player " + getName() + " rolled a " 
                    + roll + " and gets no points.");
            return 0;
        }
        System.out.println("  Player " + getName() + " rolled a " 
                    + roll + " and chose not to continue.");
        return turnScore;
    }
}
