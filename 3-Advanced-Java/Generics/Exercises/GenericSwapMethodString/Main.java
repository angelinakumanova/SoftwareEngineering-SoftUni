package Generics.Exercises.GenericSwapMethodString;

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
        String indices = scanner.nextLine();
        int firstIdx = Integer.parseInt(indices.split("\\s+")[0]);
        int secondIdx = Integer.parseInt(indices.split("\\s+")[1]);

        List<Box<String>> swappedList = swap(list, firstIdx, secondIdx);
        swappedList.forEach(System.out::println);
    }

    public static <E> List<E> swap(List<E> list, int firstIdx, int secondIdx) {
        E firstIdxElement = list.get(firstIdx);
        list.set(firstIdx, list.get(secondIdx));
        list.set(secondIdx, firstIdxElement);

        return list;
    }


}
