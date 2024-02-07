package Exams.Exam_17June23;


import java.util.*;
import java.util.stream.Collectors;

public class TempleOfDoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> tools = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(tools::offer);

        Deque<Integer> substances = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(substances::push);

        List<Integer> challenges = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (tools.size() > 0 && substances.size() > 0) {

            int currentNum = tools.peek() * substances.peek();

            if (challenges.contains(currentNum)) {
                tools.poll();
                substances.pop();
                challenges.remove(getIndex(currentNum, challenges));
            } else {
                tools.addLast(tools.poll() + 1);
                substances.push(substances.pop() - 1);
                if (substances.peek() <= 0) {
                    substances.pop();
                }
            }

        }

        if (!challenges.isEmpty()) {
            System.out.println("Harry is lost in the temple. Oblivion awaits him.");
        } else {
            System.out.println("Harry found an ostracon, which is dated to the 6th century BCE.");
        }

        if (!tools.isEmpty()) System.out.printf("Tools: %s%n", tools.toString()
                .replaceAll("[\\[\\]]", ""));
        if (!substances.isEmpty()) System.out.printf("Substances: %s%n", substances.toString()
                .replaceAll("[\\[\\]]", ""));
        if (!challenges.isEmpty()) System.out.printf("Challenges: %s%n", challenges.toString()
                .replaceAll("[\\[\\]]", ""));

    }


    private static int getIndex(int currentNum, List<Integer> challenges) {
        int index = 0;
        for (int i = 0; i < challenges.size(); i++) {
            if (currentNum == challenges.get(i)) {
                index = i;
                break;
            }
        }

        return index;
    }
}
