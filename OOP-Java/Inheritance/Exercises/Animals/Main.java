package Inheritance.Exercises.Animals;

import Inheritance.Exercises.Animals.cat.Cat;
import Inheritance.Exercises.Animals.cat.Kitten;
import Inheritance.Exercises.Animals.cat.Tomcat;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        while (!"Beast!".equals(input)) {
            String[] animalInfo = scanner.nextLine().split("\\s+");

            try {
                createAnimal(input, animalInfo);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }


            input = scanner.nextLine();
        }
    }

    private static void createAnimal(String type, String[] tokens) {
        String name = tokens[0];
        int age = Integer.parseInt(tokens[1]);
        String gender = tokens.length == 3 ? tokens[2] : "";

        switch (type) {
            case "Dog":
                Dog dog = new Dog(name, age, gender);
                System.out.println(dog);
                break;
            case "Cat":
                Cat cat = new Cat(name, age, gender);
                System.out.println(cat);
                break;
            case "Kitten":
                Kitten kitten = new Kitten(name, age);
                System.out.println(kitten);
                break;
            case "Tomcat":
                Tomcat tomcat = new Tomcat(name, age);
                System.out.println(tomcat);
                break;
            case "Frog":
                Frog frog = new Frog(name, age, gender);
                System.out.println(frog);
                break;
        }
    }
}
