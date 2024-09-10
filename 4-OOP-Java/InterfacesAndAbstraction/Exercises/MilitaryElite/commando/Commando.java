package InterfacesAndAbstraction.Exercises.MilitaryElite.commando;

import InterfacesAndAbstraction.Exercises.MilitaryElite.mission.Mission;

import java.util.Collection;

public interface Commando {
    void addMission(Mission mission);

    Collection<Mission> getMissions();
}
