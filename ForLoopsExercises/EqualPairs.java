package ForLoopsExercises;

import java.util.Scanner;

public class EqualPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int value = 0;
        int currentSum = 0;
        int diff = 0;
        boolean check = false;

        for (int i = 0; i < n; i++) {
            int number1 = Integer.parseInt(scanner.nextLine());
            int number2 = Integer.parseInt(scanner.nextLine());
            int current = number1 + number2;

            if (current != currentSum) {
               diff =  Math.abs(currentSum - current);


            }



        }
    }
}
