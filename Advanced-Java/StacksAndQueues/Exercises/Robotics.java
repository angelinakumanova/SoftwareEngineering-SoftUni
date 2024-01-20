package StacksAndQueues.Exercises;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Robotics {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        String[] robotsInput = scanner.nextLine().split(";");

        String[] robots = new String[robotsInput.length];
        int[] processTime = new int[robotsInput.length];
        int[] workingTime = new int[robotsInput.length];

        for (int i = 0; i < robotsInput.length; i++) {
            robots[i] = robotsInput[i].split("-")[0];
            processTime[i] = Integer.parseInt(robotsInput[i].split("-")[1]);
        }

        String startingTime = scanner.nextLine();

        Deque<String> productsQueue = new ArrayDeque<>();
        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            productsQueue.offer(input);

            input = scanner.nextLine();
        }

        int timeInSeconds = convertTimeIntoSeconds(startingTime);

        while (!productsQueue.isEmpty()) {
            timeInSeconds += 1;

            String product = productsQueue.poll();

            boolean isTaken = false;
            for (int i = 0; i < robots.length; i++) {
                if (workingTime[i] == 0 && !isTaken) {
                    workingTime[i] = processTime[i];
                    isTaken = true;
                    System.out.println(printDataAboutRobotAndProduct(robots[i], product, timeInSeconds, workingTime[i]));
                }

                if (workingTime[i] > 0) {
                    workingTime[i]--;
                }
            }

            if (!isTaken) {
                productsQueue.offer(product);
            }
        }
    }

    private static int convertTimeIntoSeconds (String time) {
        String[] tokens = time.split(":");
        int hours = Integer.parseInt(tokens[0]);
        int minutes = Integer.parseInt(tokens[1]);
        int seconds = Integer.parseInt(tokens[2]);

        return hours * 3600 + minutes * 60 + seconds;
    }

    private static String printDataAboutRobotAndProduct (String robot, String product, int seconds, int workingTime) {
        int hrs = (seconds / 3600) % 24;
        int mins = (seconds / 60) % 60;
        int secs = seconds % 60;

        String formattedTime = String.format(" [%02d:%02d:%02d]", hrs, mins, secs);
        return robot + " - " + product + formattedTime;
    }
}
