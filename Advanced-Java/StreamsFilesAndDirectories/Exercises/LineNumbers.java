package StreamsFilesAndDirectories.Exercises;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class LineNumbers {
    public static void main(String[] args) throws IOException {
        String inputPath = "C:\\Users\\Angie\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        String outputPath = "C:\\Users\\Angie\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";

        List<String> lines = Files.readAllLines(Paths.get(inputPath));
        for (int i = 0; i < lines.size(); i++) {
            Files.writeString(Paths.get(outputPath), i + 1 + ". " + lines.get(i) + System.lineSeparator(),
                    StandardOpenOption.APPEND);
        }
    }
}
