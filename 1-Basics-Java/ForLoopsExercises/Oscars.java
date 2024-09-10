package ForLoopsExercises;

import java.util.Scanner;

public class Oscars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        double academyPoints = Double.parseDouble(scanner.nextLine());
        int judges = Integer.parseInt(scanner.nextLine());
        double sum = 0.0;
        boolean isNominated = false;

        for (int i = 0; i < judges; i++) {
            String judgeName = scanner.nextLine();
            double judgePoints = Double.parseDouble(scanner.nextLine());

            sum += judgeName.length() * judgePoints / 2;
            if (sum + academyPoints > 1250.5) {
                System.out.printf("Congratulations, %s got a nominee for leading role with %.1f!", name, sum + academyPoints);
                isNominated = true;
                break;
            }
        } if (!isNominated) {
            System.out.printf("Sorry, %s you need %.1f more!", name, 1250.5 - (sum + academyPoints));
        }
    }
}

