import java.util.Arrays;
import java.util.Scanner;

public class CondenseArrayToNumber_IISolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int length = numbers.length - 1; // 4
        for (int i = 0; i < length; i++) { // 4
            int[] temp = new int[numbers.length - 1]; // 3
            for (int j = 0; j < temp.length; j++) {
                temp[j] = numbers[j] + numbers[j + 1];
            }
            numbers = temp;
        }
        System.out.println(numbers[0]);

    }
}
