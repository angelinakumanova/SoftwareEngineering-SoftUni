package lab.firststeps;

import java.util.Scanner;

public class greeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        String firstName = "Angie";
        String lastName = "Kumanova";
        int age = 18;

        System.out.println(firstName + " " + lastName + " @ " + age);
    }
}
