package ConditionalStatemensexercises2_0;

import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String projection = scanner.nextLine();
        int r = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());
        int room = r * c;

        double income = 0.0;

        switch (projection) {
            case "Premiere":
                income = room * 12;
                break;
            case "Normal":
                income = room * 7.50;
                break;
            case "Discount":
                income = room * 5.00;
        }
        System.out.printf("%.2f leva", income);

    }
}
