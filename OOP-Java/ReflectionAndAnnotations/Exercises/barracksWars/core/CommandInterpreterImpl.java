package ReflectionAndAnnotation.Exercises.barracksWars.core;

import ReflectionAndAnnotation.Exercises.barracksWars.interfaces.CommandInterpreter;
import ReflectionAndAnnotation.Exercises.barracksWars.interfaces.Executable;
import ReflectionAndAnnotation.Exercises.barracksWars.interfaces.Repository;
import ReflectionAndAnnotation.Exercises.barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreterImpl implements CommandInterpreter {

    private static final String COMMANDS_PACKAGE_NAME = "ReflectionAndAnnotation.Exercises.barracksWars.core.commands.";
    private Repository repository;
    private UnitFactory unitFactory;

    public CommandInterpreterImpl(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public Executable interpretCommand(String[] data, String commandName) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, ExecutionControl.NotImplementedException {
        String className = COMMANDS_PACKAGE_NAME + Character.toUpperCase(commandName.charAt(0)) +
                commandName.substring(1) + "Command";
        Class<Executable> clazz = (Class<Executable>) Class.forName(className);
        Constructor<Executable> constructor = clazz.getDeclaredConstructor(String[].class);
        Executable command = constructor.newInstance((Object) data);

        Field[] fields = clazz.getDeclaredFields();
        Field[] localFields = this.getClass().getDeclaredFields();

        for (Field field : fields) {
            if(field.isAnnotationPresent(Inject.class)) {
                for (Field localField : localFields) {
                    if (field.getType().equals(localField.getType())) {
                        field.setAccessible(true);
                        field.set(command, localField.get(this));
                    }
                }
            }
        }

        return command;
    }
}
