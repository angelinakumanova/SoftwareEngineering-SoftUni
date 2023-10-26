package ObjectsAndClasses.Lab.Songs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfSongs = Integer.parseInt(scanner.nextLine());
        List<Song> songs = new ArrayList<>();

        for (int i = 0; i < numberOfSongs; i++) {
            String[] songArgs = scanner.nextLine().split("_");
            String type = songArgs[0];
            String name = songArgs[1];
            String time = songArgs[2];

            Song song = new Song(type, name, time);
            songs.add(song);
        }

        String filter = scanner.nextLine();

        for (Song song : songs) {
            if (filter.equals(song.getTypeList())) {
                System.out.println(song.getName());
            } else if (filter.equals("all")) {
                System.out.println(song.getName());
            }
        }

    }
}
