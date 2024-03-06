package InterfacesAndAbstraction.Exercises.MilitaryElite.commando.impl;

import InterfacesAndAbstraction.Exercises.MilitaryElite.commando.Commando;
import InterfacesAndAbstraction.Exercises.MilitaryElite.enums.Corp;
import InterfacesAndAbstraction.Exercises.MilitaryElite.mission.Mission;
import InterfacesAndAbstraction.Exercises.MilitaryElite.soldier.impl.SpecialisedSoldierImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {
    private Collection<Mission> missions;

    public CommandoImpl(int id, String firstName, String lastName, double salary, Corp corp, Collection<Mission> missions) {
        super(id, firstName, lastName, salary, corp);
        this.setMissions(missions);
    }

    @Override
    public void addMission(Mission mission) {
        this.missions.add(mission);
    }

    @Override
    public Collection<Mission> getMissions() {
        return Collections.unmodifiableCollection(this.missions);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());
        sb.append("Corps: ").append(getCorps()).append(System.lineSeparator());
        sb.append("Missions:").append(System.lineSeparator());
        for (Mission mission : this.missions) {
            sb.append(" ").append(mission).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }

    private void setMissions(Collection<Mission> missions) {
        if (missions == null) {
            this.missions = new ArrayList<>();
        } else {
            this.missions = missions;
        }
    }
}
