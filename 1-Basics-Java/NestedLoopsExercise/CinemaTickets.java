package NestedLoopsExercise;

import java.util.Scanner;

public class CinemaTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int studentTickets = 0;
        int standardTickets = 0;
        int kidTickets = 0;
        int totalTickets = 0;

        String input = scanner.nextLine();
        while (!"Finish".equals(input)) {
            String movieName = input;
            int freeSeats = Integer.parseInt(scanner.nextLine());

            int currentMovieTicketsCount = 0;

            input = scanner.nextLine();
            while (!"End".equals(input) && freeSeats > 0) {
                String ticketType = input;
                currentMovieTicketsCount++;

                switch (ticketType) {
                    case "student":
                        studentTickets++;
                        break;
                    case "standard":
                        standardTickets++;
                        break;
                    case "kid":
                        kidTickets++;
                        break;
                }

                if (currentMovieTicketsCount >= freeSeats) {
                    break;
                }

                input = scanner.nextLine();
            }

            totalTickets += currentMovieTicketsCount;
            System.out.printf("%s - %.2f%% full.%n", movieName, 100.0 * currentMovieTicketsCount / freeSeats);

            input = scanner.nextLine();
        }

        System.out.printf("Total tickets: %d%n", totalTickets);
        System.out.printf("%.2f%% student tickets.%n", 100.0 * studentTickets / totalTickets);
        System.out.printf("%.2f%% standard tickets.%n", 100.0 * standardTickets / totalTickets);
        System.out.printf("%.2f%% kids tickets.%n", 100.0 * kidTickets / totalTickets);
    }
}
