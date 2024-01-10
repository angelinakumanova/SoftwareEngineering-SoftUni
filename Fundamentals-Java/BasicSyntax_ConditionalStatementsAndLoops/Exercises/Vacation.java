package BasicSyntax_ConditionalStatements_Loops.Exercises;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        String typeOfGroup = scanner.nextLine();
        String dayOfWeek = scanner.nextLine();
        double totalPrice = 0;

        switch (dayOfWeek) {
            case "Friday":
                switch (typeOfGroup) {
                    case "Students":
                        totalPrice = 8.45 * numberOfPeople;
                        if (numberOfPeople >= 30) {
                            totalPrice -= (totalPrice * 0.15);
                            System.out.printf("Total price: %.2f", totalPrice);
                        } else {
                            System.out.printf("Total price: %.2f", totalPrice);
                        }
                        break;
                    case "Business":
                        totalPrice = 10.90 * numberOfPeople;
                        if (numberOfPeople >= 100) {
                            totalPrice -= 109;
                            System.out.printf("Total price: %.2f", totalPrice);
                        } else {
                            System.out.printf("Total price: %.2f", totalPrice);
                        }
                        break;
                    case "Regular":
                        totalPrice = 15 * numberOfPeople;
                        if (numberOfPeople >= 10 && numberOfPeople <= 20) {
                            totalPrice -= (totalPrice * 0.05);
                            System.out.printf("Total price: %.2f", totalPrice);
                        } else {
                            System.out.printf("Total price: %.2f", totalPrice);
                        }
                        break;
                }
                break;
            case "Saturday":
                switch (typeOfGroup) {
                    case "Students":
                        totalPrice = 9.80 * numberOfPeople;
                        if (numberOfPeople >= 30) {
                            totalPrice -= (totalPrice * 0.15);
                            System.out.printf("Total price: %.2f", totalPrice);
                        } else {
                            System.out.printf("Total price: %.2f", totalPrice);
                        }
                        break;
                    case "Business":
                        totalPrice = 15.60 * numberOfPeople;
                        if (numberOfPeople >= 100) {
                            totalPrice -= 156;
                            System.out.printf("Total price: %.2f", totalPrice);
                        } else {
                            System.out.printf("Total price: %.2f", totalPrice);
                        }
                        break;
                    case "Regular":
                        totalPrice = 20 * numberOfPeople;
                        if (numberOfPeople >= 10 && numberOfPeople <= 20) {
                            totalPrice -= (totalPrice * 0.05);
                            System.out.printf("Total price: %.2f", totalPrice);
                        } else {
                            System.out.printf("Total price: %.2f", totalPrice);
                        }
                        break;
                }
                break;
            case "Sunday":
                switch (typeOfGroup) {
                    case "Students":
                        totalPrice = 10.46 * numberOfPeople;
                        if (numberOfPeople >= 30) {
                            totalPrice -= (totalPrice * 0.15);
                            System.out.printf("Total price: %.2f", totalPrice);
                        } else {
                            System.out.printf("Total price: %.2f", totalPrice);
                        }
                        break;
                    case "Business":
                        totalPrice = 16 * numberOfPeople;
                        if (numberOfPeople >= 100) {
                            totalPrice -= 160;
                            System.out.printf("Total price: %.2f", totalPrice);
                        } else {
                            System.out.printf("Total price: %.2f", totalPrice);
                        }
                        break;
                    case "Regular":
                        totalPrice = 22.50 * numberOfPeople;
                        if (numberOfPeople >= 10 && numberOfPeople <= 20) {
                            totalPrice -= (totalPrice * 0.05);
                            System.out.printf("Total price: %.2f", totalPrice);
                        } else {
                            System.out.printf("Total price: %.2f", totalPrice);
                        }
                        break;
                }
                break;
        }
    }
}
