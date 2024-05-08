import java.util.Random;
import java.util.Scanner;

public class GuessingNumber {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 100;
    private static final int MAX_ATTEMPTS = 10;
    private static final int MAX_ROUNDS = 3;

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int totalScore = 0;

        System.out.println("NUMBER GUESSING GAME");
        System.out.println("Total Number Of Rounds: 3");
        System.out.println("Attempts To Guess Number In Each Round: 10\n");

      
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();
        System.out.println("Welcome, " + playerName + "!\n");

        for (int i = 1; i <= MAX_ROUNDS; i++) {
            int number = random.nextInt(MAX_RANGE) + MIN_RANGE;
            int attempts = 0;

            System.out.printf("Round %d: Guess the number between %d and %d in %d attempts.\n", i, MIN_RANGE, MAX_RANGE,
                    MAX_ATTEMPTS);

            while (attempts < MAX_ATTEMPTS) {
                System.out.println("Enter your guess: ");
                if (scanner.hasNextInt()) {
                    int guess_number = scanner.nextInt();
                    attempts++;

                    if (guess_number == number) {
                        int score = MAX_ATTEMPTS - attempts;
                        totalScore += score;
                        System.out.printf("Hurray, %s! Number Guessed Successfully. Attempts = %d. Round Score = %d\n",
                                playerName, attempts, score);
                        break;
                    } else if (guess_number < number) {
                        System.out.printf("The number is greater than %d. Attempts Left = %d.\n", guess_number,
                                MAX_ATTEMPTS - attempts);
                    } else if (guess_number > number) {
                        System.out.printf("The number is less than %d. Attempts Left = %d.\n", guess_number,
                                MAX_ATTEMPTS - attempts);
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid integer.");
                    scanner.next(); // consume the invalid input
                }
            }

            if (attempts == MAX_ATTEMPTS) {
                System.out.printf("\nRound = %d\n", i);
                System.out.println("Attempts = 0");
                System.out.printf("The Random Number Is : %d\n\n", number);
            }
        }

        System.out.printf("Game Over, %s! Total Score = %d\n", playerName, totalScore);
        scanner.close();
    }
}