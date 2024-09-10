package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int numberOfOperations = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> stackOperations = new ArrayDeque<>();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < numberOfOperations; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            if (tokens[0].equals("1")) {
                stackOperations.push(text.toString());
                text.append(tokens[1]);

            } else if (tokens[0].equals("2")) {
                int count = Integer.parseInt(tokens[1]);
                stackOperations.push(text.toString());
                text.delete(text.length() - count, text.length());

            } else if (tokens[0].equals("3")) {
                int index = Integer.parseInt(tokens[1]);
                System.out.println(text.toString().charAt(index - 1));

            } else if (tokens[0].equals("4")) {
                text = new StringBuilder(stackOperations.pop());

            }
        }
    }
}
