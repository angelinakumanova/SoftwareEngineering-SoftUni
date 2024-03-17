package ReflectionAndAnnotation.Lab.Annotations.CodingTracker;

import java.lang.reflect.Method;

public class Tracker {

    @Author(name = "George")
    public static void main(String[] args) {
        printMethodsByAuthor(Tracker.class);
    }

    @Author(name = "Peter")
   public static void printMethodsByAuthor(Class<?> clazz) {
      for (Method method : clazz.getDeclaredMethods()) {
          System.out.println(method.getAnnotation(Author.class).name() + ": " + method.getName() + "()");
      }

   }
}
