package Arrays.Exercises;

import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstElements = scanner.nextLine().split(" ");
        String[] secondElements = scanner.nextLine().split(" ");

        for (String secondElement : secondElements) {
            for (String firstElement : firstElements) {
                if (secondElement.equals(firstElement)) {
                    System.out.print(secondElement + " ");
                }
            }
        }
    }
}
