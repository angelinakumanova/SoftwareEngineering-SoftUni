package InterfacesAndAbstraction.Exercises.MilitaryElite.engineer.impl;

import InterfacesAndAbstraction.Exercises.MilitaryElite.engineer.Engineer;
import InterfacesAndAbstraction.Exercises.MilitaryElite.enums.Corp;
import InterfacesAndAbstraction.Exercises.MilitaryElite.repair.Repair;
import InterfacesAndAbstraction.Exercises.MilitaryElite.soldier.impl.SpecialisedSoldierImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {
    private Collection<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName, double salary, Corp corp, Collection<Repair> repairs) {
        super(id, firstName, lastName, salary, corp);
        this.setRepairs(repairs);
    }



    @Override
    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }

    @Override
    public Collection<Repair> getRepairs() {
        return Collections.unmodifiableCollection(this.repairs);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());
        sb.append("Corps: ").append(super.getCorps()).append(System.lineSeparator());
        sb.append("Repairs:").append(System.lineSeparator());
        for (Repair repair : this.repairs) {
            sb.append(" ").append(repair).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }

    private void setRepairs(Collection<Repair> repairs) {
        if (repairs == null) {
            this.repairs = new ArrayList<>();
        } else {
            this.repairs = repairs;
        }
    }
}
