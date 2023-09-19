package ConditionalStatemensexercises2_0;

import java.util.Scanner;

public class OnTimeForTheExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hourexam = Integer.parseInt(scanner.nextLine());
        int minexam = Integer.parseInt(scanner.nextLine());
        int hourarrival = Integer.parseInt(scanner.nextLine());
        int minarrival = Integer.parseInt(scanner.nextLine());

        int timeexam = hourexam * 60 + minexam;
        int timearrival = hourarrival * 60 + minarrival;

        int diff = timeexam - timearrival;

        String time = "";

        if (diff >= 0 && diff <= 30) {
            time = "On time";
        } else if (diff > 30) {
            time = "Early";
        } else {
            time = "Late";
        }
        System.out.println(time);

        String arrivalPeriod = diff < 0 ? "after" : "before";
        diff = Math.abs(diff);

        if (diff < 60) {
            System.out.printf("%d minutes %s the start", diff, arrivalPeriod);
        } else {
            System.out.printf("%d:%02d hours %s the start", diff / 60, diff % 60, arrivalPeriod);
        }

    }
}
