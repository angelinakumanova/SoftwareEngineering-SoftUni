package InterfacesAndAbstraction.Exercises.FoodShortage;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Buyer> buyers = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            if (tokens.length == 4) {
                Citizen citizen = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2], tokens[3]);
                buyers.put(tokens[0], citizen);
            } else {
                Rebel rebel = new Rebel(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                buyers.put(tokens[0], rebel);
            }
        }

        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            if (buyers.containsKey(input)) {
                buyers.get(input).buyFood();
            }

            input = scanner.nextLine();
        }

        int sum = 0;
        for (Map.Entry<String, Buyer> entry : buyers.entrySet()) {
            sum += entry.getValue().getFood();
        }

        System.out.println(sum);
    }
}
