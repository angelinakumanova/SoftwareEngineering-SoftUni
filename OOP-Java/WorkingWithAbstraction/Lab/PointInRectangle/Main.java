package WorkingWithAbstraction.Lab.PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] coordinates = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        Point bottomLeft = new Point(coordinates[0], coordinates[1]);
        Point topRight = new Point(coordinates[2],coordinates[3]);

        Rectangle rectangle = new Rectangle(bottomLeft, topRight);

        int points = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < points; i++) {
            int[] coords = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            Point pointToCompare = new Point(coords[0], coords[1]);
            System.out.println(rectangle.contains(pointToCompare));
        }
    }
}
