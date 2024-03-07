package InterfacesAndAbstraction.Exercises.CollectionHierarchy.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Collection {
    private int maxSize;
    private List<String> items;

    public Collection() {
        this.maxSize = 100;
        this.items = new ArrayList<>();
    }

    protected List<String> getItems() {
        return Collections.unmodifiableList(this.items);
    }

    protected int addLast(String string) {
        this.items.add(string);
        return this.items.size() - 1;
    }
    protected int addFirst(String string) {
        this.items.add(0,string);
        return 0;
    }

    protected String removeLast() {
        return this.items.remove(this.items.size() - 1);
    }

    protected String removeFirst() {
        return this.items.remove(0);
    }

    protected int getSize() {
        return this.items.size();
    }
}
