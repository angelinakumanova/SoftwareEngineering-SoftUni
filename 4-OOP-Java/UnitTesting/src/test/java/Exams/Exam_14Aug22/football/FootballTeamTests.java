package Exams.Exam_14Aug22.football;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FootballTeamTests {

    private FootballTeam footballTeam;
    private Footballer footballer;

    @Before
    public void setUp() {
        this.footballTeam = new FootballTeam("BestTeam", 2);
        this.footballer = new Footballer("George");
    }

    @Test
    public void testConstructor_ShouldSetCorrectValues() {
        String expectedName = "BestTeam";
        int expectedVacantPositions = 2;

        Assert.assertEquals(expectedName, footballTeam.getName());
        Assert.assertEquals(expectedVacantPositions, footballTeam.getVacantPositions());
    }

    @Test(expected = NullPointerException.class)
    public void testConstructor_ShouldThrowExceptionIfNameIsNull() {
        new FootballTeam(null, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_ShouldThrowExceptionIfVacantPositionsIsNegativeNumber() {
        new FootballTeam("BestTeam", -1);
    }

    @Test
    public void testGetCount_ShouldReturnCorrectCountOfFootballers() {
        Assert.assertEquals(0, this.footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddFootballer_ShouldThrowExceptionIfThereIsNoSpace() {
        this.footballTeam.addFootballer(footballer);
        this.footballTeam.addFootballer(footballer);
        this.footballTeam.addFootballer(footballer);
    }

    @Test
    public void testAddFootballer_ShouldAddFootballerSuccessfully() {
        this.footballTeam.addFootballer(footballer);

        Assert.assertEquals(1, footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveFootballer_ShouldThrowExceptionIfFootballerIsNonExistent() {
        footballTeam.removeFootballer("Peter");
    }

    @Test
    public void testRemoveFootballer_ShouldRemoveFootballerSuccessfully() {
        footballTeam.addFootballer(footballer);
        footballTeam.removeFootballer("George");

        Assert.assertEquals(0, footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFootballerForSale_ShouldThrowExceptionIfFootballerIsNonExistent() {
        footballTeam.footballerForSale("Peter");
    }

    @Test
    public void testFootballerForSale_ShouldSetActiveToFalse() {
        footballTeam.addFootballer(footballer);

        footballTeam.footballerForSale("George");
        Assert.assertFalse(footballer.isActive());
    }

    @Test
    public void testGetStatistics_ShouldReturnCorrectStatistics() {
        footballTeam.addFootballer(footballer);
        Assert.assertEquals("The footballer George is in the team BestTeam.", footballTeam.getStatistics());
    }

}
