package Exams.Exam_13Dec23.FishingPond;

public class Fish {
    private String species;
    private int age;
    private String matingSeason;

    public Fish(String species, int age, String matingSeason) {
        this.species = species;
        this.age = age;
        this.matingSeason = matingSeason;
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public String getMatingSeason() {
        return matingSeason;
    }


    @Override
    public String toString() {
        return String.format("This %s is %d years old and reproduces through %s.",
                getSpecies(), getAge(), getMatingSeason());
    }
}
