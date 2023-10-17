package ExamProblems.MidExams;

import java.util.Arrays;
import java.util.Scanner;

public class IIMidExam_ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String command = scanner.nextLine();

        while (!command.equals("end")) {

            if (command.contains("swap")) {
                int firstIndex = Integer.parseInt(command.split(" ")[1]);
                int secondIndex = Integer.parseInt(command.split(" ")[2]);

                int firstElement = array[firstIndex];
                int secondElement = array[secondIndex];

                array[firstIndex] = secondElement;
                array[secondIndex] = firstElement;
            } else if (command.contains("multiply")) {
                int firstIndex = Integer.parseInt(command.split(" ")[1]);
                int secondIndex = Integer.parseInt(command.split(" ")[2]);

                int product = array[firstIndex] * array[secondIndex];
                array[firstIndex] = product;
            } else if (command.equals("decrease")) {
                for (int i = 0; i < array.length; i++) {
                    array[i] = array[i] - 1;
                }
            }

            command = scanner.nextLine();
        }

        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                System.out.print(array[i]);
                break;
            }
            System.out.print(array[i] + ", ");
        }
    }
}
