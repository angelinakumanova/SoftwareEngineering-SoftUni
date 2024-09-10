package Lists.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersSeq = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int sum = 0;
        while (numbersSeq.size() > 0) {
            int index = Integer.parseInt(scanner.nextLine());

            if (index < 0) {
                int removedElement = numbersSeq.get(0);
                sum += removedElement;
                int lastElement = numbersSeq.get(numbersSeq.size() - 1);
                numbersSeq.remove(0);
                numbersSeq.add(0, lastElement);

                for (int i = 0; i < numbersSeq.size(); i++) {
                    if (numbersSeq.get(i) <= removedElement) {
                        int element = numbersSeq.get(i);
                        element += removedElement;
                        numbersSeq.set(i, element);
                    } else {
                        int element = numbersSeq.get(i);
                        element -= removedElement;
                        numbersSeq.set(i, element);
                    }
                }
            } else if (index > numbersSeq.size() - 1) {
                int removedElement = numbersSeq.get(numbersSeq.size() - 1);
                sum += removedElement;
                int firstElement = numbersSeq.get(0);
                numbersSeq.remove(numbersSeq.size() - 1);
                numbersSeq.add(firstElement);
                for (int i = 0; i < numbersSeq.size(); i++) {
                    if (numbersSeq.get(i) <= numbersSeq.get(numbersSeq.size() - 1)) {
                        int element = numbersSeq.get(i);
                        element += removedElement;
                        numbersSeq.set(i, element);
                    } else {
                        int element = numbersSeq.get(i);
                        element -= removedElement;
                        numbersSeq.set(i, element);
                    }
                }

            } else {
                int elementAtIndex = numbersSeq.get(index);
                sum += elementAtIndex;
                numbersSeq.remove(index);
                for (int i = 0; i < numbersSeq.size(); i++) {
                    if (numbersSeq.get(i) <= elementAtIndex) {
                        int element = numbersSeq.get(i);
                        element += elementAtIndex;
                        numbersSeq.set(i, element);
                    } else {
                        int element = numbersSeq.get(i);
                        element -= elementAtIndex;
                        numbersSeq.set(i, element);
                    }
                }
            }
        }

        System.out.println(sum);
    }


}
