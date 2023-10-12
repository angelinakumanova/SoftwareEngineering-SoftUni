package Lists.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstDeck = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondDeck = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        for (int i = 0; i < firstDeck.size(); i++) {
            if (firstDeck.size() == 0 || secondDeck.size() == 0) {
                break;
            }
            if (firstDeck.get(i) > secondDeck.get(i)) {
                firstDeck.add(secondDeck.get(i));
                firstDeck.add(firstDeck.get(i));
                firstDeck.remove(i);
                secondDeck.remove(i);
            }   else if (firstDeck.get(i) < secondDeck.get(i)){
                secondDeck.add(firstDeck.get(i));
                secondDeck.add(secondDeck.get(i));
                firstDeck.remove(i);
                secondDeck.remove(i);
            } else {
                firstDeck.remove(i);
                secondDeck.remove(i);
            }
            i = -1;
        }

        if (firstDeck.size() > 0) {
            int sum = 0;
            for (int i = 0; i < firstDeck.size(); i++) {
                sum += firstDeck.get(i);
            }
            System.out.printf("First player wins! Sum: %d", sum);
        } else {
            int sum = 0;
            for (int i = 0; i < secondDeck.size(); i++) {
                sum += secondDeck.get(i);
            }
            System.out.printf("Second player wins! Sum: %d", sum);
        }
    }
}
