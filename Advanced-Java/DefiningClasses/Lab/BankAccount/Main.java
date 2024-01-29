package DefiningClasses.Lab.BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, BankAccount> bankAccounts = new HashMap<>();
        String input = scanner.nextLine();

        while (!"End".equals(input)) {
            String[] data = input.split("\\s+");
            String command = data[0];
            switch (command) {
                case "Create":
                    BankAccount bankAccount = new BankAccount();
                    bankAccounts.putIfAbsent(bankAccount.getId(), bankAccount);
                    System.out.printf("Account ID%d created%n", bankAccount.getId());
                    break;
                case "Deposit":
                    int id = Integer.parseInt(data[1]);
                    double amount = Double.parseDouble(data[2]);
                    if (bankAccounts.containsKey(id)) {
                        bankAccounts.get(id).deposit(amount);
                        System.out.printf("Deposited %.0f to ID%d%n", amount, id);
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
                case "SetInterest":
                    double interestRate = Double.parseDouble(data[1]);
                    BankAccount.setInterestRate(interestRate);
                    break;
                case "GetInterest":
                    int idB = Integer.parseInt(data[1]);
                    int years = Integer.parseInt(data[2]);
                    if (bankAccounts.containsKey(idB)) {
                        System.out.printf("%.2f%n", bankAccounts.get(idB).getInterest(years));
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
            }


            input = scanner.nextLine();
        }
    }
}
