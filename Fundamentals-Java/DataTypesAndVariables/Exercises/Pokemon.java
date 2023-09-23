package DataTypesAndVariables.Exercises;

import java.util.Scanner;

public class Pokemon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pokePower = Integer.parseInt(scanner.nextLine());
        int startingPower = pokePower;
        int distanceBetweenTargets = Integer.parseInt(scanner.nextLine());
        int exhaustionFactor = Integer.parseInt(scanner.nextLine());
        int targetsCount = 0;

        while (pokePower >= distanceBetweenTargets) {
            targetsCount++;
            pokePower -= distanceBetweenTargets;

            if (pokePower == startingPower / 2) {
                if (exhaustionFactor != 0) {
                    pokePower /= exhaustionFactor;
                }
            }
        }
        System.out.println(pokePower);
        System.out.println(targetsCount);

    }
}
