package WorkingWithAbstraction.Lab.StudentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem();
        while (true) {
            String[] input = scanner.nextLine().split(" ");
            String command = input[0];
            if ("Exit".equals(command)){
                break;
            }
            studentSystem.parseCommand(input);
        }
    }
}
