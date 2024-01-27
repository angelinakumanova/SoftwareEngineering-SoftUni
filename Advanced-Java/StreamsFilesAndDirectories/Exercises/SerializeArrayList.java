package StreamsFilesAndDirectories.Exercises;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SerializeArrayList {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String path = "C:\\Users\\Angie\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesAndDirectories\\Exercises\\list.ser";

        List<Double> doubles = new ArrayList<>();
        Collections.addAll(doubles, 1.2,1.3,5.4,4.2,5.5);

        FileOutputStream fileOutputStream = new FileOutputStream(path);
        ObjectOutputStream obs = new ObjectOutputStream(fileOutputStream);
        obs.writeObject(doubles);

        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream bis = new ObjectInputStream(fis);
        Object o = bis.readObject();
    }
}
