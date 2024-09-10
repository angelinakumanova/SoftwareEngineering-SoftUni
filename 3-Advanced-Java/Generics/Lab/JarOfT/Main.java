package Generics.Lab.JarOfT;

public class Main {
    public static void main(String[] args) {
        Jar<Integer> nums = new Jar<>();

        nums.add(3);
        nums.add(2);
        nums.add(1);

        System.out.println(nums.remove());

    }
}
