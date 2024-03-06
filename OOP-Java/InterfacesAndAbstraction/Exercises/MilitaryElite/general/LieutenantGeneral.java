package InterfacesAndAbstraction.Exercises.MilitaryElite.general;

import InterfacesAndAbstraction.Exercises.MilitaryElite.soldier.Soldier;

import java.util.Collection;


public interface LieutenantGeneral {
    Collection<Soldier> getPrivates();

    void addPrivate(Soldier soldier);
}
