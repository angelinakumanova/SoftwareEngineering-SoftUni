package ChecksLab;

import java.util.Scanner;

public class AreaCalc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String shape = scanner.nextLine();
        //Ако фигурата е квадрат (square): на следващия ред се чете едно дробно число - дължина на страната му
        //Ако фигурата е правоъгълник (rectangle): на следващите два реда четат две дробни числа - дължините на страните му
        //Ако фигурата е кръг (circle): на следващия ред чете едно дробно число - радиусът на кръга
        //Ако фигурата е триъгълник (triangle): на следващите два реда четат две дробни числа - дължината на страната му
        // и дължината на височината към нея
        //Резултатът да се закръгли до 3 цифри след десетичната запетая.
        double area;

        if (shape.equals("square")) {
            double sideA = Double.parseDouble(scanner.nextLine());
            area = Math.pow(sideA, 2);
        } else if (shape.equals("rectangle")) {
            double sideA = Double.parseDouble(scanner.nextLine());
            double sideB = Double.parseDouble(scanner.nextLine());
            area = sideA * sideB;
        } else if (shape.equals("circle")) {
            double radius = Double.parseDouble(scanner.nextLine());
            area = Math.PI * Math.pow(radius, 2);
        } else {
            double sideA = Double.parseDouble(scanner.nextLine());
            double sideAh = Double.parseDouble(scanner.nextLine());
            area = sideA * sideAh / 2;
        }

        System.out.printf("%.3f", area);

        }
    }
