package Lists.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> strings = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("3:1")) {
            String[] commandParts = command.split(" ");
            if (commandParts[0].equals("merge")) {
                int startIdx = Integer.parseInt(commandParts[1]);
                int endIdx = Integer.parseInt(commandParts[2]);

                if (startIdx < 0) {
                    startIdx = 0;
                }
                if (startIdx >= strings.size()) {
                    startIdx = strings.size() - 1;
                }
                if (endIdx >= strings.size()) {
                    endIdx = strings.size() - 1;
                }

                StringBuilder newStr = new StringBuilder();
                for (int i = startIdx; i <= endIdx; i++) {
                        newStr.append(strings.get(i));
                }
                strings.add(startIdx, newStr.toString());
                strings.subList(startIdx + 1, endIdx + 2).clear();

            } else if (commandParts[0].equals("divide")) {
                int idx = Integer.parseInt(commandParts[1]);
                int partitions = Integer.parseInt(commandParts[2]);

                String stringToDivide = strings.get(idx);
                strings.remove(idx);

                int countPerPart = stringToDivide.length() / partitions;

                int beginIndex = 0;
                for (int part = 1; part < partitions; part++) {
                    String textPerPart = stringToDivide.substring(beginIndex, beginIndex + countPerPart);
                    strings.add(idx, textPerPart);
                    idx++;
                    beginIndex += countPerPart;
                }

                String textLastParts = stringToDivide.substring(beginIndex, stringToDivide.length());
                strings.add(idx, textLastParts);

            }

            
            command = scanner.nextLine();
        }

        System.out.println(String.join(" ", strings));
    }
}
