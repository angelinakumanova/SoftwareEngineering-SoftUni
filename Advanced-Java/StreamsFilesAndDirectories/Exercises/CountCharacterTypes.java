package StreamsFilesAndDirectories.Exercises;

import java.io.*;
import java.util.Set;

public class CountCharacterTypes {
    public static void main(String[] args) {
        String inputPath = "C:\\Users\\Angie\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outputPath = "C:\\Users\\Angie\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";

        Set<Character> vowels = Set.of('a','e','i','o','u');
        Set<Character> punctuationMarks = Set.of('!',',','.','?');

        try (BufferedReader bf = new BufferedReader(new FileReader(inputPath))) {

            String line = bf.readLine();
            int countVowels = 0;
            int countOtherSymbols = 0;
            int countMarks = 0;
            while (line != null) {
               for (char c : line.toCharArray()) {
                   if (vowels.contains(c)) {
                       countVowels++;
                   } else if (punctuationMarks.contains(c)) {
                       countMarks++;
                   } else if (c != ' ') {
                       countOtherSymbols++;
                   }
               }
                   line = bf.readLine();
            }
            System.out.printf("Vowels: %d%n", countVowels);
            System.out.printf("Other symbols: %d%n", countOtherSymbols);
            System.out.printf("Punctuation: %d%n", countMarks);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
