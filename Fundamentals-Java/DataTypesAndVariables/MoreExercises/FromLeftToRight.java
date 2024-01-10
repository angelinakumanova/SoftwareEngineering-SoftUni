package DataTypesAndVariables.Exercises.MoreExercises;

import java.util.Scanner;

public class FromLeftToRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfLines = Integer.parseInt(scanner.nextLine());

        long leftNumber = 0;
        long rightNumber = 0;

        for (int i = 1; i <= numberOfLines; i++) {
            long sum = 0;
            leftNumber = scanner.nextLong();
            rightNumber = scanner.nextLong();

            if (leftNumber > rightNumber) {

                while (leftNumber != 0) {
                    sum += leftNumber % 10;
                    leftNumber /= 10;
                }

                System.out.println(Math.abs(sum));

            } else {

                while (rightNumber != 0) {
                    sum += rightNumber % 10;
                    rightNumber /= 10;
                }

                System.out.println(Math.abs(sum));

            }

        }
    }
}
