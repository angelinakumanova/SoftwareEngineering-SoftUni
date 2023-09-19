package conditionalStatementsexcs;

import java.util.Scanner;

public class LunchBreak {
    public static void main(String[] args) {
        //1.Име на сериал – текст
        //2.Продължителност на епизод  – цяло число в диапазона [10… 90]
        //3.Продължителност на почивката  – цяло число в диапазона [10… 120]

        Scanner scanner = new Scanner(System.in);
        String nameofseries = scanner.nextLine();
        int durationofanepisode = Integer.parseInt(scanner.nextLine());
        int durationofthebreak = Integer.parseInt(scanner.nextLine());

        double lunchtime = durationofthebreak / 8.0;
        double breaktime = durationofthebreak /4.0;
        double totalresttime = durationofthebreak - lunchtime - breaktime;

        if (totalresttime >= durationofanepisode) {
            totalresttime = Math.ceil(totalresttime - durationofanepisode);
            System.out.printf("You have enough time to watch %s and left with %.0f minutes free time.", nameofseries, totalresttime);
        } else if (durationofanepisode > totalresttime) {
            totalresttime = Math.ceil(durationofanepisode - totalresttime);
            System.out.printf("You don't have enough time to watch %s, you need %.0f more minutes.", nameofseries, totalresttime);

        }
    }
}
