package Inheritance.Exercises.Animals.cat;

public class Tomcat extends Cat{
    private static final String DEFAULT_GENDER = "Male";
    public Tomcat(String name, int age) {
        super(name, age, DEFAULT_GENDER);
    }

    @Override
    public String produceSound() {
        return "MEOW";
    }
}
