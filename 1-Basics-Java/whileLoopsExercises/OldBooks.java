package whileLoopsExercises;

import java.util.Scanner;

public class OldBooks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String book = scanner.nextLine();
        int count = 0;
        String searchingThroughBooks = scanner.nextLine();

        while (!searchingThroughBooks.equals(book)) {
            if (searchingThroughBooks.equals("No More Books")) {
                System.out.println("The book you search is not here!");
                System.out.printf("You checked %d books.", count);
                break;
            }
            searchingThroughBooks = scanner.nextLine();
            count++;
        }
        if (searchingThroughBooks.equals(book)) {
            System.out.printf("You checked %d books and found it.", count);
        }
    }
}
