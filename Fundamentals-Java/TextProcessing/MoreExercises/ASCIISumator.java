package TextProcessing.MoreExercises;

import java.util.Scanner;

public class ASCIISumator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstCh = scanner.nextLine();
        String secondCh = scanner.nextLine();
        String text = scanner.nextLine();

        int sum = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) > firstCh.charAt(0) && text.charAt(i) < secondCh.charAt(0)) {
                sum += text.charAt(i);
            }
        }

        System.out.println(sum);

    }
}
