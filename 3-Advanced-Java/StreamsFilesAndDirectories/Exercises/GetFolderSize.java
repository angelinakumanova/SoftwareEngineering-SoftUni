package StreamsFilesAndDirectories.Exercises;

import java.io.File;

public class GetFolderSize {
    public static void main(String[] args) {
        String path = "C:\\Users\\Angie\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";

        File directory = new File(path);

        long sum = 0;
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            for (File file : files) {
                sum += file.length();
            }
        }

        System.out.println("Folder size: " + sum);
    }
}
