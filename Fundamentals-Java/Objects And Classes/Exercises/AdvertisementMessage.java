package ObjectsAndClasses.Exercises;

import java.util.Random;
import java.util.Scanner;

public class AdvertisementMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfMessages = Integer.parseInt(scanner.nextLine());

        String[] phrases = {
                "Excellent product.",
                "Such a great product.",
                "I always use that product.",
                "Best product of its category.",
                "Exceptional product.",
                "I can’t live without this product."
        };
        String[] events = {
                "Now I feel good.",
                "I have succeeded with this product.",
                "Makes miracles. I am happy of the results!",
                "I cannot believe but now I feel awesome.",
                "Try it yourself, I am very satisfied.",
                "I feel great!"
        };
        String[] authors = {
                "Diana",
                "Petya",
                "Stella",
                "Elena",
                "Katya",
                "Iva",
                "Annie",
                "Eva"
        };
        String[] cities = {
                "Burgas",
                "Sofia",
                "Plovdiv",
                "Varna",
                "Ruse"
        };

        for (int i = 0; i < numberOfMessages; i++) {
            Random rdmPhrase = new Random();
            Random rdmEvent = new Random();
            Random rdmAuthor = new Random();
            Random rdmCity = new Random();
            System.out.printf("%s %s %s - %s%n", phrases[rdmPhrase.nextInt(phrases.length)],
                    events[rdmEvent.nextInt(events.length)],
                    authors[rdmAuthor.nextInt(authors.length)],
                    cities[rdmCity.nextInt(cities.length)]);
        }
    }
}
