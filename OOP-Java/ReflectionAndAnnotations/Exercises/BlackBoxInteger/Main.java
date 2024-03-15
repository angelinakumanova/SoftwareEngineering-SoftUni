package ReflectionAndAnnotation.Exercises.BlackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws
            NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException,
            NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);
        Class<BlackBoxInt> blackBoxIntClass = BlackBoxInt.class;

        Constructor<BlackBoxInt> constructor = blackBoxIntClass.getDeclaredConstructor();
        constructor.setAccessible(true);

        BlackBoxInt blackBoxInt = constructor.newInstance();

        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            String[] tokens = input.split("_");
            String command = tokens[0];
            int value = Integer.parseInt(tokens[1]);

            Method method = blackBoxIntClass.getDeclaredMethod(command, int.class);
            method.setAccessible(true);
            method.invoke(blackBoxInt, value);

            Field field = blackBoxIntClass.getDeclaredField("innerValue");
            field.setAccessible(true);

            System.out.println(field.get(blackBoxInt));


            input = scanner.nextLine();
        }
    }
}
