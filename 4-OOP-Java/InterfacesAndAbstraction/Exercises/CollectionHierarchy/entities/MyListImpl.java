package InterfacesAndAbstraction.Exercises.CollectionHierarchy.entities;

import InterfacesAndAbstraction.Exercises.CollectionHierarchy.interfaces.MyList;

public class MyListImpl extends Collection implements MyList {
    @Override
    public String remove() {
        return removeFirst();
    }

    @Override
    public int add(String string) {
        return addFirst(string);
    }

    @Override
    public int getUsed() {
        return getSize();
    }
}
