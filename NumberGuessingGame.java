import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Guessing Game!");

        boolean playAgain = true;
        int totalScore = 0;

        while (playAgain) {
            int targetNumber = generateRandomNumber(1, 100);
            int attempts = 0;
            int maxAttempts = 5;

            while (attempts < maxAttempts) {
                int userGuess = getUserInput("Guess a number between 1 and 100: ");
                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the number " + targetNumber + " correctly.");
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Your guess is too low. Try again.");
                } else {
                    System.out.println("Your guess is too high. Try again.");
                }

                attempts++;
            }

            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The number was " + targetNumber + ".");
            }

            playAgain = askToPlayAgain("Do you want to play again? (y/n) ");

            int score = maxAttempts - attempts;
            totalScore += score;
            System.out.println("Your score for this round is " + score + ".");
            System.out.println("Your total score is " + totalScore + ".");
        }

        System.out.println("Thanks for playing! Goodbye.");
    }
    private static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    private static int getUserInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextInt();
    }

    private static boolean askToPlayAgain(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        String input = scanner.nextLine();
        return input.toLowerCase().startsWith("y");
    }
}
