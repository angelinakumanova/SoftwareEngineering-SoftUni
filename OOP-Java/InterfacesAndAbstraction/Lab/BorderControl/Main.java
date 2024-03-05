package InterfacesAndAbstraction.Lab.BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Identifiable> citizensAndRobots = new ArrayList<>();
        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            if (tokens.length == 3) {
                Citizen citizen = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                citizensAndRobots.add(citizen);
            } else {
                Robot robot = new Robot(tokens[0], tokens[1]);
                citizensAndRobots.add(robot);
            }
            input = scanner.nextLine();
        }

        String fakeIdDigits = scanner.nextLine();
        citizensAndRobots.stream().filter(e -> e.getId().endsWith(fakeIdDigits))
                .forEach(e -> System.out.println(e.getId()));
    }
}
