package InterfacesAndAbstraction.Exercises.MilitaryElite.priv.impl;

import InterfacesAndAbstraction.Exercises.MilitaryElite.priv.Private;
import InterfacesAndAbstraction.Exercises.MilitaryElite.soldier.impl.SoldierImpl;

public class PrivateImpl extends SoldierImpl implements Private {
    private double salary;

    public PrivateImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        return String.format("%s Salary: %.2f", super.toString(), this.salary);
    }
}
