/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bulldog;

/**
 * Is a bulldog player that plays randomly
 * @author James Tedder
 */
public class RandomPlayer extends Player {
    
    /**
     * Constructor for when no name is provided
     */
    public RandomPlayer() {
        super("Random");
    }
    
    /**
     * Constructor for when a name is provided
     * @param name the name of the player
     */
    public RandomPlayer(String name) {
        super(name);
    }
    
    /**
     * Makes it so this player does random actions during play.
     * @return 
     */
    @Override
    public int play() {
        int turnScore = 0;
        int roll = (int) (Math.random()*6 + 1);
        turnScore += roll;
        while (roll != 6 && (int) (Math.random()) == 1) {
            System.out.println("  Player " + getName() + " rolled a " 
                    + roll + " and chose to continue.");
            roll = (int) (Math.random()*6 + 1);
            turnScore += roll; 
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
