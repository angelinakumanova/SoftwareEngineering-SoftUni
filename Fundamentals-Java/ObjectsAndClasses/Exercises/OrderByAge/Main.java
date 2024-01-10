package ObjectsAndClasses.Exercises.OrderByAge;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Person> people = new ArrayList<>();

        while (!input.equals("End")) {
            String name = input.split(" ")[0];
            String ID = input.split(" ")[1];
            int age = Integer.parseInt(input.split(" ")[2]);
            Person person = new Person(name, ID, age);
            people.add(person);

            input = scanner.nextLine();
        }

        Collections.sort(people, Comparator.comparingInt(Person::getAge));
        for (Person person : people) {
            System.out.printf("%s with ID: %s is %d years old.%n",
                    person.getName(),
                    person.getID(),
                    person.getAge());
        }
    }
}
