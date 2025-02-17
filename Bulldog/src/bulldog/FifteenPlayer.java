/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bulldog;

/**
 * Is a player that will only stop once it receives 15 points in the turn
 * @author James Tedder
 */
public class FifteenPlayer extends Player {
    
    /**
     * Constructor for when no name is provided
     */
    public FifteenPlayer() {
        super("Fifteen");
    }
    
    /**
     * Constructor for when a name is provided
     * @param name the name of the player
     */
    public FifteenPlayer(String name) {
        super(name);
    }
    
    /**
     * Makes it so this player only stops once it has received 15 points in the
     * turn
     * @return 
     */
    @Override
    public int play() {
        int turnScore = 0;
        int roll = (int) (Math.random()*6 + 1);
        turnScore += roll;
        while (roll != 6 && turnScore < 15) {
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
