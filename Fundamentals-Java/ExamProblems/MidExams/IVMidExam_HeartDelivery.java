package ExamProblems.MidExams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class IVMidExam_HeartDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> houses = Arrays.stream(scanner.nextLine().split("@"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        int jumpLength = 0;
        int lastIndex = 0;
        while (!command.equals("Love!")) {

            if(command.contains("Jump")) {
                int firstJump = Integer.parseInt(command.split(" ")[1]);
                jumpLength += firstJump;
                if (jumpLength <= 0 || jumpLength >= houses.size()) {
                    jumpLength = 0;
                }
                int house = houses.get(jumpLength);

                if (house == 0) {
                    System.out.printf("Place %d already had Valentine's day.%n", jumpLength);
                }
                if (house - 2 == 0) {
                    house -= 2;
                    houses.set(jumpLength, house);
                    System.out.printf("Place %d has Valentine's day.%n", jumpLength);
                } else if (house > 0){
                    house -= 2;
                    houses.set(jumpLength, house);
                }

                lastIndex = jumpLength;
            }

            command = scanner.nextLine();
        }

        System.out.printf("Cupid's last position was %d.%n", lastIndex);
        int countFails = 0;
        for (int i = 0; i < houses.size(); i++) {
            if (houses.get(i) != 0) {
                countFails++;
            }
        }

        if (countFails == 0) {
            System.out.println("Mission was successful.");
        } else {
            System.out.printf("Cupid has failed %d places.%n", countFails);
        }

    }
}
