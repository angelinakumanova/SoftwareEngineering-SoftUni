package Lists.MoreExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int midIdx = numbers.size() / 2;
        double leftCarTime = 0;
        double rightCarTime = 0;

        for (int leftCar = 0; leftCar < midIdx; leftCar++) {
            if (numbers.get(leftCar) == 0) {
                leftCarTime *= 0.8;
            }
            leftCarTime += numbers.get(leftCar);
        }
        for (int rightCar = numbers.size() - 1; rightCar > midIdx; rightCar--) {
            if (numbers.get(rightCar) == 0) {
                rightCarTime *= 0.8;
            }
            rightCarTime += numbers.get(rightCar);
        }

        if (leftCarTime > rightCarTime) {
            System.out.printf("The winner is right with total time: %.1f", rightCarTime);
        } else if (leftCarTime < rightCarTime){
            System.out.printf("The winner is left with total time: %.1f", leftCarTime);
        }
    }
}
