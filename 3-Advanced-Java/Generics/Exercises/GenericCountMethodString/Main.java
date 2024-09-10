package Generics.Exercises.GenericCountMethodString;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Box<String>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            list.add(new Box<>(input));
        }

        System.out.println(getCount(list, new Box<String>(scanner.nextLine())));
    }

    static <E extends Comparable<E>> int getCount(List<E> list, E element) {
        int count = 0;
        for (E el : list) {
            int compare = el.compareTo(element);
            if (compare > 0) {
                count++;
            }
        }

        return count;
    }
}
