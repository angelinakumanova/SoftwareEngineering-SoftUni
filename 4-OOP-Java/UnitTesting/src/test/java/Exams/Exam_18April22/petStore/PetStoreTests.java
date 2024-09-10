package Exams.Exam_18April22.petStore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class PetStoreTests {

    private PetStore petStore;
    private Animal animal1;
    private Animal animal2;
    private Animal animal3;

    @Before
    public void setUp() {
        this.petStore = new PetStore();
        this.animal1 = new Animal("Dog", 15, 100);
        this.animal2 = new Animal("Cat", 30, 20);
        this.animal3 = new Animal("Horse", 90, 500);
        petStore.addAnimal(animal1);
        petStore.addAnimal(animal2);
        petStore.addAnimal(animal3);
    }

    @Test
    public void testGetCount_ShouldReturnCorrectValue() {
        Assert.assertEquals(3, petStore.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAnimal_ShouldThrowExceptionIfAnimalIsNull() {
        petStore.addAnimal(null);
    }

    @Test
    public void testAddAnimal_ShouldAddGivenAnimalSuccessfully() {
        petStore.addAnimal(animal1);

        Assert.assertEquals(4, petStore.getCount());
    }

    @Test
    public void testFindAllAnimalsWithMaxKilograms_ShouldReturnAnimalsWithGreaterKGsThanGiven() {
        List<Animal> allAnimalsWithMaxKilograms = petStore.findAllAnimalsWithMaxKilograms(20);

        Assert.assertEquals(2, allAnimalsWithMaxKilograms.size());
    }

    @Test
    public void testGetTheMostExpensiveAnimal_ShouldReturnTheCorrectAnimal() {
        Animal mostExpensiveAnimal = petStore.getTheMostExpensiveAnimal();

        Assert.assertEquals(animal3, mostExpensiveAnimal);
    }

    @Test
    public void testGetTheMostExpensiveAnimal_ShouldReturnNullIfPetStoreIsEmpty() {
        Animal mostExpensiveAnimal = new PetStore().getTheMostExpensiveAnimal();

        Assert.assertNull(mostExpensiveAnimal);
    }

    @Test
    public void testFindAllAnimalBySpecie_ShouldReturnAllSpeciesByGivenSpecie() {
        List<Animal> dogs = petStore.findAllAnimalBySpecie("Dog");

        Assert.assertEquals(1, dogs.size());
    }

}

