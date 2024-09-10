package ReflectionAndAnnotation.Exercises.barracksWars.core.commands;

import ReflectionAndAnnotation.Exercises.barracksWars.core.Inject;
import ReflectionAndAnnotation.Exercises.barracksWars.interfaces.Repository;

public class ReportCommand extends Command {
    @Inject
    private Repository repository;

    public ReportCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return this.repository.getStatistics();
    }
}
