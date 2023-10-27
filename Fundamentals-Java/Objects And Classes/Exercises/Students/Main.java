package ObjectsAndClasses.Exercises.Students;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String studentInfo = scanner.nextLine();
            String firstName = studentInfo.split(" ")[0];
            String lastName = studentInfo.split(" ")[1];
            Double grade = Double.parseDouble(studentInfo.split(" ")[2]);

            Student student = new Student(firstName, lastName, grade);
            students.add(student);
        }

        Collections.sort(students, Comparator.comparingDouble(Student::getGrade).reversed());

        for (Student student : students) {
            System.out.printf("%s %s: %.2f%n",
                    student.getFirstName(),
                    student.getLastName(),
                    student.getGrade());
        }
    }
}
