package additionalexcs;

import java.util.Scanner;

public class traininglab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double w = Double.parseDouble(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());

        double zalah = (h * 100) - 100;
        double buronared = zalah / 70;
        int result1 = (int)buronared;
        double buro = (w * 100 ) / 120;
        int result2 = (int)buro;
        double obshtomesta = (result1 * result2) - 3;

        System.out.printf("%.0f", obshtomesta);

    }
}
