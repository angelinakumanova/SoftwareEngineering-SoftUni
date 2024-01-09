package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> previousURLs = new ArrayDeque<>();
        ArrayDeque<String> nextURLs = new ArrayDeque<>();

        String input = scanner.nextLine();

        while (!"Home".equals(input)) {

            if ("forward".equals(input)) {
                if (nextURLs.isEmpty()) {
                    System.out.println("no next URLs");
                } else {
                    previousURLs.push(nextURLs.poll());
                    System.out.println(previousURLs.peek());
                }
            } else if ("back".equals(input)) {
                if (previousURLs.size() <= 1) {
                    System.out.println("no previous URLs");
                } else {
                    nextURLs.addFirst(previousURLs.pop());
                    System.out.println(previousURLs.peek());
                }
            } else {
                previousURLs.push(input);
                nextURLs.clear();
                System.out.println(input);
            }

            input = scanner.nextLine();
        }
    }
}
