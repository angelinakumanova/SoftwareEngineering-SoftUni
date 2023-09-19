package exercise;

import java.util.Scanner;

public class fishtank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //1. Дължина в см – цяло число в интервала [10 … 500]
        //
        //2. Широчина в см – цяло число в интервала [10 … 300]
        //
        //3. Височина в см – цяло число в интервала [10… 200]
        //
        //4. Процент – реално число в интервала [0.000 … 100.000]
        int length = Integer.parseInt(scanner.nextLine());
        int width = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());
        double percent = Double.parseDouble(scanner.nextLine());

        double volume = length * width * height;
        double volumelitres = volume / 1000;
        double sum = volumelitres * (1 - percent / 100.0);

        System.out.println(sum);
    }
}
