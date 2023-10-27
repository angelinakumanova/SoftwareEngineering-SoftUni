package ObjectsAndClasses.Lab.Students_2_0;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Student> students = new ArrayList<>();


        while (!input.equals("end")) {
            String[] split = input.split(" ");

            String firstName = split[0];
            String lastName = split[1];
            int age = Integer.parseInt(split[2]);
            String hometown = split[3];


            Student student = findStudent(students, firstName, lastName);
            if (student != null) {
                student.setAge(age);
                student.setHometown(hometown);
            } else {
                students.add(new Student(firstName, lastName, age, hometown));
            }

            input = scanner.nextLine();
        }

        String filterCity = scanner.nextLine();

        for (Student student : students) {
            if(filterCity.equals(student.getHometown())) {
                System.out.printf("%s %s is %d years old%n",
                        student.getFirstName(),
                        student.getLastName(),
                        student.getAge());
            }
        }
    }

    public static Student findStudent (List<Student> students, String firstName, String lastName) {
        for (Student student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return student;
            }
        }
        return null;
    }
}
