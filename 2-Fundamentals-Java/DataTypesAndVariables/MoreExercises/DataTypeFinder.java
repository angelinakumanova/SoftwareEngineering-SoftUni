package DataTypesAndVariables.Exercises.MoreExercises;

import java.util.Scanner;

public class DataTypeFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String type = "";
                if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
                    type = "boolean";
                    System.out.printf("%s is %s type%n", input, type);
                } else if (input.length() == 1) {
                    char symbol = input.charAt(0);
                    if (symbol < 47 || symbol > 58) {
                        type = "character";
                        System.out.printf("%s is %s type%n", input, type);

                    } else {
                        type = "integer";
                        System.out.printf("%s is %s type%n", input, type);
                    }
                } else {

                    boolean isString = false;
                    boolean isFloating = false;

                    for (int i = 0; i < input.length() ; i++) {
                        char symbol = input.charAt(i);
                        if (symbol < 45 || symbol > 57){
                            isString = true;
                        }
                        if (symbol == 46) {
                                isFloating = true;
                            }
                        }
                    if (isString) {
                        type = "string";
                        System.out.printf("%s is %s type%n", input, type);
                    } else {
                        if (isFloating) {
                            type = "floating point";
                            System.out.printf("%s is %s type%n", input, type);
                        } else {
                            type = "integer";
                            System.out.printf("%s is %s type%n", input, type);
                        }
                    }
                }

                input = scanner.nextLine();
        }
    }
}
