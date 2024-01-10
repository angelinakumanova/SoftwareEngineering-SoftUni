package ExamProblems.FinalExams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IFinalExam_TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> message = new ArrayList<>();
        char[] messageChars = scanner.nextLine().toCharArray();
        for (int i = 0; i < messageChars.length; i++) {
            message.add(String.valueOf(messageChars[i]));
        }

        String command = scanner.nextLine();
        while (!command.equals("Decode")) {
            String[] tokens = command.split("\\|");

            if (command.contains("ChangeAll")) {
               String letter = tokens[1];
               String newLetter = tokens[2];
                for (int i = 0; i < message.size(); i++) {
                    if (message.get(i).equals(letter)) {
                        message.set(i, newLetter);
                    }
                }
            } else if (command.contains("Move")) {
                int lettersToRemove = Integer.parseInt(tokens[1]);
                for (int i = 0; i < lettersToRemove; i++) {
                    message.add(message.get(0));
                    message.remove(0);
                }
            } else if (command.contains("Insert")) {
                int index = Integer.parseInt(tokens[1]);
                char[] letter = tokens[2].toCharArray();
                for (int i = 0; i < letter.length ; i++) {
                    message.add(index, String.valueOf(letter[i]));
                    index++;
                }
            }

            command = scanner.nextLine();
        }

        StringBuilder result = new StringBuilder();
        for (String letter : message) {
            result.append(letter);
        }
        System.out.printf("The decrypted message is: %s", result);
    }
}
