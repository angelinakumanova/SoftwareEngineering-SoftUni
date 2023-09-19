package lab.firststeps;

import java.util.Scanner;

public class ProjectsCreation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String architectName = scanner.nextLine();
        int projects = Integer.parseInt(scanner.nextLine());

        int timeneeded = projects * 3;

        String result = "The architect %s will need %d hours to complete %d project/s.";

        System.out.printf(result,architectName, timeneeded, projects);
    }
}
