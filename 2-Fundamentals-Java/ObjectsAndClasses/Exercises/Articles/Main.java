package ObjectsAndClasses.Exercises.Articles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String articleData = scanner.nextLine();
        String title = articleData.split(", ")[0];
        String content = articleData.split(", ")[1];
        String author = articleData.split(", ")[2];

        int n = Integer.parseInt(scanner.nextLine());

        Article article = new Article(title, content, author);
        for (int i = 0; i < n; i++) {
            String command = scanner.nextLine();
            if (command.contains("Edit")) {
                String newContent = command.split(": ")[1];
                article.editContent(newContent);
            } else if (command.contains("ChangeAuthor")) {
                String newAuthor = command.split(": ")[1];
                article.changeAuthor(newAuthor);
            } else if (command.contains("Rename")) {
                String newTitle = command.split(": ")[1];
                article.rename(newTitle);
            }
        }

        System.out.println(article.toString());
    }
}
