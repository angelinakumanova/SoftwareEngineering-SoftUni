package ObjectsAndClasses.MoreExercises.TeamWorkProjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Team {

    private String user;
    private String nameOfTeam;

    private List<String> members;


    public Team(String user, String nameOfTeam) {
        this.user = user;
        this.nameOfTeam = nameOfTeam;
        members = new ArrayList<>();
    }

    public void addMembers(String member) {
        this.members.add(member);
    }

    public int membersCount() {
        return this.members.size();
    }


    public List<String> getMembers() {
        return this.members;
    }

    public String getNameOfTeam() {
        return this.nameOfTeam;
    }

    public String getUser() {
        return this.user;
    }
}
