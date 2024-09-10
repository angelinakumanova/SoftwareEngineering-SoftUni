package WhileLoops;

import java.util.Scanner;

public class Graduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int grade = 1;
        int count = 0;
        double sum = 0.0;


        String input = scanner.nextLine();
        while (grade <= 12) {
            double number = Double.parseDouble(input);
            sum += number;
            if (grade == 12) {
                System.out.printf("%s graduated. Average grade: %.2f", name, sum / grade);
                break;
            }
            if(number >= 4) {
                grade++;
            } else {
                count++;
            }

            if (count > 1) {
                System.out.printf("%s has been excluded at %d grade", name, grade);
                break;
            }
            input = scanner.nextLine();
        }
    }
}
