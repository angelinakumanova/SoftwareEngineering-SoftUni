package UnitTesting.Exercises.p_03IteratorTest;

import UnitTesting.Exercises.p03_IteratorTest.ListIterator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.lang.reflect.Field;
import java.util.List;

public class IteratorTests {

    private ListIterator listIterator;

    @Before
    public void setUp() throws OperationNotSupportedException {
        this.listIterator = new ListIterator("First", "Second", "Third");
    }

    @Test
    public void testConstructor_ShouldSetCorrectValues() throws NoSuchFieldException, IllegalAccessException {
        String[] expectedElements = {"First", "Second", "Third"};

        Field field = listIterator.getClass().getDeclaredField("elements");
        field.setAccessible(true);
        List<String> list = (List<String>) field.get(listIterator);

        String[] actualElements = list.toArray(String[]::new);

        Assert.assertArrayEquals(expectedElements, actualElements);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructor_ShouldThrowAnExceptionIfElementsAreNull() throws OperationNotSupportedException {
        listIterator = new ListIterator(null);
    }

    @Test
    public void testMove_ShouldReturnTrueIfItMovedToNextElement() {
        Assert.assertTrue(listIterator.move());
    }

    @Test
    public void testMove_ShouldReturnFalseIfItCannotMoveToNextElement() {
        listIterator.move();
        listIterator.move();
        Assert.assertFalse(listIterator.move());
    }

    @Test
    public void testHasNext_ShouldReturnTrueIfThereIsNextElement() {
        Assert.assertTrue(listIterator.hasNext());
    }

    @Test
    public void testHasNext_ShouldReturnFalseIfThereIsNoNextElement() {
        listIterator.move();
        listIterator.move();

        Assert.assertFalse(listIterator.hasNext());
    }

    @Test
    public void testPrint_ShouldPrintCurrentElement() {
        String expectedElement = "First";
        String actualElement = listIterator.print();

        Assert.assertEquals(expectedElement, actualElement);
    }

    @Test(expected = IllegalStateException.class)
    public void testPrint_ShouldThrowAnExceptionIfIteratorIsEmpty() throws OperationNotSupportedException {
        listIterator = new ListIterator();
        listIterator.print();
    }
}
