package InterfacesAndAbstraction.Exercises.CollectionHierarchy;

import InterfacesAndAbstraction.Exercises.CollectionHierarchy.entities.AddCollection;
import InterfacesAndAbstraction.Exercises.CollectionHierarchy.entities.AddRemoveCollection;
import InterfacesAndAbstraction.Exercises.CollectionHierarchy.entities.MyListImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] strings = scanner.nextLine().split("\\s+");
        int removedOperations = Integer.parseInt(scanner.nextLine());

        AddCollection addCollection = new AddCollection();
        for (int i = 0; i < strings.length; i++) {
            System.out.print(addCollection.add(strings[i]) + " ");
        }
        System.out.println();


        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        for (int i = 0; i < strings.length; i++) {
            System.out.print(addRemoveCollection.add(strings[i]) + " ");
        }
        System.out.println();

        MyListImpl myList = new MyListImpl();
        for (int i = 0; i < strings.length; i++) {
            System.out.print(myList.add(strings[i]) + " ");
        }
        System.out.println();

        for (int i = 0; i < removedOperations; i++) {
            System.out.print(addRemoveCollection.remove() + " ");
        }
        System.out.println();

        for (int i = 0; i < removedOperations; i++) {
            System.out.print(myList.remove() + " ");
        }
        System.out.println();
    }
}
