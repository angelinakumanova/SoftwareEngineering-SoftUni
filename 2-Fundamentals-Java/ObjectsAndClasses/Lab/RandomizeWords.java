package ObjectsAndClasses.Lab;

import java.util.*;
import java.util.stream.Collectors;

public class RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> words = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        List<String> modifiedList = new ArrayList<>();

        int length = words.size();
        for (int i = 0; i < length; i++) {
            Random random = new Random();
            int index = random.nextInt(words.size());
            modifiedList.add(words.get(index));
            words.remove(index);
        }

        for (String word : modifiedList) {
            System.out.println(word);
        }

    }
}
