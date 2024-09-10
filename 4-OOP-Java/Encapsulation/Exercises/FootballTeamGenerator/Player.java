package Encapsulation.Exercises.FootballTeamGenerator;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
    }

    public String getName() {
        return name;
    }

    public double overallSkillLevel() {
        return (this.endurance + this.sprint + this.dribble + this.passing + this.shooting) / 5.00;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setEndurance(int endurance) {
        validateStats("Endurance", endurance);
        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        validateStats("Sprint", sprint);
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        validateStats("Dribble", dribble);
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        validateStats("Passing", passing);
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        validateStats("Shooting", shooting);
        this.shooting = shooting;
    }

    private void validateStats(String statName, int stat) {
        if (stat < 0 || stat > 100) {
            throw new IllegalArgumentException(String.format("%s should be between 0 and 100.", statName));
        }
    }

}
