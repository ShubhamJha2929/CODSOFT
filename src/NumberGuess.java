
import java.util.Scanner;
import java.util.Random;

    public class NumberGuess {

        public static void main(String[] args) {
            startGame();
        }

        public static void startGame() {
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();
            int lowerLimit = 1;
            int upperLimit = 100;
            int totalAttempts = 0;
            int rounds = 0;

            System.out.println("Welcome to Guess the Number game!");

            while (true) {
                rounds++;
                int secretNumber = random.nextInt(100) ;
                System.out.println("\nRound " + rounds);
                totalAttempts += guessNumber(secretNumber, lowerLimit, upperLimit);
                System.out.print("Do you want to play again? (yes/no): ");
                String playAgain = scanner.nextLine().toLowerCase();
                if (!playAgain.equals("yes")) {
                    break;
                }
            }

            System.out.println("\nGame over!");
            System.out.println("Total rounds played: " + rounds);
            System.out.println("Total attempts taken: " + totalAttempts);
            scanner.close();
        }

        public static int guessNumber(int secretNumber, int lowerLimit, int upperLimit) {
            Scanner scanner = new Scanner(System.in);
            int attempts = 0;

            while (true) {
                System.out.print("Guess the number between " + lowerLimit + " and " + upperLimit + ": ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == secretNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts!");
                    break;
                } else if (userGuess < secretNumber) {
                    System.out.println("lower than secret no. Try again.");
                } else {
                    System.out.println(" higher than secret no.! Try again.");
                }
            }

            return attempts;
        }
    }


