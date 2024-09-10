package StreamsFilesAndDirectories.Exercises;

import java.io.*;

public class AllCapitals {
    public static void main(String[] args) {
        String inputPath = "C:\\Users\\Angie\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outputPath = "C:\\Users\\Angie\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";


        try (BufferedReader bf = new BufferedReader(new FileReader(inputPath));
             PrintWriter pw = new PrintWriter(outputPath);) {
            String line = bf.readLine();

            while (line != null) {
               pw.println(line.toUpperCase());

                line = bf.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
