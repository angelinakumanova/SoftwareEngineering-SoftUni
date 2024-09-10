package Generics.Exercises.CustomList;

public class Sorter {

    public static <T extends Comparable<T>> void sort(CustomList<T> list) {
        for (int i = 0; i < list.size(); i++) {
            T currElement = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                if (currElement.compareTo(list.get(j)) > 0) {
                    list.swap(i, j);
                }
            }
        }
    }
}
