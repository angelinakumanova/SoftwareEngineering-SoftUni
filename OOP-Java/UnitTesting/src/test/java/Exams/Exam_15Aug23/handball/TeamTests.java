package Exams.Exam_15Aug23.handball;

import Exams.Exam_15Aug23.handball.HandballPlayer;
import Exams.Exam_15Aug23.handball.Team;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TeamTests {
    private Team team;
    private HandballPlayer handballPlayer;

    @Before
    public void setUp() {
        this.team = new Team("BestTeam", 1);
        this.handballPlayer = new HandballPlayer("Gosho");
    }

    @Test
    public void handballPlayerConstructorSetsCorrectValues() {
        String expectedName = "Gosho";

        Assert.assertEquals(expectedName, handballPlayer.getName());
    }

    @Test
    public void teamConstructorSetsCorrectValues() {
        String expectedName = "BestTeam";
        int position = 1;

        Assert.assertEquals(expectedName, team.getName());
        Assert.assertEquals(1, team.getPosition());
    }

    @Test(expected = NullPointerException.class)
    public void teamConstructorThrowsAnExceptionForInvalidName() {
        new Team(null, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void teamConstructorThrowsAnExceptionForInvalidPosition() {
        new Team("BestTeam", -2);
    }

    @Test
    public void teamGetNameReturnsCorrectName() {
        Assert.assertEquals("BestTeam", team.getName());
    }

    @Test
    public void teamGetPositionReturnsCorrectPosition() {
        Assert.assertEquals(1, team.getPosition());
    }

    @Test
    public void teamGetCountReturnsNumberOfPlayers() {
        team.add(handballPlayer);

        Assert.assertEquals(1, team.getCount());
    }

    @Test
    public void teamAddAddsAPlayer() {
        team.add(handballPlayer);

        Assert.assertEquals(1, team.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void teamAddThrowsAnExceptionIfThereIsNoSpace() {
        team.add(handballPlayer);
        team.add(handballPlayer);

    }

    @Test
    public void teamRemoveRemovesPlayer() {
        team.add(handballPlayer);
        team.remove("Gosho");

        Assert.assertEquals(0, team.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void teamRemoveThrowsAnExceptionIfPlayerIsNonExistent() {
        team.remove("Stoyan");
    }

    @Test
    public void playerForAnotherTeamSetsActiveToFalse() {
        team.add(handballPlayer);

        team.playerForAnotherTeam("Gosho");
        Assert.assertFalse(handballPlayer.isActive());
    }

    @Test(expected = IllegalArgumentException.class)
    public void playerForAnotherTeamThrowsAnExceptionIfPlayerIsNonExistent() {

        team.playerForAnotherTeam("Gosho");
    }

    @Test
    public void getStatisticsReturnsAllPlayers() {
        team.add(handballPlayer);

        Assert.assertEquals("The player Gosho is in the team BestTeam.", team.getStatistics());
    }

}
