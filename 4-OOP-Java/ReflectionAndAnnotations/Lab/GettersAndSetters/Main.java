package ReflectionAndAnnotation.Lab.GettersAndSetters;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<Reflection> reflectionClass = Reflection.class;
        Method[] methods = reflectionClass.getDeclaredMethods();

        List<Method> setters = Arrays.stream(methods).filter(isSetter())
                .sorted(Comparator.comparing(Method::getName))
                .collect(Collectors.toList());;
        List<Method> getters = Arrays.stream(methods).filter(isGetter())
                .sorted(Comparator.comparing(Method::getName))
                .collect(Collectors.toList());

        for (Method getter : getters) {
            System.out.printf("%s will return class %s%n",
                    getter.getName(),
                    getter.getReturnType().getName());
        }

        for (Method setter : setters) {
            System.out.printf("%s and will set field of class %s%n",
                    setter.getName(),
                    setter.getParameterTypes()[0].getName());
        }
    }

    private static Predicate<Method> isGetter() {
        return method -> {
            boolean hasGetPrefix = method.getName().startsWith("get");
            boolean hasZeroParameters = method.getParameterCount() == 0;
            boolean isVoid = method.getReturnType().getName().equalsIgnoreCase("void");

            if (hasGetPrefix && hasZeroParameters && !isVoid) {
                return true;
            }
            return false;
        };
    }

    private static Predicate<Method> isSetter() {

        return method -> {
            boolean hasSetPrefix = method.getName().startsWith("set");
            boolean hasOneParameter = method.getParameterCount() == 1;
            boolean isVoid = method.getReturnType().getName().equalsIgnoreCase("void");

            if (hasSetPrefix && hasOneParameter && isVoid) {
                return true;
            }
            return false;
        };
    }
}
