package ExamProblems.MidExams;

import java.util.Scanner;

public class IVMidExam_ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] list = scanner.nextLine().split("!");
        String command = scanner.nextLine();

        while (!command.equals("Go Shopping!")) {

            if (command.contains("Urgent")) {
                String item = command.split(" ")[1];
                if (!isOnList(list, item)) {
                    list = addUrgentItem(list, item);
                }
            } else if (command.contains("Unnecessary")) {
                String item = command.split(" ")[1];
                if (isOnList(list, item)) {
                    list = removeUnnecessaryItem(list, item);
                }
            } else if (command.contains("Correct")) {
                String oldItem = command.split(" ")[1];
                String newItem = command.split(" ")[2];
                if (isOnList(list, oldItem)) {
                    list = correctItem(list, oldItem, newItem);
                }
            } else if (command.contains("Rearrange")) {
                String item = command.split(" ")[1];
                if (isOnList(list, item)) {
                    list = rearrangeItems(list, item);
                }
            }
            command = scanner.nextLine();
        }

        System.out.println(String.join(", ", list));
    }

    public static boolean isOnList (String[] list, String item) {
        boolean isOnList = false;
        for (int i = 0; i < list.length; i++) {
            if (item.equals(list[i])) {
                isOnList = true;
                break;
            }
        }

        return isOnList;
    }

    public static String[] addUrgentItem (String[] list, String item) {
        String[] newList = new String[list.length + 1];
        newList[0] = item;

        for (int i = 1; i < newList.length; i++) {
            newList[i] = list[i - 1];
        }

        list = newList;
        return list;
    }

    public static String[] removeUnnecessaryItem (String[] list, String item) {
        String[] newList = new String[list.length - 1];

        int index = 0;
        for (int i = 0; i < list.length; i++) {
            if (!list[i].equals(item)) {
                newList[index++] = list[i];
            }
        }

        list = newList;
        return list;
    }

    public static String[] correctItem (String[] list, String oldItem, String newItem) {

        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(oldItem)) {
                list[i] = newItem;
            }
        }

        return list;
    }

    public static String[] rearrangeItems (String[] list, String item) {
        String[] newList = new String[list.length];

        int index = 0;
        for (int i = 0; i < list.length; i++) {
            if (!list[i].equals(item)) {
                newList[index++] = list[i];
            }
        }
        newList[newList.length - 1] = item;
        list = newList;

        return list;
    }
}
