package whileLoopsExercises;

import java.util.Scanner;

public class Moving {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());
        int freeSpace = width * length * height;

        while (freeSpace > 0) {
            String input = scanner.nextLine();
            if ("Done".equals(input)) {
                break;
            }
            int cardboardBoxes = Integer.parseInt(input);
            freeSpace -= cardboardBoxes;
        }
        if (freeSpace < 0) {
            System.out.printf("No more free space! You need %d Cubic meters more.", Math.abs(freeSpace));
        } else {
            System.out.printf("%d Cubic meters left.", freeSpace);
        }
    }
}
