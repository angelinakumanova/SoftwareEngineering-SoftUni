package DataTypesAndVariables.Exercises;

import java.util.Scanner;

public class Snowballs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfSnowballs = Integer.parseInt(scanner.nextLine());
        double biggestSnowball = Double.MIN_VALUE;
        int biggestSnowballSnow = 0, biggestSnowballTime = 0, biggestSnowballQuality = 0;

        for (int i = 1; i <= numberOfSnowballs ; i++) {
            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());

            double snowballValue = Math.pow(snowballSnow / snowballTime, snowballQuality);

            if (snowballValue > biggestSnowball) {
                biggestSnowball = snowballValue;
                biggestSnowballSnow = snowballSnow;
                biggestSnowballTime = snowballTime;
                biggestSnowballQuality = snowballQuality;
            }
        }
        System.out.printf("%d : %d = %.0f (%d)", biggestSnowballSnow,
                biggestSnowballTime,
                biggestSnowball,
                biggestSnowballQuality);
    }
}
