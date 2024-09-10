package Polymorphism.Lab.WildFarm;

import Polymorphism.Lab.WildFarm.animals.Animal;
import Polymorphism.Lab.WildFarm.animals.mammals.Mouse;
import Polymorphism.Lab.WildFarm.animals.mammals.Zebra;
import Polymorphism.Lab.WildFarm.animals.mammals.felime.Cat;
import Polymorphism.Lab.WildFarm.animals.mammals.felime.Tiger;
import Polymorphism.Lab.WildFarm.food.Food;
import Polymorphism.Lab.WildFarm.food.Meat;
import Polymorphism.Lab.WildFarm.food.Vegetable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Animal> animals = new ArrayList<>();
        while (!"End".equals(input)) {
            String[] animalInfo = input.split("\\s+");
            String[] foodInfo = scanner.nextLine().split("\\s+");

            String animalType = animalInfo[0];
            createAnimal(animalType, animalInfo, foodInfo, animals);


            input = scanner.nextLine();
        }

        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

    private static void createAnimal(String animalType, String[] animalInfo, String[] foodInfo, List<Animal> animals) {
        try {
            switch (animalType) {
                case "Mouse":
                    Animal mouse = new Mouse(animalInfo[1], animalType, Double.parseDouble(animalInfo[2]), animalInfo[3]);
                    animals.add(mouse);
                    mouse.makeSound();
                    mouse.eatFood(createFood(foodInfo));
                    break;
                case "Zebra":
                    Animal zebra = new Zebra(animalInfo[1], animalType, Double.parseDouble(animalInfo[2]), animalInfo[3]);
                    animals.add(zebra);
                    zebra.makeSound();
                    zebra.eatFood(createFood(foodInfo));
                    break;
                case "Cat":
                    Animal cat = new Cat(animalInfo[1], animalType, Double.parseDouble(animalInfo[2]), animalInfo[3],
                            animalInfo[4]);
                    animals.add(cat);
                    cat.makeSound();
                    cat.eatFood(createFood(foodInfo));
                    break;
                case "Tiger":
                    Animal tiger = new Tiger(animalInfo[1], animalType, Double.parseDouble(animalInfo[2]), animalInfo[3]);
                    animals.add(tiger);
                    tiger.makeSound();
                    tiger.eatFood(createFood(foodInfo));
                    break;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    private static Food createFood(String[] tokens) {
        String foodType = tokens[0];
        Integer quantity = Integer.valueOf(tokens[1]);

        switch(foodType) {
            case "Vegetable":
                return new Vegetable(quantity);
            case "Meat":
                return new Meat(quantity);
        }

        return null;
    }


}
