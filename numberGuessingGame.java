import java.util.*;
public class numberGuessingGame{
    private static final String WELCOME_TEXT = 
        "  ____                       _   _           _       _             \n" +
        " / ___| __ _ _   _  ___  ___| |_(_)_ __   __| | __ _| |_ ___  _ __ \n" +
        "| |  _ / _` | | | |/ _ \\/ __| __| | '_ \\ / _` |/ _` | __/ _ \\| '__|\n" +
        "| |_| | (_| | |_| |  __/\\__ \\ |_| | | | | (_| | (_| | || (_) | |   \n" +
        " \\____|\\__,_|\\__,_|\\___||___/\\__|_|_| |_|\\__,_|\\__,_|\\__\\___/|_|   \n";

    private static final String WIN_TEXT = 
        " __     __          __          ___       _ \n" +
        " \\ \\   / /          \\ \\        / (_)     | |\n" +
        "  \\ \\_/ /__  _   _   \\ \\  /\\  / / _ _ __ | |\n" +
        "   \\   / _ \\| | | |   \\ \\/  \\/ / | | '_ \\| |\n" +
        "    | | (_) | |_| |    \\  /\\  /  | | | | |_|\n" +
        "    |_|\\___/ \\__,_|     \\/  \\/   |_|_| |_(_)\n";


    private static final String LIMIT_TEXT = 
            " _      _ _ _ _   \n" +
            "| |    (_) | (_)  \n" +
            "| |     _| | |_   \n" +
            "| |    | | | | |  \n" +
            "| |____| | | | |  \n" +
            "|______|_|_|_|_|  \n";


    private static final int MAX_ATTEMPTS = 10;
    private static final int POINTS_PER_ATTEMPT = 10;



    public static void main(String[] args){
        System.out.println(WELCOME_TEXT);
        
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        int guess;
        int totalScore = 0;
        boolean playAgain = true;
        
        
        System.out.println("Hello My Friend!! Welcome to the World of Guessing.....");
        System.out.println("Your Task is to Guess the Number between 1 and 100 !!!!");
        System.out.println("I am thinking of a number between 1 and 10......");
        System.out.println("You have:" + MAX_ATTEMPTS + " attempts.");
        
        
        while(playAgain) {
            int numberToGuess = rand.nextInt(100) + 1; 
            int numberOfTries = 0;
            boolean win = false;
        while (!win && numberOfTries < MAX_ATTEMPTS) {
            System.out.println("Start Guessing");
            guess = scanner.nextInt();
            numberOfTries++;
            if (guess <1 || guess > 100) {
                System.out.println("Please Enter a Number between 1 and 100");
                System.out.println(LIMIT_TEXT);
                break;
            } else if (guess < numberToGuess) {
                System.out.println("Your guess is too low. Try again:");
            } else if(guess > numberToGuess) {
                System.out.println("Your guess is too high. Try again:");
            } else {
                win = true;
                int points = (MAX_ATTEMPTS - numberOfTries+1) + POINTS_PER_ATTEMPT;
                totalScore += points;
                System.out.println(WIN_TEXT);
                System.out.println("Congratulations! You've guessed the number in " + numberOfTries + " tries.");
                System.out.println("You've earned " + points + " points. Total score: " + totalScore);
            }
            if(numberOfTries == MAX_ATTEMPTS && !win) {
                System.out.println("You've run out of attempts. The number was " + numberToGuess);
            }
        }
        System.out.println("Do you want to play Again? (yes/no):");
        playAgain = scanner.next().equalsIgnoreCase("yes");
    }
        System.out.println("Thank you for playing! Your final score is: " + totalScore);
        scanner.close();
    }
}