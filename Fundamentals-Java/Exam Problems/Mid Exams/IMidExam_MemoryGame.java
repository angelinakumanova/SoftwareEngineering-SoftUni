package ExamProblems.MidExams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class IMidExam_MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> elementsSeq = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        String input = scanner.nextLine();

        int countMoves = 0;
        while (!input.equals("end")) {
            int firstIndex = Integer.parseInt(input.split(" ")[0]);
            int secondIndex = Integer.parseInt(input.split(" ")[1]);



            countMoves++;
            if (firstIndex == secondIndex || firstIndex >= elementsSeq.size() || secondIndex >= elementsSeq.size()
            || firstIndex < 0 || secondIndex < 0) {
                elementsSeq.add(elementsSeq.size() / 2, "-" + (countMoves) + "a");
                elementsSeq.add((elementsSeq.size() / 2) + 1, "-" + (countMoves) + "a");
                System.out.println("Invalid input! Adding additional elements to the board");
            } else if (elementsSeq.get(firstIndex).equals(elementsSeq.get(secondIndex))) {
                String elementAtFirstIdx = elementsSeq.get(firstIndex);
                String elementAtSecondIdx = elementsSeq.get(secondIndex);
                System.out.printf("Congrats! You have found matching elements - %s!%n", elementsSeq.get(firstIndex));
                elementsSeq.remove(elementAtFirstIdx);
                elementsSeq.remove(elementAtSecondIdx);
            } else  {
                System.out.println("Try again!");
            }

            if (elementsSeq.size() == 0) {
                System.out.printf("You have won in %d turns!", countMoves);
                return;
            }

            input = scanner.nextLine();
        }

        System.out.println("Sorry you lose :(");
        System.out.println(String.join(" ", elementsSeq));

    }
}
