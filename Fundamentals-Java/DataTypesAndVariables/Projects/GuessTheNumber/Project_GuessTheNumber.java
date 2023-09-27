package DataTypesAndVariables.Projects.GuessTheNumber;

import java.util.Random;
import java.util.Scanner;

public class Project_GuessTheNumber {
    public static void main(String[] args) {
        Scanner scannerInput = new Scanner(System.in);
        Random random = new Random();
        int computerNumber;
        System.out.println("Type in START to begin the game!");
        String gameStartEnd = scannerInput.nextLine();

        while (!gameStartEnd.equalsIgnoreCase("END")) {
            for (int level = 1; level <= 3; level++) {
                int countTries = 0;
                int countHints = 0;


                if (level == 1) {
                    System.out.println("LEVEL 1");
                    computerNumber = random.nextInt(100);
                    // LEVEL 1
                    while (true) {
                        while (computerNumber == 0) {
                            computerNumber = random.nextInt(100);
                        }
                        System.out.print("Guess the number (1-100): ");
                        Scanner scanner = new Scanner(System.in);
                        String playerInput = scanner.nextLine();

                        boolean isValid = false;



                        // Checking if the input are valid integers
                        for (int i = 0; i < playerInput.length(); i++) {
                            if (playerInput.charAt(i) == 45 || playerInput.charAt(i) >= 48 && playerInput.charAt(i) <= 57) {
                                isValid = true;
                            } else  {
                                isValid = false;
                                break;
                            }
                        }

                        // Checking if the player has guessed the number
                        if (isValid) {
                            int playerNumber = Integer.parseInt(playerInput);
                            if (playerNumber > 100 || playerNumber <= 0) {
                                System.out.println("This number is not in the range. Try a number between 1 and 100.");
                            } else {
                                if (playerNumber == computerNumber) {
                                    System.out.println("You guessed it!");
                                    break;
                                } else if (playerNumber > computerNumber) {
                                    System.out.println("Too High!");
                                    countTries++;
                                } else {
                                    System.out.println("Too Low!");
                                    countTries++;
                                }
                            }
                        } else {
                            System.out.println("Try again!");
                        }

                        // Checking if the player would like to use a hint every 5 failed tries
                        if (countTries % 5 == 0 && countTries != 0 && countHints < 3) {
                            if (countHints == 2) {
                                System.out.println("No more hints left. Keep trying!");
                                countHints++;
                            } else {
                                System.out.println("If you would like to use a hint, type in HINT. " +
                                        "If not, press Enter to continue.");
                                playerInput = scanner.nextLine();
                            }


                            if (playerInput.equalsIgnoreCase("HINT") && countHints != 3) {
                                if (countHints == 0) {
                                    if (computerNumber <= 50) {
                                        System.out.println("The number is in the range 1 - 50.");
                                    } else  {
                                        System.out.println("The number is in the range 51 - 100.");
                                    }
                                } else if (countHints == 1) {
                                    if (computerNumber % 2 == 0) {
                                    System.out.println("The number is even.");
                                    } else {
                                    System.out.println("The number is odd.");
                                    }
                                }
                                countHints++;
                            }

                        }
                    }
                } else if (level == 2) {
                    computerNumber = random.nextInt(200);
                    System.out.println("LEVEL 2");

                    // LEVEL 2
                    while (true) {
                        while (computerNumber == 0) {
                            computerNumber = random.nextInt(200);
                        }
                        System.out.print("Guess the number (2-200): ");
                        Scanner scanner = new Scanner(System.in);
                        String playerInput = scanner.nextLine();

                        boolean isValid = false;



                        // Checking if the input are valid integers
                        for (int i = 0; i < playerInput.length(); i++) {
                            if (playerInput.charAt(i) == 45 || playerInput.charAt(i) >= 48 && playerInput.charAt(i) <= 57) {
                                isValid = true;
                            } else  {
                                isValid = false;
                                break;
                            }
                        }

                        // Checking if the player has guessed the number
                        if (isValid) {
                            int playerNumber = Integer.parseInt(playerInput);
                            if (playerNumber > 200 || playerNumber <= 1) {
                                System.out.println("This number is not in the range. Try a number between 2 and 200.");
                            } else {
                                if (playerNumber == computerNumber) {
                                    System.out.println("You guessed it!");
                                    break;
                                } else if (playerNumber > computerNumber) {
                                    System.out.println("Too High!");
                                    countTries++;
                                } else {
                                    System.out.println("Too Low!");
                                    countTries++;
                                }
                            }
                        } else {
                            System.out.println("Try again!");
                        }

                        // Checking if the player would like to use a hint every 5 failed tries
                        if (countTries % 5 == 0 && countTries != 0 && countHints < 3) {
                            if (countHints == 2) {
                                System.out.println("No more hints left. Keep trying!");
                                countHints++;
                            } else {
                                System.out.println("If you would like to use a hint, type in HINT. " +
                                        "If not, press Enter to continue.");
                                playerInput = scanner.nextLine();
                            }


                            if (playerInput.equalsIgnoreCase("HINT") && countHints != 3) {
                                if (countHints == 0) {
                                    if (computerNumber <= 50) {
                                        System.out.println("The number is in the range 2 - 50.");
                                    } else if (computerNumber <= 100) {
                                        System.out.println("The number is in the range 51 - 100.");
                                    } else {
                                        System.out.println("The number is in the range 101 - 200.");
                                    }
                                } else if (countHints == 1) {
                                    if (computerNumber % 2 == 0) {
                                    System.out.println("The number is even.");
                                    } else {
                                    System.out.println("The number is odd.");
                                    }
                                }
                                countHints++;
                            }

                        }
                    }
                } else {
                    computerNumber = random.nextInt(300);
                    System.out.println("LEVEL 3");

                    // LEVEL 3
                    while (true) {
                        while (computerNumber == 0) {
                            computerNumber = random.nextInt(300);
                        }
                        System.out.print("Guess the number (3-300): ");
                        Scanner scanner = new Scanner(System.in);
                        String playerInput = scanner.nextLine();

                        boolean isValid = false;



                        // Checking if the input are valid integers
                        for (int i = 0; i < playerInput.length(); i++) {
                            if (playerInput.charAt(i) == 45 || playerInput.charAt(i) >= 48 && playerInput.charAt(i) <= 57) {
                                isValid = true;
                            } else  {
                                isValid = false;
                                break;
                            }
                        }

                        // Checking if the player has guessed the number
                        if (isValid) {
                            int playerNumber = Integer.parseInt(playerInput);
                            if (playerNumber > 300 || playerNumber <= 2) {
                                System.out.println("This number is not in the range. Try a number between 3 and 300.");
                            } else {
                                if (playerNumber == computerNumber) {
                                    System.out.println("You guessed it!");
                                    break;
                                } else if (playerNumber > computerNumber) {
                                    System.out.println("Too High!");
                                    countTries++;
                                } else {
                                    System.out.println("Too Low!");
                                    countTries++;
                                }
                            }
                        } else {
                            System.out.println("Try again!");
                        }

                        // Checking if the player would like to use a hint every 5 failed tries
                        if (countTries % 5 == 0 && countTries != 0 && countHints < 3) {
                            if (countHints == 2) {
                                System.out.println("No more hints left. Keep trying!");
                                countHints++;
                            } else {
                                System.out.println("If you would like to use a hint, type in HINT. " +
                                        "If not, press Enter to continue.");
                                playerInput = scanner.nextLine();
                            }


                            if (playerInput.equalsIgnoreCase("HINT") && countHints != 3) {
                                if (countHints == 0) {
                                    if (computerNumber <= 50) {
                                        System.out.println("The number is in the range 3 - 50.");
                                    } else if (computerNumber <= 100) {
                                        System.out.println("The number is in the range 51 - 100.");
                                    } else if (computerNumber <= 200){
                                        System.out.println("The number is in the range 101 - 200.");
                                    } else {
                                        System.out.println("The number is in the range 201 - 300.");
                                    }
                                } else if (countHints == 1) {
                                    if (computerNumber % 2 == 0) {
                                    System.out.println("The number is even.");
                                    } else {
                                    System.out.println("The number is odd.");
                                    }
                                }
                                countHints++;
                            }

                        }
                    }
                }
            }
            System.out.println();
            System.out.println("Congratulations, you've completed all three levels!");
            System.out.println("If you would like to play again, type in START.");
            System.out.println("If not, type in END.");
            gameStartEnd = scannerInput.nextLine();
        }
    }
}
