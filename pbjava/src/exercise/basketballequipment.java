package exercise;

import java.util.Scanner;

public class basketballequipment {
    public static void main(String[] args) {
        //Баскетболни кецове – цената им е 40% по-малка от таксата за една година
        //
        //• Баскетболен екип – цената му е 20% по-евтина от тази на кецовете
        //
        //• Баскетболна топка – цената ѝ е 1 / 4 от цената на баскетболния екип
        //
        //• Баскетболни аксесоари – цената им е 1 / 5 от цената на баскетболната топка
        Scanner scanner = new Scanner(System.in);
        int tax = Integer.parseInt(scanner.nextLine());
        double sneakers = tax - tax * 40 / 100.0;
        double suit = sneakers - sneakers * 20 / 100.0;
        double ball = suit / 4;
        double acc = ball / 5;

        double sum = tax + sneakers + suit + ball + acc;

        System.out.println(sum);


    }
}
