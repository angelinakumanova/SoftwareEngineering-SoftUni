package Exams.Exam_13Dec23;

import java.util.*;

public class WormsAndHoles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Stack<Integer> wormsStack = new Stack<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(wormsStack::push);
        
        Deque<Integer> holesQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(holesQueue::offer);

        int countMatches = 0;
        int wormSize = wormsStack.size();
        while (!wormsStack.isEmpty() && !holesQueue.isEmpty()) {

            int currentWorm = wormsStack.peek();
            int currentHole = holesQueue.peek();

            if (currentWorm == currentHole) {
                wormsStack.pop();
                holesQueue.poll();
                countMatches++;
            } else {
                wormsStack.push(wormsStack.pop() - 3);
                if (wormsStack.peek() <= 0) {
                    wormsStack.pop();
                }
                holesQueue.poll();
            }


        }

        System.out.println(countMatches == 0 ? "There are no matches." : "Matches: " + countMatches);


        if (wormsStack.isEmpty() && wormSize == countMatches) {
            System.out.println("Every worm found a suitable hole!");
        } else if (wormsStack.isEmpty()) {
            System.out.println("Worms left: none");
        } else {
            System.out.println("Worms left: " +
                    String.join(", ", wormsStack.toString().replaceAll("[\\[\\]]", "")));
        }

        if (holesQueue.isEmpty()) {
            System.out.println("Holes left: none");
        } else {
            System.out.println("Holes left: " +
                    String.join(", ", holesQueue.toString().replaceAll("[\\[\\]]", "")));
        }

    }
}
