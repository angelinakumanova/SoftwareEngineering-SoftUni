package SetsAndMaps.Lab;

import java.text.DecimalFormat;
import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Double> students = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .toArray();
            double sum = 0;

            for (int pos = 0; pos < grades.length; pos++) {
                sum += grades[pos];
            }
            sum /= grades.length;

            if (!students.containsKey(name)) {
                students.put(name, sum);
            }
        }

        for (Map.Entry<String, Double> student : students.entrySet()) {
            System.out.println(student.getKey() + " is graduated with " + student.getValue());
        }
    }
}
