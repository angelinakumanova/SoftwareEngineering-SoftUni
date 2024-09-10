package Exams.Exam_22Aug22.archeologicalExcavations;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ExcavationTests {
    private Excavation excavation;
    private Archaeologist archaeologist;

    @Before
    public void setUp() {
        this.excavation = new Excavation("Adventure", 2);
        this.archaeologist = new Archaeologist("Peter", 10);
    }

    @Test
    public void archaeologistConstructorSetsCorrectValues() {
        String expectedName = "Peter";
        double expectedEnergy = 10;

        Assert.assertEquals(expectedName, archaeologist.getName());
        Assert.assertEquals(expectedEnergy, archaeologist.getEnergy(), 0.0);
    }

    @Test
    public void excavationConstructorSetsCorrectValues() {
        String expectedName = "Adventure";
        int expectedCapacity = 2;

        Assert.assertEquals(expectedName, excavation.getName());
        Assert.assertEquals(expectedCapacity, excavation.getCapacity());

    }

    @Test(expected = NullPointerException.class)
    public void excavationConstructorThrowsAnExceptionIfNameIsInvalid() {
        new Excavation(null, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void excavationConstructorThrowsAnExceptionIfCapacityIsInvalid() {
        new Excavation("Adventure", -20);
    }

    @Test
    public void addArchaeologistAddsAnArchaeologist() {
        this.excavation.addArchaeologist(archaeologist);

        Assert.assertEquals(1, excavation.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addArchaeologistThrowsAnExceptionIfCapacityLimitIsReached() {
        excavation = new Excavation("Adventure", 0);
        this.excavation.addArchaeologist(archaeologist);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addArchaeologistThrowsAnExceptionIfArchaeologistIsExistent() {
        this.excavation.addArchaeologist(archaeologist);
        this.excavation.addArchaeologist(archaeologist);
    }

    @Test
    public void removeArchaeologistReturnsTrueIfRemoved() {
        this.excavation.addArchaeologist(archaeologist);


        Assert.assertTrue(this.excavation.removeArchaeologist("Peter"));
    }
}
