package Generics.Exercises.CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        CustomList<String> list = new CustomList<>();
        while (!"END".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Add":
                    String elementToAdd = tokens[1];
                    list.add(elementToAdd);
                    break;
                case "Remove":
                    int index = Integer.parseInt(tokens[1]);
                    list.remove(index);
                    break;
                case "Contains":
                    String element = tokens[1];
                    System.out.println(list.contains(element));
                    break;
                case "Sort":
                    Sorter.sort(list);
                    break;
                case "Swap":
                    int firstIdx = Integer.parseInt(tokens[1]);
                    int secondIdx = Integer.parseInt(tokens[2]);
                    list.swap(firstIdx, secondIdx);
                    break;
                case "Greater":
                    String el = tokens[1];
                    System.out.println(list.countGreaterThan(el));
                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Print":
                    list.print();
                    break;
            }

            input = scanner.nextLine();
        }
    }
}
