package Exams.Exam_13Dec23.FishingPond;

public class Main {
    public static void main(String[] args) {

        Pond pond = new Pond(5);

        Fish trout = new Fish("Trout", 5, "winter");
        Fish perch = new Fish("Perch", 2, "summer");
        Fish pike = new Fish("Pike", 4, "spring");
        Fish catfish = new Fish("Catfish", 8, "summer");

        pond.addFish(trout);
        pond.addFish(perch);
        pond.addFish(pike);

        System.out.println(pond.removeFish("Trout"));  //true
        System.out.println(pond.removeFish("Carp"));  //false
        System.out.println(pike.getMatingSeason());  //spring

        pond.addFish(catfish);

        System.out.println(pond.getOldestFish().getSpecies());  //Catfish
        System.out.println(pond.getFish("Catfish"));

        System.out.println(pond.getVacancies()); //2
        System.out.println(pond.report());

    }
}