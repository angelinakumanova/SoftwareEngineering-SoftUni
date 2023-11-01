package Lists.MoreExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DrumSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double savings = Double.parseDouble(scanner.nextLine());
        List<Integer> qualityOfDrums = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> initialQuality = new java.util.ArrayList<>(List.copyOf(qualityOfDrums));

        String input = scanner.nextLine();

        while (!input.equals("Hit it again, Gabsy!")) {
            int damage = Integer.parseInt(input);

            for (int i = 0; i < qualityOfDrums.size(); i++) {
                boolean isRemoved = false;
                int drum = qualityOfDrums.get(i);
                drum -= damage;
                if (drum <= 0) {
                    int price = initialQuality.get(i) * 3;
                    savings -= price;
                    if (savings < 0) {
                        qualityOfDrums.remove(i);
                        initialQuality.remove(i);
                        savings += price;
                        isRemoved = true;
                        i--;
                    } else {
                        drum = initialQuality.get(i);
                    }
                }
                if (!isRemoved) {
                    qualityOfDrums.set(i, drum);
                }

            }

            input = scanner.nextLine();
        }

        for (int drum : qualityOfDrums) {
            System.out.print(drum + " ");
        }
        System.out.println();
        System.out.printf("Gabsy has %.2flv.", savings);
    }
}
