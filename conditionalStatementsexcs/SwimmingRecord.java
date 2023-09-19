package conditionalStatementsexcs;

import java.util.Scanner;

public class SwimmingRecord {
    public static void main(String[] args) {
        //1.Рекордът в секунди – реално число в интервала [0.00 … 100000.00]
        //2.Разстоянието в метри – реално число в интервала [0.00 … 100000.00]
        //3.Времето в секунди, за което плува разстояние от 1 м. - реално число в интервала [0.00 … 1000.00]

        Scanner scanner = new Scanner(System.in);
        double record = Double.parseDouble(scanner.nextLine());
        double distance = Double.parseDouble(scanner.nextLine());
        double timeper1m = Double.parseDouble(scanner.nextLine());

        double distanceplustime = distance * timeper1m;
        double resistance = Math.floor(distance / 15) * 12.5;
        double total = distanceplustime + resistance;

        if (total < record) {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", total);
        } else if (total >= record) {
            Math.ceil(total = total - record);
            System.out.printf("No, he failed! He was %.2f seconds slower.", total);
        }

    }
}
