package ChecksLab;

import java.util.Scanner;

public class EvenOrOdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        boolean IsEven = number % 2 == 0;

        if (IsEven) {
            System.out.println("even");
        } else {
            System.out.println("odd");
        }
    }
}
