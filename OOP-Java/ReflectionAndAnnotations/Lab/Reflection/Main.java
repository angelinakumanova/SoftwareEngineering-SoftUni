package ReflectionAndAnnotation.Lab.Reflection;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<Reflection> reflectionClass = Reflection.class;

        System.out.println(reflectionClass);
        System.out.println(reflectionClass.getSuperclass());
        for (Class<?> i : reflectionClass.getInterfaces()) {
            System.out.println(i);
        }
        System.out.println(reflectionClass.getConstructor().newInstance());
    }
}
