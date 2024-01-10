package ExamProblems.MidExams;

import java.util.*;
import java.util.stream.Collectors;

public class IIMidExam_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersSeq = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        double average = 0;
        for (int number : numbersSeq) {
            average += number;
        }
        average /= numbersSeq.size();

        Collections.sort(numbersSeq, Collections.reverseOrder());
        List<Integer> topNums = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < numbersSeq.size(); i++) {
            if (numbersSeq.get(i) > average) {
                topNums.add(numbersSeq.get(i));
                count++;
                if (count == 5) {
                    break;
                }
            }
        }

        if (topNums.size() == 0) {
            System.out.println("No");
        } else {
            for (int number : topNums) {
                System.out.print(number + " ");
            }
        }

    }
}
