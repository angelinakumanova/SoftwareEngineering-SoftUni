package additionalexcs;

import java.util.Scanner;

public class Fishland {
    public static void main(String[] args) {
        //Георги ще има гости вечерта и решава да ги нагости с паламуд, сафрид и миди.
        // Затова отива на рибната борса, за да си купи по няколко килограма.
        // Oт конзолата се въвеждат цените в лева на скумрията и цацата.
        // Също количеството на паламуд, сафрид и миди в килограми. Колко пари ще са му необходими, за да плати сметката си, ако цените на борсата са:
        //•	Паламуд – 60% по-скъп от скумрията
        //•	Сафрид – 80% по-скъп от цацата
        //•	Миди – 7.50 лв. за килограм
        //Вход
        //От конзолата се четат 5 числа:
        //•	Първи ред – цена на скумрията на килограм. Реално число в интервала [0.00…40.00]
        //•	Втори ред – цена на цацата на килограм. Реално число в интервала [0.00…30.00]
        //•	Трети ред – килограма паламуд. Реално число в интервала [0.00…50.00]
        //•	Четвърти ред – килограма сафрид. Реално число в интервала [0.00… 70.00]
        //•	Пети ред – килограма миди. Цяло число в интервала [0 ... 100]
        //Изход
        //Да се отпечата на конзолата едно число с плаваща запетая: колко пари ще са нужни на Георги,
        // за да си плати сметката. Числото трябва да е форматирано до вторият знак след десетичната запетая (1.2457 -> 1.25).

        Scanner scanner = new Scanner(System.in);
        double skumriqp = Double.parseDouble(scanner.nextLine());
        double cacap = Double.parseDouble(scanner.nextLine());
        double kgpalamud = Double.parseDouble(scanner.nextLine());
        double kgsafrid = Double.parseDouble(scanner.nextLine());
        int kgmidi = Integer.parseInt(scanner.nextLine());

        double palamudcena = kgpalamud * (skumriqp + skumriqp * 60 / 100.0);
        double safridcena = kgsafrid * (cacap + cacap * 80 / 100.0);
        double midicena = kgmidi * 7.50;

        double sum = palamudcena + safridcena + midicena;

        System.out.printf("%.2f", sum);
        

    }

}
