package Exams.Exam_14Dec22;

import java.util.*;

public class ClimbThePeaks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> dailyFoodQuantity = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(dailyFoodQuantity::push);

        Deque<Integer> dailyStamina = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(dailyStamina::offer);

        List<String> conqueredPeaks = new ArrayList<>();

        Deque<String> peaks = new ArrayDeque<>();
        peaks.offer("Vihren:80");
        peaks.offer("Kutelo:90");
        peaks.offer("Banski Suhodol:100");
        peaks.offer("Polezhan:60");
        peaks.offer("Kamenitza:70");
        while (!dailyStamina.isEmpty() && !dailyFoodQuantity.isEmpty()) {
            int currentFoodQuantity = dailyFoodQuantity.peek();
            int currentStamina = dailyStamina.peek();
            int sum = currentStamina + currentFoodQuantity;

            String[] currentPeakInfo = peaks.peek().split(":");
            String peakName = currentPeakInfo[0];
            int difficulty = Integer.parseInt(currentPeakInfo[1]);
            if (sum >= difficulty) {
                conqueredPeaks.add(peakName);
                dailyFoodQuantity.pop();
                dailyStamina.poll();
                peaks.poll();
            } else {
                dailyFoodQuantity.pop();
                dailyStamina.poll();
            }

            if (peaks.isEmpty()) {
                System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
                printPeaks(conqueredPeaks);
                break;
            }
        }

        if (!peaks.isEmpty()) {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
            if (!conqueredPeaks.isEmpty()) {
                printPeaks(conqueredPeaks);
            }
        }

    }
    private static void printPeaks(List<String> peaks) {
        System.out.println("Conquered peaks:");
        peaks.forEach(System.out::println);
    }
}
