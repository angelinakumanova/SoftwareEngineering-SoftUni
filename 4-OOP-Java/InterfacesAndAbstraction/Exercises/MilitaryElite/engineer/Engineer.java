package InterfacesAndAbstraction.Exercises.MilitaryElite.engineer;

import InterfacesAndAbstraction.Exercises.MilitaryElite.repair.Repair;

import java.util.Collection;

public interface Engineer {
    void addRepair(Repair repair);

    Collection<Repair> getRepairs();
}
