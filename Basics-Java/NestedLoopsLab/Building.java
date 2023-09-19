package NestedLoopsLab;

import java.util.Scanner;

public class Building {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int floors = Integer.parseInt(scanner.nextLine());
        int rooms = Integer.parseInt(scanner.nextLine());
        char floor;

        for (int i = floors; i >= 1 ; i--) {
            if (i == floors) {
            floor = 'L';
        } else if (i % 2 == 0) {
            floor = 'O';
        } else {
            floor = 'A';
        }
            for (int j = 0; j < rooms; j++) {
                System.out.printf("%c%d%d ", floor, i, j);
            }
            System.out.println();
        }
    }
}
