package UnitTesting.Exercises.p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTests {

    private Database database;

    @Before
    public void setUp() throws OperationNotSupportedException {
        this.database = new Database(1, 2, 3, 4, 5);
    }
    @Test
    public void testDatabaseConstructor_ShouldSetCorrectValues() {
        Integer[] expectedArray = {1, 2, 3, 4, 5};

        Assert.assertArrayEquals(expectedArray, database.getElements());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testDatabaseConstructor_ShouldThrowAnExceptionIfIntegersAreMoreThanSixteen() throws OperationNotSupportedException {
        database = new Database(new Integer[17]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testDatabaseConstructor_ShouldThrowAnExceptionIfIntegersAreLessThanOne() throws OperationNotSupportedException {
        database = new Database();
    }

    @Test
    public void testAdd_ShouldAddElementAtLastPosition() throws OperationNotSupportedException {
        database.add(6);

        Integer lastElement = database.getElements()[database.getElements().length - 1];

        Assert.assertEquals(Integer.valueOf(6), lastElement);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAdd_ShouldThrowAnExceptionIfElementIsNull() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testRemove_ShouldRemoveLastElement() throws OperationNotSupportedException {
        Integer beforeLastElement = database.getElements()[database.getElements().length - 2];

        database.remove();

        Integer lastElement = database.getElements()[database.getElements().length - 1];

        Assert.assertEquals(beforeLastElement, lastElement);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemove_ShouldThrowAnExceptionIfDatabaseIsEmpty() throws OperationNotSupportedException {
        database = new Database();

        database.remove();
    }
}
