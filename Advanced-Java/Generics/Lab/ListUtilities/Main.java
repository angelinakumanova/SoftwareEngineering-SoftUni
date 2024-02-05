package Generics.Lab.ListUtilities;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(4);
        list.add(7);

        int min = ListUtils.getMin(list);
        int max = ListUtils.getMax(list);

    }
}
