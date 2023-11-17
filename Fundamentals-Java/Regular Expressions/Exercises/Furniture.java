package RegularExpressions.Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile(">>(?<furniture>[A-Za-z]+)<<(?<price>[0-9.]+)!(?<quantity>\\d+)");

        String input = scanner.nextLine();
        double sum = 0;
        List<String> boughtFurniture = new ArrayList<>();
        while (!input.equals("Purchase")) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                boughtFurniture.add(matcher.group("furniture"));
                sum += Double.parseDouble(matcher.group("price")) * Double.parseDouble(matcher.group("quantity"));
            }

            input = scanner.nextLine();
        }

        System.out.println("Bought furniture:");
        for (String furniture : boughtFurniture) {
            System.out.println(furniture);
        }

        System.out.printf("Total money spend: %.2f%n", sum);
    }


}
