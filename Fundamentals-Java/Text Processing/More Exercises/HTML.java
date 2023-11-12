package TextProcessing.MoreExercises;

import java.util.Scanner;

public class HTML {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        for (int i = 1; i <= 2 ; i++) {
            if (i == 1) {
                System.out.printf("<h1>\n" + "    %s\n" + "</h1>\n", input);
            } else {
                System.out.printf("<article>\n" + "    %s\n" + "</article>\n", input);
            }
            input = scanner.nextLine();
        }

        while (!input.equals("end of comments")) {
            System.out.printf("<div>\n" + "    %s\n" + "</div>\n", input);
            input = scanner.nextLine();
        }
    }
}
