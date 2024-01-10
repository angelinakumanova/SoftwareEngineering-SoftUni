package ExamProblems.FinalExams;

import java.util.Scanner;

public class VFinalExam_ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder rawKey = new StringBuilder(scanner.nextLine());

        String command = scanner.nextLine();
        while (!command.equals("Generate")) {
            String[] tokens = command.split(">>>");
            if (tokens[0].equals("Contains")) {
                String substring = tokens[1];
                if (rawKey.toString().contains(substring)) {
                    System.out.printf("%s contains %s%n", rawKey, substring);
                } else {
                    System.out.println("Substring not found!");
                }
            } else if (tokens[0].equals("Flip")) {
                String cmnd = tokens[1];
                int startIndex = Integer.parseInt(tokens[2]);
                int endIndex = Integer.parseInt(tokens[3]);

                if (cmnd.equals("Upper")) {
                    String newSubstr = rawKey.substring(startIndex, endIndex).toUpperCase();
                    rawKey.replace(startIndex, endIndex, newSubstr);
                } else if (cmnd.equals("Lower")) {
                    String newSubstr = rawKey.substring(startIndex, endIndex).toLowerCase();
                    rawKey.replace(startIndex, endIndex, newSubstr);
                }

                System.out.println(rawKey);
            } else if (tokens[0].equals("Slice")) {
                int startIdx = Integer.parseInt(tokens[1]);
                int endIdx = Integer.parseInt(tokens[2]);
                rawKey.delete(startIdx, endIdx);
                System.out.println(rawKey);
            }


            command = scanner.nextLine();
        }

        System.out.printf("Your activation key is: %s%n", rawKey);
    }
}
