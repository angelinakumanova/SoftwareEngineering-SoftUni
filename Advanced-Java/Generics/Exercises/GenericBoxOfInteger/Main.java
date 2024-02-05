package Generics.Exercises.GenericBoxOfInteger;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            Box<Integer> integerBox = new Box<>(number);
            System.out.println(integerBox);
        }
    }
}
