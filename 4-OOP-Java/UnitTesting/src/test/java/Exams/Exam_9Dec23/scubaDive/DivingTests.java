package Exams.Exam_9Dec23.scubaDive;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DivingTests {

    private Diving diving;
    private DeepWaterDiver diver;

    @Before
    public void setUp() {
        this.diving = new Diving("Adventure", 3);
        this.diver = new DeepWaterDiver("George", 200);
    }

    @Test
    public void testConstructor_ShouldSetCorrectValues() {
        String expectedName = "Adventure";
        int expectedCapacity = 3;

        Assert.assertEquals(expectedName, diving.getName());
        Assert.assertEquals(expectedCapacity, diving.getCapacity());
    }

    @Test(expected = NullPointerException.class)
    public void testConstructor_ShouldThrowExceptionIfNameIsNull() {
        new Diving(null, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_ShouldThrowExceptionIfCapacityIsLessThanZero() {
        new Diving("Adventure", -1);
    }

    @Test
    public void testGetCount_ShouldReturnCountOfDivers() {
        int count = diving.getCount();
        Assert.assertEquals(0, count);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddDeepWaterDiver_ShouldThrowExceptionIfThereIsNoFreeSpace() {
        diving.addDeepWaterDiver(diver);
        diving.addDeepWaterDiver(new DeepWaterDiver("Peter", 200));
        diving.addDeepWaterDiver(new DeepWaterDiver("Ivan", 200));
        diving.addDeepWaterDiver(new DeepWaterDiver("Dimitar", 200));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddDeepWaterDiver_ShouldThrowExceptionIfDiverAlreadyExists() {
        diving.addDeepWaterDiver(diver);
        diving.addDeepWaterDiver(diver);
    }

    @Test
    public void testAddDeepWaterDiver_ShouldAddDiverSuccessfully() {
        diving.addDeepWaterDiver(diver);

        Assert.assertEquals(1, diving.getCount());
    }

    @Test
    public void testRemoveDeepWaterDiver_ShouldReturnTrueIfDiverIsRemovedSuccessfully() {
        diving.addDeepWaterDiver(diver);

        Assert.assertTrue(diving.removeDeepWaterDiver("George"));
    }

    @Test
    public void testRemoveDeepWaterDiver_ShouldReturnFalseIfDiverIsNonExistent() {
        Assert.assertFalse(diving.removeDeepWaterDiver("Peter"));
    }

}
