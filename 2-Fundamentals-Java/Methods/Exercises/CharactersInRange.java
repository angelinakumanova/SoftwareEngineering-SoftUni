package Methods.Exercises;

import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char firstCh = scanner.nextLine().charAt(0);
        char secondCh = scanner.nextLine().charAt(0);

        printCharacters(firstCh, secondCh);
    }
    public static void printCharacters (char firstCh, char secondCh) {
        if (firstCh < secondCh) {
            for (int i = firstCh + 1; i < secondCh ; i++) {
                char current = (char) i;
                System.out.print(current + " ");
            }
        } else {
            for (int i = secondCh + 1; i < firstCh ; i++) {
                char current = (char) i;
                System.out.print(current + " ");
            }
        }

    }
}
