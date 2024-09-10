package AssociativeArrays.Exercises;

import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, List<String>> companies = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String company = input.split(" -> ")[0];
            String employeeID = input.split(" -> ")[1];

            if (!companies.containsKey(company)) {
                companies.put(company, new ArrayList<>());
            }

            if (!companies.get(company).contains(employeeID)) {
                companies.get(company).add(employeeID);
            }

            input = scanner.nextLine();
        }

        for(Map.Entry<String, List<String>> entry : companies.entrySet()) {
            System.out.println(entry.getKey());
            System.out.printf("-- %s%n", String.join("\n-- ", entry.getValue()));
        }
    }
}
