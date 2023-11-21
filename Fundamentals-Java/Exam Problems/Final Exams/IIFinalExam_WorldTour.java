package Exams;

import java.util.Scanner;

public class IIFinalExam_WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stops = new StringBuilder(scanner.nextLine());

        String command = scanner.nextLine();
        while (!command.equals("Travel")) {
            String[] tokens = command.split(":");
            if (command.contains("Add")) {
                int index = Integer.parseInt(tokens[1]);
                String str = tokens[2];
                if (index >= 0 && index < stops.length()) {
                    stops.insert(index, str);
                }
            } else if (command.contains("Remove")) {
                int startIndex = Integer.parseInt(tokens[1]);
                int endIndex = Integer.parseInt(tokens[2]);
                if (startIndex <= endIndex) {
                    if (startIndex >= 0 && startIndex < stops.length() && endIndex < stops.length()) {
                        stops.delete(startIndex, endIndex + 1);
                    }
                }
            } else if (command.contains("Switch")) {
                String oldString = tokens[1];
                String newString = tokens[2];

                if (!oldString.equals(newString)) {
                    if (stops.toString().contains(oldString)) {
                        stops = new StringBuilder(stops.toString().replaceAll(oldString, newString));
                    }
                }


            }

            System.out.println(stops);
            command = scanner.nextLine();
        }

        System.out.printf("Ready for world tour! Planned stops: %s\n", stops);
    }
}
