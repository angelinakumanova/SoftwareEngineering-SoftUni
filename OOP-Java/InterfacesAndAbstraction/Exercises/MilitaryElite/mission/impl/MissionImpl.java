package InterfacesAndAbstraction.Exercises.MilitaryElite.mission.impl;

import InterfacesAndAbstraction.Exercises.MilitaryElite.enums.State;
import InterfacesAndAbstraction.Exercises.MilitaryElite.mission.Mission;

public class MissionImpl implements Mission {
    private String codeName;
    private State state;

    public MissionImpl(String codeName, String state) {
        this.codeName = codeName;
        this.setState(state);
    }

    @Override
    public String getCodeName() {
        return this.codeName;
    }

    @Override
    public State getState() {
        return this.state;
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s", this.codeName, this.state.toString());
    }

    private void setState(String state) {
        this.state = State.valueOf(state);
    }
}
