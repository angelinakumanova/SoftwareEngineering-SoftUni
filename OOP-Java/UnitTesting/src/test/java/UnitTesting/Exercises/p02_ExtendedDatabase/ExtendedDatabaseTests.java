package UnitTesting.Exercises.p02_ExtendedDatabase;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.naming.OperationNotSupportedException;

public class ExtendedDatabaseTests {
    private static final Person PERSON1 = Mockito.mock(Person.class);
    private static final Person PERSON2 = Mockito.mock(Person.class);
    private static final Person PERSON3 = Mockito.mock(Person.class);
    private static final Person[] PEOPLE = {PERSON1, PERSON2, PERSON3};
    private Database database;

    @Before
    public void setUp() throws OperationNotSupportedException {
        this.database = new Database(PEOPLE);
    }

    @After
    public void tearDown() {
        Mockito.reset(PEOPLE);
    }

    @Test
    public void testConstructor_ShouldSetCorrectValues() {
        Person[] expectedPeople = {PERSON1, PERSON2, PERSON3};

        Assert.assertArrayEquals(expectedPeople, database.getElements());
    }


    @Test
    public void testAdd_ShouldAddElementAtLastPosition() throws OperationNotSupportedException {
        Person mockedPerson = Mockito.mock(Person.class);
        database.add(mockedPerson);

        Person lastPerson = database.getElements()[database.getElements().length - 1];
        Assert.assertEquals(mockedPerson, lastPerson);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAdd_ShouldThrowAnExceptionIfElementIsNull() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testRemove_ShouldRemoveLastElement() throws OperationNotSupportedException {
        Person beforeLastElement = database.getElements()[database.getElements().length - 2];

        database.remove();

        Person lastElement = database.getElements()[database.getElements().length - 1];

        Assert.assertEquals(beforeLastElement, lastElement);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemove_ShouldThrowAnExceptionIfDatabaseIsEmpty() throws OperationNotSupportedException {
        database = new Database();

        database.remove();
    }

    @Test
    public void testFindByUsername_ShouldReturnCorrectElement() throws OperationNotSupportedException {
        Mockito.when(PERSON1.getUsername()).thenReturn("Peter");

        Person foundPerson = database.findByUsername("Peter");

        Assert.assertEquals(PERSON1, foundPerson);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsername_ShouldThrowAnExceptionIfUsernameIsNull() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsername_ShouldThrowAnExceptionIfUsernameIsNotPresent() throws OperationNotSupportedException {
        database.findByUsername("Peter");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsername_ShouldThrowAnExceptionWhenDuplicateNamesExist() throws OperationNotSupportedException {
        Mockito.when(PERSON1.getUsername()).thenReturn("Peter");
        Mockito.when(PERSON2.getUsername()).thenReturn("Peter");

        database.findByUsername("Peter");
    }

    @Test
    public void testFindById_ShouldReturnCorrectElement() throws OperationNotSupportedException {
        Mockito.when(PERSON2.getId()).thenReturn(2);

        Person foundPerson = database.findById(2);

        Assert.assertEquals(PERSON2, foundPerson);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindById_ShouldThrowAnExceptionWhenIdIsNotPresent() throws OperationNotSupportedException {
        database.findById(2);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindById_ShouldThrowAnExceptionWhenDuplicateIdsExist() throws OperationNotSupportedException {
        Mockito.when(PERSON2.getId()).thenReturn(2);
        Mockito.when(PERSON3.getId()).thenReturn(2);

        database.findById(2);
    }

}
