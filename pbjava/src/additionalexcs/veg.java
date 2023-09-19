package additionalexcs;

import java.util.Scanner;

public class veg {
    public static void main(String[] args) {
        //•	Първи ред – Цена за килограм зеленчуци – реално число[0.00… 1000.00]
        //•	Втори ред – Цена за килограм плодове – реално число[0.00… 1000.00]
        //•	Трети ред – Общо килограми на зеленчуците – цяло число[0… 1000]
        //•	Четвърти ред – Общо килограми на плодовете – цяло число[0… 1000]
        Scanner scanner = new Scanner(System.in);
        double priceveg = Double.parseDouble(scanner.nextLine());
        double pricefr = Double.parseDouble(scanner.nextLine());
        int totalkgveg = Integer.parseInt(scanner.nextLine());
        int totalkgfr = Integer.parseInt(scanner.nextLine());

        double totalveg = priceveg * totalkgveg;
        double totalfr = pricefr * totalkgfr;
        double euro = 1.94;
        double sum = (totalveg + totalfr) / euro ;

        System.out.printf("%.2f", sum);

    }
}
