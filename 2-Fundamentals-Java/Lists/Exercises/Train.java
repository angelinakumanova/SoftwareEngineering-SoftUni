package Lists.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> wagons = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int maxCapacity = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        while (!input.equals("end")) {

            if (input.contains("Add")) {
                int wagon = Integer.parseInt(input.split(" ")[1]);
                wagons.add(wagon);
            } else {
                int passengers = Integer.parseInt(input);
                for (int i = 0; i < wagons.size(); i++) {
                    if (passengers <= maxCapacity) {
                        if (wagons.get(i) + passengers <= maxCapacity) {
                            wagons.set(i, (wagons.get(i) + passengers));
                            break;
                        }
                    }
                }
            }

            input = scanner.nextLine();
        }

        for (int wagon : wagons) {
            System.out.print(wagon + " ");
        }
    }
}
