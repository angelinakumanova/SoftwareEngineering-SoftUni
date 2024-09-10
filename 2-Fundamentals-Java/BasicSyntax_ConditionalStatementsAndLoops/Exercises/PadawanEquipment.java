package BasicSyntax_ConditionalStatements_Loops.Exercises;

import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double georgeMoney = Double.parseDouble(scanner.nextLine());
        int studentsCount = Integer.parseInt(scanner.nextLine());
        double priceOfALightsaber = Double.parseDouble(scanner.nextLine());
        double priceOfRobe = Double.parseDouble(scanner.nextLine());
        double priceOfBelt = Double.parseDouble(scanner.nextLine());
        double lightsaberMore = Math.ceil(studentsCount * 0.1);
        double sum =  ((lightsaberMore + studentsCount) * priceOfALightsaber) +
                (priceOfRobe * studentsCount) + (priceOfBelt * studentsCount);

        for (int i = 1; i <= studentsCount; i++) {
            if (i % 6 == 0) {
                sum -= priceOfBelt;
            }
        }
        if (georgeMoney >= sum) {
            System.out.printf("The money is enough - it would cost %.2flv.", sum);
        } else {
            System.out.printf("George Lucas will need %.2flv more.", sum - georgeMoney);
        }
    }
}
