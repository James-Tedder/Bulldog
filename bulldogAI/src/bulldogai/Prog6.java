package bulldogai;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// Abstract Player class (already provided)
abstract class Player {
    private String name;
    private int score;
    
    public Player(String name) {
        this.name = name;
        this.score = 0;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getScore() {
        return this.score;
    }
    
    public void setScore(int score) {
        this.score = score;
    }
    
    public abstract int play();
}

// HumanPlayer: User-controlled decision-making
class HumanPlayer extends Player {
    private Scanner scanner;
    
    public HumanPlayer(String name, Scanner scanner) {
        super(name);
        this.scanner = scanner;
    }
    
    public int play() {
        int turnScore = 0;
        Random rand = new Random();
        while (true) {
            int roll = rand.nextInt(6) + 1;
            System.out.println(getName() + " rolled: " + roll);
            if (roll == 6) {
                System.out.println(getName() + " lost all turn points!");
                return 0;
            }
            turnScore += roll;
            System.out.println("Turn score: " + turnScore);
            System.out.print("Roll again? (y/n): ");
            if (!scanner.next().equalsIgnoreCase("y")) {
                return turnScore;
            }
        }
    }
}

// RandomPlayer: 50% chance to stop rolling
class RandomPlayer extends Player {
    private Random rand = new Random();
    
    public RandomPlayer(String name) {
        super(name);
    }
    
    public int play() {
        int turnScore = 0;
        while (true) {
            int roll = rand.nextInt(6) + 1;
            System.out.println(getName() + " rolled: " + roll);
            if (roll == 6) return 0;
            turnScore += roll;
            if (rand.nextBoolean()) return turnScore;
        }
    }
}

// FifteenPlayer: Rolls until at least 15 points
class FifteenPlayer extends Player {
    private Random rand = new Random();
    
    public FifteenPlayer(String name) {
        super(name);
    }
    
    public int play() {
        int turnScore = 0;
        while (turnScore < 15) {
            int roll = rand.nextInt(6) + 1;
            System.out.println(getName() + " rolled: " + roll);
            if (roll == 6) return 0;
            turnScore += roll;
        }
        return turnScore;
    }
}

// UniquePlayer: A custom risk-based strategy
class UniquePlayer extends Player {
    private Random rand = new Random();
    
    public UniquePlayer(String name) {
        super(name);
    }
    
    public int play() {
        int turnScore = 0;
        int rolls = 0;
        while (true) {
            int roll = rand.nextInt(6) + 1;
            System.out.println(getName() + " rolled: " + roll);
            if (roll == 6) return 0;
            turnScore += roll;
            rolls++;
            if (turnScore > 10 && rolls > 3) return turnScore;
        }
    }
}

// WimpPlayer: Always stops after one roll
class WimpPlayer extends Player {
    private Random rand = new Random();
    
    public WimpPlayer(String name) {
        super(name);
    }
    
    public int play() {
        int roll = rand.nextInt(6) + 1;
        System.out.println(getName() + " rolled: " + roll);
        return roll == 6 ? 0 : roll;
    }
}

// Main game class
public class Prog6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Player> players = new ArrayList<>();
        Random rand = new Random();
        
        System.out.print("Enter number of players: ");
        int numPlayers = scanner.nextInt();
        
        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter player type (human/random/fifteen/unique/unique2/wimp): ");
            String type = scanner.next().toLowerCase();
            System.out.print("Enter player name: ");
            String name = scanner.next();
            switch (type) {
                case "human": players.add(new HumanPlayer(name, scanner)); break;
                case "random": players.add(new RandomPlayer(name)); break;
                case "fifteen": players.add(new FifteenPlayer(name)); break;
                case "unique": players.add(new UniquePlayer(name)); break;
                case "unique2": players.add(new UniquePlayer2(name)); break;
                case "wimp": players.add(new WimpPlayer(name)); break;
                default: System.out.println("Invalid type, skipping...");
            }
        }
        
        boolean gameWon = false;
        while (!gameWon) {
            for (Player player : players) {
                int turnScore = player.play();
                player.setScore(player.getScore() + turnScore);
                System.out.println(player.getName() + " total score: " + player.getScore());
                if (player.getScore() >= 104) {
                    System.out.println(player.getName() + " wins!");
                    gameWon = true;
                    break;
                }
            }
        }
        scanner.close();
    }
}
