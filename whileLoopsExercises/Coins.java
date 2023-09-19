package whileLoopsExercises;

import java.util.Scanner;

public class Coins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double money = Double.parseDouble(scanner.nextLine()) * 100;
        int countCoins = 0;
        money = (int) money;

        while (money > 0) {
            if (money >= 200) {
                money -= 200;
                countCoins++;
            } else if (money >= 100) {
                money -= 100;
                countCoins++;
            } else if (money >= 50) {
                money -= 50;
                countCoins++;
            } else if (money >= 20) {
                money -= 20;
                countCoins++;
            } else if (money >= 10) {
                money -= 10;
                countCoins++;
            } else if (money >= 5) {
                money -= 5;
                countCoins++;
            } else if (money >= 2) {
                money -= 2;
                countCoins++;
            } else {
                money -=1;
                countCoins++;
            }
        }
        System.out.println(countCoins);
    }
}
