import java.util.Scanner;
import java.util.Random;
public class CBTC01
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int min = 1;
        int max = 100;
        int attempts = 0;
        int score = 100; 
        
        System.out.println("Welcome to Guess the Number!");
        System.out.println("I have chosen a number between " + min + " and " + max + ". Try to guess it.");

        int randomNumber = random.nextInt(max - min + 1) + min;

        while (true) 
        {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;
            if (userGuess == randomNumber) 
            {
                System.out.println("Congratulations! You've guessed the number in " + attempts + " attempts.");
                System.out.println("Your score: " + score);
                break;
            } 
            else if (userGuess < randomNumber) 
            {
                System.out.println("Too low. Try again.");
            } 
            else 
            {
                System.out.println("Too high. Try again.");
            }
            score -= 10; 
            if (attempts >= 5) 
            {
                System.out.println("Sorry, you've used all 5 attempts.");
                System.out.println("The number was: " + randomNumber);
                System.out.println("Your score: " + score);
                break;
            }
        }
    }
}
