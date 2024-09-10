package exercise;

import java.util.Scanner;

public class fooddelivery {
    public static void main(String[] args) {
        //Ресторант отваря врати и предлага няколко менюта на преференциални цени:
        //• Пилешко меню – 10.35 лв.
        //• Меню с риба – 12.40 лв.
        //• Вегетарианско меню – 8.15 лв.
        //Напишете програма, която изчислява колко ще струва на група хора да си поръчат храна за вкъщи.
        //Групата ще си поръча и десерт, чиято цена е равна на 20% от общата сметка (без доставката).
        //Цената на доставка е 2.50 лв и се начислява най-накрая.
        //Вход
        //От конзолата се четат 3 реда:
        //· Брой пилешки менюта – цяло число в интервала [0 … 99]
        //· Брой менюта с риба – цяло число в интервала [0 … 99]
        //· Брой вегетариански менюта – цяло число в интервала [0 … 99]
        //Изход
        //Да се отпечата на конзолата един ред: "{цена на поръчката}"
        Scanner scanner = new Scanner(System.in);
        double chicken = 10.35;
        double fish = 12.40;
        double veg = 8.15;
        double delivery = 2.50;

        int amountchicken = Integer.parseInt(scanner.nextLine());
        int amountfish = Integer.parseInt(scanner.nextLine());
        int amountveg = Integer.parseInt(scanner.nextLine());

        double sumdel = (amountchicken * chicken) + (amountfish * fish) + (amountveg * veg);
        double dessert = 20 / 100.0 * sumdel;
        double finalsum = sumdel + dessert + delivery;

        System.out.println(finalsum);
    }

}
