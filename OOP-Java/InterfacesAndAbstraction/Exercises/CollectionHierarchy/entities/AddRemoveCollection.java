package InterfacesAndAbstraction.Exercises.CollectionHierarchy.entities;

import InterfacesAndAbstraction.Exercises.CollectionHierarchy.interfaces.AddRemovable;

public class AddRemoveCollection extends Collection implements AddRemovable {
    @Override
    public String remove() {
        return removeLast();
    }

    @Override
    public int add(String string) {
        return addFirst(string);
    }
}
