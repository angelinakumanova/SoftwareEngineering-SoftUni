package TextProcessing.MoreExercises;

import java.util.Scanner;

public class MorseCodeTranslator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] morseCode = scanner.nextLine().split(" ");
        StringBuilder message = new StringBuilder();
        for (int i = 0; i < morseCode.length; i++) {
            message.append(returnEnglishLetter(morseCode[i]));
        }

        System.out.println(message);
    }

    public static String returnEnglishLetter (String morse) {
        switch (morse) {
            case ".-":
                return  "A";
            case "-...":
                return "B";
            case "-.-.":
                return "C";
            case "-..":
                return "D";
            case ".":
                return "E";
            case "..-.":
                return "F";
            case "--.":
                return "G";
            case "....":
                return "H";
            case "..":
                return "I";
            case ".---":
                return "J";
            case "-.-":
                return "K";
            case ".-..":
                return "L";
            case "--":
                return "M";
            case "-.":
                return "N";
            case "---":
                return "O";
            case ".--.":
                return "P";
            case "--.-":
                return "Q";
            case ".-.":
                return "R";
            case "...":
                return "S";
            case "-":
                return "T";
            case "..-":
                return "U";
            case "...-":
                return "V";
            case ".--":
                return "W";
            case "-..-":
                return "X";
            case "-.--":
                return "Y";
            case "--..":
                return "Z";
            case "|":
                return " ";
        }
        return null;
    }
}
