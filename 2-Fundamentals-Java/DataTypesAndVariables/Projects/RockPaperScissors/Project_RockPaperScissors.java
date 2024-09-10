package DataTypesAndVariables.Projects.RockPaperScissors;

import java.util.Random;
import java.util.Scanner;

public class Project_RockPaperScissors {
    private static final String ROCK = "Rock";
    private static final String PAPER = "Paper";
    private static final String SCISSORS = "Scissors";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int finalCountPlayer = 0;
        int finalCountComputer = 0;

        System.out.println("Type in START to begin the game!");
        String gameInput = scanner.nextLine();


        // The Game
        while (!gameInput.equals("END")) {

            // Checking for a correct input
            while (!gameInput.equals("START")) {
                    System.out.println("Incorrect input! You must type in START to begin the game!");
                    gameInput = scanner.nextLine();
            }

            int countPlayerWins = 0;
            int countPlayerLosses = 0;
            int countComputerWins = 0;
            int countComputerLoses = 0;

            // Rounds (playing until one has 3 wins)
            while (countComputerWins != 3 && countPlayerWins != 3) {

                System.out.print("Choose [r]ock, [p]aper or [s]cissors: ");


                // Player's input
                String input = scanner.nextLine();

                while (!(input.equals("r") || input.equals("rock") ||
                        input.equals("p") || input.equals("paper") ||
                        input.equals("s") || input.equals("scissors"))) {
                    System.out.println("Invalid Input. Try Again...");
                    System.out.println();
                    System.out.print("Choose [r]ock, [p]aper or [s]cissors: ");
                    input = scanner.nextLine();
                }

                if (input.equals("r") || input.equals("rock")) {
                    input = ROCK;
                } else if (input.equals("p") || input.equals("paper")) {
                    input = PAPER;
                } else {
                    input = SCISSORS;
                }



                // Computer's Input
                Random random = new Random();
                int computerRandomNumber = random.nextInt(4);
                String computerInput = "";

                while (computerRandomNumber == 0) {
                    computerRandomNumber = random.nextInt(4);
                }
                if (computerRandomNumber == 1) {
                    computerInput = ROCK;
                } else if (computerRandomNumber == 2) {
                    computerInput = PAPER;
                } else {
                    computerInput = SCISSORS;
                }

                System.out.printf("The computer chose %s%n", computerInput);



                // Comparing moves
                if (input.equals("Rock") && computerInput.equals("Scissors") ||
                        input.equals("Paper") && computerInput.equals("Rock") ||
                        input.equals("Scissors") && computerInput.equals("Paper")) {
                    countPlayerWins++;
                    countComputerLoses++;
                    System.out.println("You win this round.");
                } else if (computerInput.equals("Rock") && input.equals("Scissors") ||
                        computerInput.equals("Paper") && input.equals("Rock") ||
                        computerInput.equals("Scissors") && input.equals("Paper")) {
                    countComputerWins++;
                    countPlayerLosses++;
                    System.out.println("You lose this round.");
                } else {
                    System.out.println("The round is a draw.");
                }


                // Print of the round
                System.out.printf("%n\t\tStats %n"
                                + "\t\t" + "Losses " + "Wins %n" +
                                "Player: \t%d  %d%n" + "Computer:   %d  %d%n" + "%n", countPlayerLosses,
                        countPlayerWins, countComputerLoses, countComputerWins);
            }


            // Print of final stats of the rounds
            if (countComputerWins == 3) {
                finalCountComputer++;
                System.out.println("You lost! The computer won.");
            } else {
                finalCountPlayer++;
                System.out.println("You won! The computer lost.");
            }


            // Checking if the player wants to play again
            System.out.println("If you would like to try again, type in START.");
            System.out.println("If you don't want to play anymore, type in END.");
            gameInput = scanner.nextLine();
            while (!(gameInput.equals("START") || gameInput.equals("END"))) {
                System.out.println("Incorrect input! You must either type in START or END!");
                gameInput = scanner.nextLine();
            }
        }

        // Print of final stats of all games played
        if (finalCountPlayer > finalCountComputer) {
            System.out.printf("You beat the computer! %d to %d wins!", finalCountPlayer, finalCountComputer);
        } else if (finalCountComputer > finalCountPlayer) {
            System.out.printf("The computer beat you! %d to %d wins!", finalCountComputer, finalCountPlayer);
        } else {
            System.out.printf("You're tie! Games played: %d", finalCountComputer);
        }


    }


}
