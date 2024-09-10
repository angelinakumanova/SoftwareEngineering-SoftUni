package Encapsulation.Exercises.PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pizza pizza = createPizza(scanner);
        createDough(scanner, pizza);
        addToppings(scanner, pizza);

        System.out.println(pizza.getName() + " - " + pizza.getOverallCalories());

    }

    private static Pizza createPizza(Scanner scanner) {
        String[] pizzaInfo = scanner.nextLine().split("\\s+");
        String name = pizzaInfo[1];
        int numberOfToppings = Integer.parseInt(pizzaInfo[2]);

        return new Pizza(name, numberOfToppings);
    }

    private static void createDough (Scanner scanner, Pizza pizza) {
        String[] doughInfo = scanner.nextLine().split("\\s+");
        String type = doughInfo[1];
        String bakingTechnique = doughInfo[2];
        double weight = Double.parseDouble(doughInfo[3]);

        pizza.setDough(new Dough(type, bakingTechnique, weight));

    }

    private static void addToppings(Scanner scanner, Pizza pizza) {
        String input = scanner.nextLine();

        while (!"END".equals(input)) {
            String[] toppingInfo = input.split("\\s+");
            String toppingName = toppingInfo[1];
            double weight = Double.parseDouble(toppingInfo[2]);

            Topping topping = new Topping(toppingName, weight);
            pizza.addTopping(topping);

            input = scanner.nextLine();
        }
    }
}
