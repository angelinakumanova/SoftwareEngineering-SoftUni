package Lists.MoreExercises;

import java.util.*;
import java.util.stream.Collectors;

public class MixedUpLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstSeqNumbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> secondSeqNumbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> finalSeq = new ArrayList<>();

        for (int i = 0; i < firstSeqNumbers.size(); i++) {
            if (i == firstSeqNumbers.size() - 1 || i == secondSeqNumbers.size() - 1) {
                finalSeq.add(firstSeqNumbers.get(i));
                finalSeq.add(secondSeqNumbers.get(secondSeqNumbers.size() - 1 - i));
                break;
            }
            finalSeq.add(firstSeqNumbers.get(i));
            finalSeq.add(secondSeqNumbers.get(secondSeqNumbers.size() - 1 - i));
        }

        Collections.sort(finalSeq);
        
        if (firstSeqNumbers.size() > secondSeqNumbers.size()) {
            int firstNumber = firstSeqNumbers.get(secondSeqNumbers.size());
            int secondNumber = firstSeqNumbers.get(secondSeqNumbers.size() + 1);

            for (int i = 0; i < finalSeq.size(); i++) {
                if (firstNumber > secondNumber) {
                    if (firstNumber > finalSeq.get(i) && secondNumber < finalSeq.get(i)) {
                        System.out.print(finalSeq.get(i) + " ");
                    }
                } else {
                    if (secondNumber > finalSeq.get(i) && firstNumber < finalSeq.get(i)) {
                        System.out.print(finalSeq.get(i) + " ");
                    }
                }
            }
        } else {
            int firstNumber = secondSeqNumbers.get(0);
            int secondNumber = secondSeqNumbers.get(1);

            for (int i = 0; i < finalSeq.size(); i++) {
                if (firstNumber > secondNumber) {
                    if (firstNumber > finalSeq.get(i) && secondNumber < finalSeq.get(i)) {
                        System.out.print(finalSeq.get(i) + " ");
                    }
                } else {
                    if (secondNumber > finalSeq.get(i) && firstNumber < finalSeq.get(i)) {
                        System.out.print(finalSeq.get(i) + " ");
                    }
                }
            }
        }
    }
}
