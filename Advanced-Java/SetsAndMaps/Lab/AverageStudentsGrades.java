package SetsAndMaps.Lab;

import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Double>> students = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] studentInfo = scanner.nextLine().split("\\s+");
            String student = studentInfo[0];
            double grade = Double.parseDouble(studentInfo[1]);

            if (!students.containsKey(student)) {
                students.put(student, new ArrayList<>());
                students.get(student).add(grade);
            } else {
                students.get(student).add(grade);
            }
        }

        for (Map.Entry<String, List<Double>> student : students.entrySet()) {
            System.out.printf("%s -> ", student.getKey());

            double sum = 0;
            for (int i = 0; i < student.getValue().size(); i++) {
                System.out.printf("%.2f ", student.getValue().get(i));
                sum += student.getValue().get(i);
            }
            System.out.printf("(avg: %.2f)%n", sum / student.getValue().size());
        }
    }
}
