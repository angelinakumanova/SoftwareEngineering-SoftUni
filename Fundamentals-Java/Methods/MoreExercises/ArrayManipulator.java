package Methods.MoreExercises;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String command = scanner.nextLine();

        while(!command.equals("end")) {
            if (command.contains("exchange")) {
                command = command.split(" ")[1];
                int split = Integer.parseInt(command);
                if (split >= 0 && split < array.length) {
                    exchange(array, split);
                } else {
                    System.out.println("Invalid index");
                }
            } else if (command.contains("max")) {
               if (command.contains("even")) {
                    if (getMaxEven(array) == -1) {
                        System.out.println("No matches");
                    } else {
                        System.out.println(getMaxEven(array));
                    }
                } else if (command.contains("odd")) {
                   if (getMaxOdd(array) == -1) {
                       System.out.println("No matches");
                   } else {
                       System.out.println(getMaxOdd(array));
                   }
                }
            } else if (command.contains("min")) {
                if (command.contains("even")) {
                    if (getMinEven(array) == -1) {
                        System.out.println("No matches");
                    } else {
                        System.out.println(getMinEven(array));
                    }
                } else if (command.contains("odd")) {
                    if (getMinOdd(array) == -1) {
                        System.out.println("No matches");
                    } else {
                        System.out.println(getMinOdd(array));
                    }
                }
            } else if (command.contains("first")) {
                int split = Integer.parseInt(command.split(" ")[1]);
                if (split > array.length || split < 0) {
                    System.out.println("Invalid count");
                } else {
                    if (command.contains("even")) {
                        int[] numbers = getFirstEven(array, split);
                        printArray(numbers);

                    } else if (command.contains("odd")) {
                        int[] numbers = getFirstOdd(array, split);
                        printArray(numbers);
                    }
                }
            } else if (command.contains("last")) {
                int split = Integer.parseInt(command.split(" ")[1]);
                if (split > array.length || split < 0) {
                    System.out.println("Invalid count");
                } else {
                    if (command.contains("even")) {
                        int[] numbers = getLastEven(array, split);
                        printArray(numbers);

                    } else if (command.contains("odd")) {
                        int[] numbers = getLastOdd(array, split);
                        printArray(numbers);
                    }
                }
            }
            command = scanner.nextLine();
        }

        System.out.println(Arrays.toString(array));
    }


    public static int[] exchange (int[] array, int split) {
        int[] leftArray = new int[split + 1];
        int[] rightArray = new int[array.length - leftArray.length];

        for (int i = 0; i < leftArray.length; i++) {
            leftArray[i] = array[i];
        }

        int index = leftArray.length;
        for (int i = 0; i < rightArray.length; i++) {
            rightArray[i] = array[index++];
        }

        for (int i = 0; i < rightArray.length; i++) {
            array[i] = rightArray[i];
        }

        int secondIndex = 0;
        for (int i = rightArray.length; i < array.length; i++) {
            array[i] = leftArray[secondIndex++];

        }
        return array;
    }

    public static int getMaxEven (int[] array) {
        int biggestNumber = Integer.MIN_VALUE;
        int index = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0 && array[i] >= biggestNumber) {
                biggestNumber = array[i];
                index = i;
            }
        }
        return index;
    }

    public static int getMaxOdd (int[] array) {
        int biggestNumber = Integer.MIN_VALUE;
        int index = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0 && array[i] >= biggestNumber) {
                biggestNumber = array[i];
                index = i;
            }
        }

        return index;
    }

    public static int getMinEven (int[] array) {
        int smallestNumber = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0 && array[i] <= smallestNumber) {
                smallestNumber = array[i];
                index = i;
            }
        }

        return index;
    }

    public static int getMinOdd (int[] array) {
        int smallestNumber = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0 && array[i] <= smallestNumber) {
                smallestNumber = array[i];
                index = i;
            }
        }

        return index;
    }

    public static int[] getFirstEven (int[] array, int split) {
        int counter = 0;
        int[] numbers = new int[split];
        Arrays.fill(numbers, - 1);

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0 && counter < split) {
                numbers[counter] = array[i];
                counter++;
            }
        }

        return numbers;
    }

    public static int[] getFirstOdd (int[] array, int split) {
        int counter = 0;
        int[] numbers = new int[split];
        Arrays.fill(numbers, - 1);


        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0 && counter < split) {
                numbers[counter] = array[i];
                counter++;
            }
        }

        return numbers;
    }

    public static int[] getLastEven (int[] array, int split) {
        int counter = 0;
        int[] numbers = new int[split];
        Arrays.fill(numbers, -1);

        for (int i = array.length - 1; i >= 0; i--) {
            int num = array[i];
            if (array[i] % 2 == 0 && counter < split) {
                numbers[counter] = num;
                counter++;
            }
        }
        int[] finalArray = new int[numbers.length];

        int index = 0;
        for (int i = numbers.length - 1; i >= 0; i--) {
            finalArray[index++] = numbers[i];
        }
        return finalArray;
    }

    public static int[] getLastOdd (int[] array, int split) {
        int counter = 0;
        int[] numbers = new int[split];
        Arrays.fill(numbers, -1);

        for (int i = array.length - 1; i >= 0; i--) {
            int num = array[i];
            if (array[i] % 2 != 0 && counter < split) {
                numbers[counter] = num;
                counter++;
            }
        }

        int[] finalArray = new int[numbers.length];

        int index = 0;
        for (int i = numbers.length - 1; i >= 0; i--) {
            finalArray[index++] = numbers[i];
        }

        return finalArray;
    }

    public static void printArray (int[] numbers) {

        System.out.print("[");
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == -1) {
                continue;
            }
            if (i == numbers.length - 1) {
                System.out.print(numbers[i]);
            } else if (numbers[i + 1] != -1) {
                System.out.print(numbers[i] + ", ");
            } else {
                System.out.print(numbers[i]);
            }
        }
        System.out.println("]");
    }
}
