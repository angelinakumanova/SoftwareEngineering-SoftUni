package whileLoopsExercises;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double neededMoney = Double.parseDouble(scanner.nextLine());
        double availableMoney = Double.parseDouble(scanner.nextLine());
        int countSpend = 0;
        int dayCounter = 0;


        while(countSpend < 5 && availableMoney < neededMoney) {
            String spendOrSave = scanner.nextLine();
            double number = Double.parseDouble(scanner.nextLine());
            if ("spend".equals(spendOrSave)) {
                availableMoney -= number;
                if (availableMoney < 0) {
                    availableMoney = 0;
                }
                dayCounter++;
                countSpend++;
            }
            if ("save".equals(spendOrSave)) {
                availableMoney += number;
                dayCounter++;
                countSpend = 0;
            }
        }
        if (countSpend == 5) {
            System.out.println("You can't save the money.");
            System.out.println(dayCounter);
        }
        if (availableMoney >= neededMoney) {
            System.out.printf("You saved the money for %d days.", dayCounter);
        }

    }
}
