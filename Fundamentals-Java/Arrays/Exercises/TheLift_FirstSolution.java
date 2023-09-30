package Arrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class TheLift_FirstSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int people = Integer.parseInt(scanner.nextLine());
        int[] wagons = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < wagons.length; i++) {
            if (wagons[i] < 4) {
                if (people >= 4 && wagons[i] == 0) {
                    wagons[i] += 4;
                    people -= 4;
                } else if (wagons[i] >= 1 && wagons[i] <= 3 && people > 0){
                    int availableSpace = 4 - wagons[i];
                    if (availableSpace > people) {
                        wagons[i] += people;
                        people = 0;
                    } else {
                        wagons[i] += availableSpace;
                        people -= availableSpace;

                    }
                } else {
                    wagons[i] += people;
                    people = 0;
                }
            }
        }
        boolean isFull = true;
        for (int i = 0; i < wagons.length; i++) {
            if (wagons[i] != 4) {
                isFull = false;
            }
        }
        if (!isFull && people == 0) {
            System.out.println("The lift has empty spots!");
        } else if (people > 0){
            System.out.printf("There isn't enough space! %d people in a queue!%n", people);
        }

        for (int wagon : wagons) {
            System.out.print(wagon + " ");
        }

    }
}

