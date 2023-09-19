package exams;

import java.util.Scanner;

public class PCGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double processor = Double.parseDouble(scanner.nextLine());
        double videoCard = Double.parseDouble(scanner.nextLine());
        double ramMemory = Double.parseDouble(scanner.nextLine());
        int amountOfRAM = Integer.parseInt(scanner.nextLine());
        double discount = Double.parseDouble(scanner.nextLine());

        // v levove
        processor *= 1.57;
        videoCard *= 1.57;
        ramMemory *= 1.57;
        double priceOfRam = ramMemory * amountOfRAM;

        double processorDiscount = processor - processor * discount ;
        double videoCardDiscount = videoCard - videoCard * discount;

        double sum = processorDiscount + videoCardDiscount + priceOfRam;

        System.out.printf("Money needed - %.2f leva.", sum);
    }
}
