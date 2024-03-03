package Inheritance.Lab.RandomArrayList;

public class Main {
    public static void main(String[] args) {
        RandomArrayList<String> list = new RandomArrayList<>();

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

        System.out.println(list.getRandomElement());
    }
}
