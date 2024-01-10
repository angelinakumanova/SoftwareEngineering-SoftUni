package ExamProblems.FinalExams;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IVFinalExam_FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern validPattern = Pattern.compile("@#+[A-Z][A-Za-z0-9]{4,}[A-Z]@#+");


        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher validMatcher = validPattern.matcher(input);
            if (validMatcher.find()) {
                Pattern digitsPattern = Pattern.compile("[0-9]");
                Matcher digitsMatcher = digitsPattern.matcher(input);

                if (digitsMatcher.find()) {
                    digitsMatcher = digitsPattern.matcher(input);
                    String numbers = "";
                    while (digitsMatcher.find()) {
                        numbers += digitsMatcher.group();
                    }

                        System.out.println("Product group: " + numbers);
                } else {
                    System.out.println("Product group: 00");
                }
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}
