package InterfacesAndAbstraction.Exercises.MilitaryElite.general.impl;

import InterfacesAndAbstraction.Exercises.MilitaryElite.general.LieutenantGeneral;
import InterfacesAndAbstraction.Exercises.MilitaryElite.priv.impl.PrivateImpl;
import InterfacesAndAbstraction.Exercises.MilitaryElite.soldier.Soldier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {
    private Collection<Soldier> privates;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary, Collection<Soldier> privates) {
        super(id, firstName, lastName, salary);
        this.setPrivates(privates);
    }


    @Override
    public Collection<Soldier> getPrivates() {
        return Collections.unmodifiableCollection(this.privates);
    }

    @Override
    public void addPrivate(Soldier soldier) {
        this.privates.add(soldier);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());
        sb.append("Privates:").append(System.lineSeparator());
        this.sortCollection().forEach(p -> sb.append(" ").append(p).append(System.lineSeparator()));

        return sb.toString().trim();
    }

    private Collection<Soldier> sortCollection() {
        return this.privates.stream().sorted(Comparator.comparing(Soldier::getId).reversed()).collect(Collectors.toList());
    }

    private void setPrivates(Collection<Soldier> privates) {
        if (privates == null) {
            this.privates = new ArrayList<>();
        } else {
            this.privates = privates;
        }
    }
}
