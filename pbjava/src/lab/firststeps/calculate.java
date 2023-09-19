package lab.firststeps;

import java.util.Scanner;

public class calculate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        int a = Integer.parseInt(userInput);
        String userInput2 = scanner.nextLine();
        int b = Integer.parseInt(userInput2);
        int area = a * b;
        System.out.println(area);
    }
}
