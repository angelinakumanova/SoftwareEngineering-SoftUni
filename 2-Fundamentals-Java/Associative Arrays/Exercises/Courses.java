package AssociativeArrays.Exercises;

import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, List<String>> courses = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String courseName = input.split(" : ")[0];
            String student = input.split(" : ")[1];
            if (!courses.containsKey(courseName)) {
                courses.put(courseName, new ArrayList<>());
            }
            courses.get(courseName).add(student);

            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : courses.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue().size());
            System.out.printf("-- %s%n", String.join("\n-- ", entry.getValue()));
        }
    }
}
