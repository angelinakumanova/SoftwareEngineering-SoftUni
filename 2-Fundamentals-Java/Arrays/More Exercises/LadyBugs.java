package Arrays.MoreExercises;

import java.util.Arrays;
import java.util.Scanner;

public class LadyBugs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeOfField = Integer.parseInt(scanner.nextLine());
        int[] ladybugsIndices = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] ladyBugs = new int[sizeOfField];
        for (int i = 0; i < ladybugsIndices.length; i++) {
            if (ladybugsIndices[i] >= 0 && ladybugsIndices[i] < ladyBugs.length) {
                ladyBugs[ladybugsIndices[i]] = 1;
            }
        }

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }

            int index = Integer.parseInt(input.split(" ")[0]);
            String direction = input.split(" ")[1];
            int flyLength = Integer.parseInt(input.split(" ")[2]);

            if (index >= 0 && index <= ladyBugs.length - 1 && ladyBugs[index] == 1) {
                ladyBugs[index] = 0;

                if (direction.equals("right")) {
                    index += flyLength;
                    while (index <= ladyBugs.length - 1 && ladyBugs[index] == 1) {
                        index += flyLength;
                    }

                    if (index <= ladyBugs.length - 1) {
                        ladyBugs[index] = 1;
                    }
                } else if (direction.equals("left")) {
                    index -= flyLength;

                    while (index >= 0 && ladyBugs[index] == 1) {
                        index -= flyLength;
                    }

                    if (index >= 0) {
                        ladyBugs[index] = 1;
                    }
                }
            }
        }

        for (int ladyBug : ladyBugs) {
            System.out.print(ladyBug + " ");
        }
    }
}
