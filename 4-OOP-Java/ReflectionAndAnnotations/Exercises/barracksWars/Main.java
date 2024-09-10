package ReflectionAndAnnotation.Exercises.barracksWars;

import ReflectionAndAnnotation.Exercises.barracksWars.core.CommandInterpreterImpl;
import ReflectionAndAnnotation.Exercises.barracksWars.interfaces.CommandInterpreter;
import ReflectionAndAnnotation.Exercises.barracksWars.interfaces.Repository;
import ReflectionAndAnnotation.Exercises.barracksWars.interfaces.Runnable;
import ReflectionAndAnnotation.Exercises.barracksWars.interfaces.UnitFactory;
import ReflectionAndAnnotation.Exercises.barracksWars.core.Engine;
import ReflectionAndAnnotation.Exercises.barracksWars.core.factories.UnitFactoryImpl;
import ReflectionAndAnnotation.Exercises.barracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();
        CommandInterpreter commandInterpreter = new CommandInterpreterImpl(repository, unitFactory);

        Runnable engine = new Engine(commandInterpreter);
        engine.run();
    }
}
