package ExamProblems.FinalExams;

import java.util.Scanner;

public class IVFinalExam_PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();

        String command = scanner.nextLine();
        while (!command.equals("Done")) {
            String[] tokens = command.split(" ");
            if (tokens[0].equals("TakeOdd")) {
                String temp = "";
                for (int i = 0; i < password.length(); i++) {
                    if (i % 2 != 0) {
                        temp += password.charAt(i);
                    }
                }
                password = temp;
                System.out.println(password);
            } else if (tokens[0].equals("Cut")) {
                int index = Integer.parseInt(tokens[1]);
                int endIndex = Integer.parseInt(tokens[2]) + index;

                String firstPart = password.substring(0, index);
                String secondPart = password.substring(endIndex);
                password = firstPart + secondPart;

                System.out.println(password);

            } else if (tokens[0].equals("Substitute")) {
                String substring = tokens[1];
                String substitute = tokens[2];
                String temp = "";

                if (!password.contains(String.valueOf(substring))) {
                    System.out.println("Nothing to replace!");
                } else {
                    temp = password.replaceAll(substring, substitute);
                    password = temp;
                    System.out.println(password);
                }
            }


            command = scanner.nextLine();
        }

        System.out.printf("Your password is: %s%n", password);
    }
}
