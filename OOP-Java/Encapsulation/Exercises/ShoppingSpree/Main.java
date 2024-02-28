package Encapsulation.Exercises.ShoppingSpree;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> people = new LinkedHashMap<>();
        addPeople(scanner, people);

        Map<String, Product> products = new LinkedHashMap<>();
        addProducts(scanner, products);

        buyProducts(scanner, people, products);

        printResult(people);
    }

    private static Map<String, Person> addPeople(Scanner scanner, Map<String, Person> people) {
        String[] peopleInfo = scanner.nextLine().split(";");

        for (String p : peopleInfo) {
            String[] tokens = p.split("=");
            String name = tokens[0];
            double money = Double.parseDouble(tokens[1]);

            Person person = new Person(name, money);
            people.put(name, person);
        }

        return people;
    }

    private static Map<String, Product> addProducts(Scanner scanner, Map<String, Product> products) {
        String[] productsInfo = scanner.nextLine().split(";");

        for (String p : productsInfo) {
            String[] tokens = p.split("=");
            String name = tokens[0];
            double cost = Double.parseDouble(tokens[1]);

            Product product = new Product(name, cost);
            products.put(name, product);
        }

        return products;
    }

    private static void buyProducts(Scanner scanner, Map<String, Person> people, Map<String, Product> products) {
        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            String[] tokens = input.split("\\s+");
            String personName = tokens[0];
            String productName = tokens[1];
            Person person = people.get(personName);
            Product product = products.get(productName);

            try {
                person.buyProduct(product);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }

            input = scanner.nextLine();
        }
    }

    private static void printResult(Map<String, Person> people) {
        people.values().forEach(p -> {
            System.out.printf("%s - ", p.getName());
            if (p.getProducts().isEmpty()) {
                System.out.println("Nothing bought.");
            } else {
                String productsName = p.getProducts()
                        .stream()
                        .map(Product::getName)
                        .collect(Collectors.joining(", "));

                System.out.println(productsName);
            }
        });
    }
}
