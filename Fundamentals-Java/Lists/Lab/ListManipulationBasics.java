package Lists.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("end")) {

            if (command.contains("Add")) {
                int number = Integer.parseInt(command.split(" ")[1]);
                numbers.add(number);
            } else if (command.contains("Remove") && !command.contains("RemoveAt")) {
                int number = Integer.parseInt(command.split(" ")[1]);
                numbers.remove(Integer.valueOf(number));
            } else if (command.contains("RemoveAt")) {
                int index = Integer.parseInt(command.split(" ")[1]);
                numbers.remove(index);
            } else if (command.contains("Insert")) {
                int number = Integer.parseInt(command.split(" ")[1]);
                int index = Integer.parseInt(command.split(" ")[2]);
                numbers.add(index, number);
            }

            command = scanner.nextLine();
        }

        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}
