package NestedLoopsExercise;

import java.util.Scanner;

public class SumPrimeNonPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int primeSum = 0;
        int nonPrimeSum = 0;



        String input = scanner.nextLine();
        while (!"stop".equals(input)) {
            int number = Integer.parseInt(input);
            boolean isNonPrimeNumber = false;
            if (number < 0) {
                System.out.println("Number is negative.");
                input = scanner.nextLine();
                continue;
            }
            for (int i = 2; i <= number / 2; i++) {
                if (number % i == 0) {
                    isNonPrimeNumber = true;
                    break;
                }
            }

            if (isNonPrimeNumber) {
                nonPrimeSum += number;
            } else {
                primeSum += number;
            }


            input = scanner.nextLine();

            }

        System.out.printf("Sum of all prime numbers is: %d%n", primeSum);
        System.out.printf("Sum of all non prime numbers is: %d", nonPrimeSum);
        }
    }

