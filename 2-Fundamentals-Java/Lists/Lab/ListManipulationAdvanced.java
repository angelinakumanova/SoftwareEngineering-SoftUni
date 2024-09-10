package Lists.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("end")) {

            if (command.contains("Contains")) {
                int number = Integer.parseInt(command.split(" ")[1]);
                if (numbers.contains(number)) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No such number");
                }
            } else if (command.equals("Print even")) {
                for (int i = 0; i < numbers.size(); i++) {
                    if (numbers.get(i) % 2 == 0) {
                        System.out.print(numbers.get(i) + " ");
                    }
                }
                System.out.println();
            } else if (command.equals("Print odd")) {
                for (int i = 0; i < numbers.size(); i++) {
                    if (numbers.get(i) % 2 != 0) {
                        System.out.print(numbers.get(i) + " ");
                    }
                }
                System.out.println();
            } else if (command.equals("Get sum")) {
                int sum = 0;
                for (int i = 0; i < numbers.size(); i++) {
                    sum += numbers.get(i);
                }
                System.out.println(sum);
            } else if (command.contains("Filter")) {
                int number = Integer.parseInt(command.split(" ")[2]);
                String operator = command.split(" ")[1];

                if (operator.equals(">") || operator.equals(">=")) {
                    for (int i = 0; i < numbers.size(); i++) {
                        if (operator.equals(">")) {
                            if (numbers.get(i) > number) {
                                System.out.print(numbers.get(i) + " ");
                            }
                        } else {
                            if (numbers.get(i) >= number) {
                                System.out.print(numbers.get(i) + " ");
                            }
                        }
                    }
                    System.out.println();
                } else if (operator.equals("<") || operator.equals("<=")) {
                    for (int i = 0; i < numbers.size(); i++) {
                        if (operator.equals("<")) {
                            if (numbers.get(i) < number) {
                                System.out.print(numbers.get(i) + " ");
                            }
                        } else {
                            if (numbers.get(i) <= number) {
                                System.out.print(numbers.get(i) + " ");
                            }
                        }
                    }
                    System.out.println();
                }
            }

            command = scanner.nextLine();
        }
    }
}
