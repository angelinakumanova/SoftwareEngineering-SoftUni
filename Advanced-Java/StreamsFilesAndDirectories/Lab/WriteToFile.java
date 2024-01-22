package StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

public class WriteToFile {
    public static void main(String[] args) {
        String inputPath = "C:\\Users\\Angie\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "C:\\Users\\Angie\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\02.WriteToFileOutput.txt";


        try (FileInputStream fileInputStream = new FileInputStream(inputPath)) {
            FileOutputStream fileOutputStream = new FileOutputStream(outputPath);
            int oneByte = fileInputStream.read();
            Set<Character> symbols = Set.of(',','.','!','?');

            while (oneByte != -1) {
                if (!symbols.contains((char)oneByte)) {
                    fileOutputStream.write(oneByte);
                }

                oneByte = fileInputStream.read();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
