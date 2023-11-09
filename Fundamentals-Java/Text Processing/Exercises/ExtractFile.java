package TextProcessing.Exercises;

import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] path = scanner.nextLine().split("[\\\\ .]");
        System.out.println("File name: " + path[path.length - 2]);
        System.out.println("File extension: " + path[path.length - 1]);
    }
}
