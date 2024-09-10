package exercise;

import java.util.Scanner;

public class repainting {
    public static void main(String[] args) {
        //Необходимо количество найлон (в кв.м.) - цяло число в интервала [1... 100]
        //
        //2. Необходимо количество боя (в литри) - цяло число в интервала [1…100]
        //
        //3. Количество разредител (в литри) - цяло число в интервала [1…30]
        //
        //4. Часовете, за които майсторите ще свършат работата - цяло число в интервала [1…9]
        Scanner scanner = new Scanner(System.in);
        int nylon = Integer.parseInt(scanner.nextLine()) + 2;
        int paintlitres = Integer.parseInt(scanner.nextLine());
        int diluent = Integer.parseInt(scanner.nextLine());
        int hoursneeded = Integer.parseInt(scanner.nextLine());

        //Предпазен найлон - 1.50 лв. за кв. метър
        //
        //· Боя - 14.50 лв. за литър
        //
        //· Разредител за боя - 5.00 лв. за литър
        double nylonp = nylon * 1.50;
        double paintp = paintlitres * 14.50;
        paintp = paintp + (paintp * 10 / 100);
        double diluentp = diluent * 5.00;

        //За всеки случай, към необходимите материали, Румен иска да добави още 10% от количеството боя и 2 кв.м.
        // найлон, разбира се и 0.40 лв. за торбички. Сумата, която се заплаща на майсторите за 1 час работа,
        // е равна на 30% от сбора на всички разходи за материали.
        double sum = nylonp + paintp + diluentp + 0.40;
        double workers = (sum * 30 / 100) * hoursneeded;

        double finalsum = sum + workers;

        System.out.println(finalsum);

    }
}
