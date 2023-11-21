package Exams;

import java.util.Scanner;

public class IIIFinalExam_SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder concealedMessage = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();
        while (!input.equals("Reveal")) {
            String[] tokens = input.split(":\\|:");

            if (tokens[0].equals("InsertSpace")) {
                concealedMessage.insert(Integer.parseInt(tokens[1]), " ");
                System.out.println(concealedMessage);

            } else if (tokens[0].equals("Reverse")) {
                if (concealedMessage.toString().contains(tokens[1])) {
                    concealedMessage.delete(concealedMessage.indexOf(tokens[1]),
                            concealedMessage.indexOf(tokens[1]) + tokens[1].length());

                    StringBuilder reversedSubstring = new StringBuilder(tokens[1]).reverse();
                    concealedMessage.append(reversedSubstring.toString());
                    System.out.println(concealedMessage);
                } else {
                    System.out.println("error");
                }
            } else if (tokens[0].equals("ChangeAll")) {
                String substring = tokens[1];
                String replacement = tokens[2];

                if (!substring.equals(replacement)) {
                    if (concealedMessage.toString().contains(substring)) {
                        concealedMessage = new StringBuilder(concealedMessage.toString()
                                .replaceAll(substring, replacement));
                    }
                }
                System.out.println(concealedMessage);
            }

            input = scanner.nextLine();
        }

        System.out.printf("You have a new text message: %s\n", concealedMessage);
    }
}
