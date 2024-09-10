package ReflectionAndAnnotation.Exercises.barracksWars.core.commands;

import ReflectionAndAnnotation.Exercises.barracksWars.core.Inject;
import ReflectionAndAnnotation.Exercises.barracksWars.interfaces.Repository;
import jdk.jshell.spi.ExecutionControl;

public class RetireCommand extends Command{

    @Inject
    private Repository repository;
    public RetireCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException {
        String unitType = getData()[1];

        this.repository.removeUnit(unitType);
        return unitType + " retired!";
    }
}
