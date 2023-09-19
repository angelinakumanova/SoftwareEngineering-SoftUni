package whileLoopsExercises;

import java.util.Scanner;

public class Cake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = Integer.parseInt(scanner.nextLine());
        int y = Integer.parseInt(scanner.nextLine());
        int pieces = x * y;
        String input = scanner.nextLine();
        while (!"STOP".equals(input) && pieces > 0) {
            int takenPieces = Integer.parseInt(input);
            pieces -= takenPieces;
            if (pieces < 0) {
                break;
            }
            input = scanner.nextLine();
        }
        if (pieces < 0) {
            System.out.printf("No more cake left! You need %d pieces more.", Math.abs(pieces));
        } else if (pieces > 0){
            System.out.printf("%d pieces are left.", pieces);
        }

    }
}
