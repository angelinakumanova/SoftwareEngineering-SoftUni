package Lists.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersSeq = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int[] specialBomb = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int bomb = specialBomb[0];
        int power = specialBomb[1];


        while (numbersSeq.contains(bomb)){
            int numberIdx = numbersSeq.indexOf(bomb);

            int left = Math.max(0, numberIdx - power);
            int right = Math.min(numberIdx + power, numbersSeq.size() - 1);

            for (int i = right; i >= left; i--) {
                numbersSeq.remove(i);

            }
        }


        int sum = 0;
        for (int number : numbersSeq) {
            sum += number;
        }

        System.out.println(sum);


    }
}
