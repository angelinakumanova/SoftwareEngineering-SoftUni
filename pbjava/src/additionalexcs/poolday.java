package additionalexcs;

import java.util.Scanner;

public class poolday {
    public static void main(String[] args) {
        //Преподавателският екип на СофтУни организира работен ден на басейн по случай настъпването на лятото.
        // Вашата задача е да напишете програма, която да изчислява каква сума трябва да се заплати. За всеки
        // един човек от екипа трябва да се заплати такса вход. Трябва да имате предвид, че един чадър стига за
        // двама души. Знае се, че само 75% от екипа искат шезлонги. При изчислението на броя на чадърите и шезлонгите,
        // техният брой да се закръгли до по-голямото цяло число.
        //Вход
        //От конзолата се четат 4 числа:
        //1.Първи ред – брой на хората. Цяло число в интервала [1…100]
        //2.Втори ред – такса вход. Реално число в интервала [0.00…50.00]
        //3.Трети ред – цена един за шезлонг. Реално число в интервала [0.00…50.00]
        //4.Четвърти ред – цена за един чадър. Реално число в интервала [0.00...50.00]
        //Изход
        //"{сумата за покриване на разходите} lv."
        //Резултатът да се форматира до втората цифра след десетичния знак.

        Scanner scanner = new Scanner(System.in);
        int horabr = Integer.parseInt(scanner.nextLine());
        double entrytax = Double.parseDouble(scanner.nextLine());
        double pshezlong = Double.parseDouble(scanner.nextLine());
        double pumbrella = Double.parseDouble(scanner.nextLine());

        double totaltax = horabr * entrytax;
        double obshtochaduri = Math.ceil(horabr / 2.0);
        double cenachaduri = obshtochaduri * pumbrella;
        double cqloshezlongi = Math.ceil(horabr * 75 / 100.0);
        double cenashezlongi = cqloshezlongi * pshezlong;

        double suma = totaltax + cenachaduri + cenashezlongi;
        System.out.printf("%.2f lv. ", suma);
    }
}
