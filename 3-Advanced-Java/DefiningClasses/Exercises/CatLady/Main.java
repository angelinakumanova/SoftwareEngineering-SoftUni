package DefiningClasses.Exercises.CatLady;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Cat> cats = new HashMap<>();

        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            String type = tokens[0];
            String name = tokens[1];
            double parameter = Double.parseDouble(tokens[2]);

            Cat cat;

            switch (type) {
                case "Siamese":
                    cat = new Siamese(name, type, parameter);
                    break;
                case "Cymric":
                    cat = new Cymric(name, type, parameter);
                    break;
                default:
                    cat = new StreetExtraordinaire(name, type, parameter);
                    break;
            }
            cats.put(name, cat);


            input = scanner.nextLine();
        }

        String searchedCat = scanner.nextLine();
        System.out.println(cats.get(searchedCat));
    }
}
