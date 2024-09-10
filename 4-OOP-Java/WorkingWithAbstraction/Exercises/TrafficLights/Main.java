package WorkingWithAbstraction.Exercises.TrafficLights;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String[] trafficLights = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < trafficLights.length; j++) {
                String nextLight = TrafficLight.valueOf(trafficLights[j]).getNextLight();
                System.out.print(nextLight + " ");
                trafficLights[j] = nextLight;
            }
            System.out.println();
        }
    }
}
