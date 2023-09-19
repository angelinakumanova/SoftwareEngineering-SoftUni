package ForLoopsExercises;

import java.util.Scanner;

public class Hospital {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int period = Integer.parseInt(scanner.nextLine());
        int countTreatedPatients = 0;
        int countUntreatedPatients = 0;
        int untreatedPatients = 0;
        int doctors = 7;

        for (int i = 1; i <= period ; i++) {
            int patients = Integer.parseInt(scanner.nextLine());
            if (i % 3 == 0) {
                if (countUntreatedPatients > countTreatedPatients) {
                    doctors++;
                }
            }
            if (patients > doctors) {
                untreatedPatients = patients - doctors;
                countUntreatedPatients += untreatedPatients;
                countTreatedPatients += doctors;
            }
            if (patients <= doctors) {
                countTreatedPatients += patients;
            }

        }
        System.out.printf("Treated patients: %d.%n", countTreatedPatients);
        System.out.printf("Untreated patients: %d.", countUntreatedPatients);
    }
}
