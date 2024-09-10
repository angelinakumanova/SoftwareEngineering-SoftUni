package ReflectionAndAnnotation.Exercises.barracksWars.core.commands;

import ReflectionAndAnnotation.Exercises.barracksWars.core.Inject;
import ReflectionAndAnnotation.Exercises.barracksWars.interfaces.Repository;
import ReflectionAndAnnotation.Exercises.barracksWars.interfaces.Unit;
import ReflectionAndAnnotation.Exercises.barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationTargetException;

public class AddCommand extends Command {

    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;
    public AddCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String unitType = getData()[1];
        Unit unitToAdd = this.unitFactory.createUnit(unitType);
        this.repository.addUnit(unitToAdd);
        return unitType + " added!";
    }
}
