package TextProcessing.Lab;

import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        String text = scanner.nextLine();

        while (true) {

            if (!text.contains(word)) {
                break;
            }

            String leftSubStr = text.substring(0, text.indexOf(word));
            String rightSubStr = text.substring(text.indexOf(word) + word.length());

            text = leftSubStr + rightSubStr;
        }

        System.out.println(text);
    }
}
