package Methods.MoreExercises;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CenterPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x1 = Double.parseDouble(scanner.nextLine());
        double y1 = Double.parseDouble(scanner.nextLine());

        double x2 = Double.parseDouble(scanner.nextLine());
        double y2 = Double.parseDouble(scanner.nextLine());

        printCoordinateSystem(x1, y1, x2, y2);
    }

    public static void printCoordinateSystem(double x1, double y1, double x2, double y2) {

        double result = Math.abs((x1 + y1));
        double secondResult = Math.abs((x2 + y2));

        if (result < secondResult) {
            System.out.print("(");
            System.out.print(new DecimalFormat("0.##").format(x1));
            System.out.print(", ");
            System.out.print(new DecimalFormat("0.##").format(y1));
            System.out.print(")");
        } else {
            System.out.print("(");
            System.out.print(new DecimalFormat("0.##").format(x2));
            System.out.print(", ");
            System.out.print(new DecimalFormat("0.##").format(y2));
            System.out.print(")");
        }


    }
}
