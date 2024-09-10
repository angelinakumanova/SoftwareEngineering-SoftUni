package InterfacesAndAbstraction.Exercises.CollectionHierarchy.entities;

import InterfacesAndAbstraction.Exercises.CollectionHierarchy.interfaces.Addable;

public class AddCollection extends Collection implements Addable {

    @Override
    public int add(String string) {
        return addLast(string);
    }
}
