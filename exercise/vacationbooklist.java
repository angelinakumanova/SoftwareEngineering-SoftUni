package exercise;

import java.util.Scanner;

public class vacationbooklist {
    public static void main(String[] args) {
        //Брой страници в текущата книга – цяло число в интервала [1…1000]
        //
        //2. Страници, които прочита за 1 час – цяло число в интервала [1…1000]
        //
        //3. Броят на дните, за които трябва да прочете книгата – цяло число в интервала [1…1000]
        Scanner scanner = new Scanner(System.in);
        int pages = Integer.parseInt(scanner.nextLine());
        int pagesperhour = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());

        int hours = pages / pagesperhour;
        int result = hours / days;

        System.out.println(result);


    }
}
