import java.util.Scanner;

public class RecursiveFibonacci_IISolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        if (n == 1 || n == 2) {
            System.out.println("1");
            return;
        } else if (n == 0) {
            System.out.println("0");
            return;
        }

        int[] initialArray = new int[n];
        initialArray[0] = 1;
        initialArray[1] = 1;
        for (int i = 2; i < n; i++) {
           initialArray[i] = initialArray[i - 2] + initialArray[i - 1];
        }
        System.out.println(initialArray[n - 1]);
    }
}
