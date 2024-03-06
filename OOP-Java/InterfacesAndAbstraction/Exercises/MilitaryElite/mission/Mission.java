package InterfacesAndAbstraction.Exercises.MilitaryElite.mission;

import InterfacesAndAbstraction.Exercises.MilitaryElite.enums.State;

public interface Mission {
    String getCodeName();

    State getState();
}
