package conditionalStatementsAdvanced;

import java.util.Scanner;

public class AnimalClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String animal = scanner.nextLine();

        boolean isMammal = "dog".equals(animal);
        boolean isReptile = "crocodile".equals(animal) || "tortoise".equals(animal) || "snake".equals(animal);
        boolean isValidString = isMammal || isReptile;

        if (!isValidString) {
            System.out.println("unknown");
        } else {

            switch (animal) {
                case "dog":
                    System.out.println("mammal");
                    break;
                case "crocodile":
                case "tortoise":
                case "snake":
                    System.out.println("reptile");
            }
        }
    }
}
