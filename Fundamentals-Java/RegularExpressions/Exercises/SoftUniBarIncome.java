package RegularExpressions.Exercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile("%(?<name>[A-Z][a-z]+)%[^|$%.]*?<(?<product>\\w+)>[^|$%.]*?\\|(?<quantity>\\d+)\\|[^|$%.]*?(?<price>\\d.+)\\$");


        String input = scanner.nextLine();
        double totalIncome = 0;
        while (!input.equals("end of shift")) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                double price = Double.parseDouble(matcher.group("quantity"))
                        * Double.parseDouble(matcher.group("price"));
                totalIncome += price;
                System.out.printf("%s: %s - %.2f%n",
                        matcher.group("name"),
                        matcher.group("product"),
                        price);
            }

            input = scanner.nextLine();
        }
        System.out.printf("Total income: %.2f%n", totalIncome);
    }

}
