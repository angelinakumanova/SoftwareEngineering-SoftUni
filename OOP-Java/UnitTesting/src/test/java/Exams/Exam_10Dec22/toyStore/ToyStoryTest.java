package Exams.Exam_10Dec22.toyStore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ToyStoryTest {

    private Toy toy;
    private ToyStore toyStore;

    @Before
    public void setUp() {
        this.toy = new Toy("TOYS", "1");
        this.toyStore = new ToyStore();
    }

    @Test
    public void testToyConstructor_ShouldSetCorrectValues() {
        String expectedManufacturer = "TOYS";
        String expectedToyId = "1";

        Assert.assertEquals(expectedManufacturer, toy.getManufacturer());
        Assert.assertEquals(expectedToyId, toy.getToyId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddToy_ShouldThrowExceptionIfShelfIsNonExistent() throws OperationNotSupportedException {
        toyStore.addToy("H", toy);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddToy_ShouldThrowExceptionIfShelfIsAlreadyTaken() throws OperationNotSupportedException {
        toyStore.addToy("A", toy);
        toyStore.addToy("A", toy);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddToy_ShouldThrowExceptionIfToyAlreadyExists() throws OperationNotSupportedException {
        toyStore.addToy("B", toy);
        toyStore.addToy("C", toy);
    }

    @Test
    public void testAddToy_ShouldPutToySuccessfully() throws OperationNotSupportedException {
        Assert.assertEquals(String.format("Toy:%s placed successfully!", toy.getToyId()), toyStore.addToy("D", toy));
        Assert.assertTrue(toyStore.getToyShelf().containsValue(toy));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveToy_ShouldThrowExceptionIfShelfIsNonExistent() throws OperationNotSupportedException {
        toyStore.removeToy("H", toy);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveToy_ShouldThrowExceptionIfToyInTheShelfIsNonExistent() {
        toyStore.removeToy("A", toy);
    }

    @Test
    public void testRemoveToy_ShouldRemoveToySuccessfully() throws OperationNotSupportedException {
        toyStore.addToy("A", toy);
        Assert.assertEquals(String.format("Remove toy:%s successfully!", toy.getToyId()), toyStore.removeToy("A", toy));
        Assert.assertNull(toyStore.getToyShelf().get("A"));
    }

}