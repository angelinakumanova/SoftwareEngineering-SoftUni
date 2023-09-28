package Arrays;

import java.util.Scanner;

public class ReverseArrayOfStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] elements = scanner.nextLine().split(" ");
        String[] reversed = new String[elements.length];

        int index = 0;
        for (int i = elements.length - 1; i >= 0; i--) {
            reversed[index] = elements[i];
            index += 1;
        }
        System.out.println(String.join(" ", reversed));
    }
}
