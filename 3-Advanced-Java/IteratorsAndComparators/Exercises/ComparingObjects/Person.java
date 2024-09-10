package IteratorsAndComparators.Exercises.ComparingObjects;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    @Override
    public int compareTo(Person p2) {
        int compare = this.name.compareTo(p2.name);
        if (compare == 0) {
            compare = Integer.compare(this.age, p2.age);
            if (compare == 0) {
                compare = this.town.compareTo(p2.town);
            }
        }
        return compare;
    }
}
