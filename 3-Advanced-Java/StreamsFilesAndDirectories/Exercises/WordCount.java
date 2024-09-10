package StreamsFilesAndDirectories.Exercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class WordCount {
    public static void main(String[] args) throws IOException {
        String pathWords = "C:\\Users\\Angie\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        String pathText = "C:\\Users\\Angie\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
        
        
        Map<String, Integer> wordsOccurrence = new LinkedHashMap<>();
        List<String> words = List.of(Files.readString(Paths.get(pathWords)).split(" "));
        for (int i = 0; i < words.size(); i++) {
            wordsOccurrence.putIfAbsent(words.get(i), 0);
        }
        String[] text = Files.readString(Paths.get(pathText)).split("\\s+");

        for (int word = 0; word < text.length; word++) {
            if (wordsOccurrence.containsKey(text[word])) {
                wordsOccurrence.put(text[word], wordsOccurrence.get(text[word]) + 1);
            }
        }

        wordsOccurrence.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).forEach(e -> {
            System.out.println(e.getKey() + " - " + e.getValue());
        });
    }
}
