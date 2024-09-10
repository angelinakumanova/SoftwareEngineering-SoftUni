package ObjectsAndClasses.Exercises.OpinionPoll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String personInfo = scanner.nextLine();
            String name = personInfo.split(" ")[0];
            int age = Integer.parseInt(personInfo.split(" ")[1]);

            if (age > 30) {
                people.add(new Person(name, age));
            }
        }

        for (Person person : people) {
            System.out.printf("%s - %d%n", person.getName(), person.getAge());
        }
    }
}
