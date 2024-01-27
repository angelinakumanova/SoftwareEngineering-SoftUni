package StreamsFilesAndDirectories.Exercises;

import java.io.*;

public class SerializeCustomObject {
    public static void main(String[] args) {

        String path = "C:\\Users\\Angie\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesAndDirectories\\Exercises\\course.ser";
        Course course = new Course("Java Advanced", 100);

        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream bos = new ObjectOutputStream(fos);
             FileInputStream fis = new FileInputStream(path);
             ObjectInputStream bis = new ObjectInputStream(fis)) {
            // serialize course
            bos.writeObject(course);

            // deserialize course
            Course deserializedCourse = (Course) bis.readObject();

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
