package Arrays.MoreExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lengthOfSeq = Integer.parseInt(scanner.nextLine());
        String[] bestSeq = new String[lengthOfSeq];
        int leftmostIndex = 1;
        int bestSum = 0;
        int bestSample = 0;
        int bestLength = -1;

        int sampleCount = 0;
        String input = scanner.nextLine();
        while (!input.equals("Clone them!")) {
            sampleCount++;
            String[] seq =input.trim().split("!+");
            List<String> currentSeqLength = new ArrayList<>();

            int currentIdx = 0;
            int currentSum = 0;
            int maxLength = 0;
            int currentBestIdx = 0;

            for (int i = 0; i < seq.length; i++) {
                if (seq[i].equals("1")) {
                    currentSeqLength.add("1");
                    if (currentSeqLength.size() == 1) {
                        currentIdx = i;
                    }
                    currentSum += 1;
                }
                if (seq[i].equals("0") || i == seq.length - 1) {
                    if (currentSeqLength.size() > maxLength) {
                        maxLength = currentSeqLength.size();
                        currentBestIdx = currentIdx;
                    }
                    currentSeqLength = new ArrayList<>();
                }
            }

            if (maxLength > bestLength || (maxLength == bestLength && currentBestIdx < leftmostIndex)
                    || (maxLength == bestLength && currentBestIdx == leftmostIndex && currentSum > bestSum)
            ) {
                bestLength = maxLength;
                bestSum = currentSum;
                bestSample = sampleCount;
                leftmostIndex = currentBestIdx;
                bestSeq = seq;
            }

            input = scanner.nextLine();
        }
        System.out.printf("Best DNA sample %d with sum: %d.%n", bestSample, bestSum);
        System.out.println(String.join(" ", bestSeq));
    }
}
