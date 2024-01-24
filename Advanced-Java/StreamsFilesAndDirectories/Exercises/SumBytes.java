package StreamsFilesAndDirectories.Exercises;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SumBytes {
    public static void main(String[] args) {
        String inputPath = "C:\\Users\\Angie\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try (BufferedReader bf = new BufferedReader(new FileReader(inputPath))) {
            String line = bf.readLine();

            long sum = 0;
            while (line != null) {
                for (char c : line.toCharArray()) {
                    sum += c;
                }
                line = bf.readLine();
            }
            System.out.println(sum);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
