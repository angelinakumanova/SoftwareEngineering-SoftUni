package InterfacesAndAbstraction.Exercises.MilitaryElite.soldier.impl;

import InterfacesAndAbstraction.Exercises.MilitaryElite.enums.Corp;
import InterfacesAndAbstraction.Exercises.MilitaryElite.priv.impl.PrivateImpl;
import InterfacesAndAbstraction.Exercises.MilitaryElite.soldier.SpecialisedSoldier;

public class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {
    private Corp corp;

    public SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, Corp corp) {
        super(id, firstName, lastName, salary);
        this.corp = corp;
    }

    @Override
    public Corp getCorps() {
        return this.corp;
    }

    public void setCorps(String corps) {
        this.corp = Corp.valueOf(corps);
    }
}
