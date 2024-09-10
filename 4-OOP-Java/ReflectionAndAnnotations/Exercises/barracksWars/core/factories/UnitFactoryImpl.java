package ReflectionAndAnnotation.Exercises.barracksWars.core.factories;

import ReflectionAndAnnotation.Exercises.barracksWars.interfaces.Unit;
import ReflectionAndAnnotation.Exercises.barracksWars.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"ReflectionAndAnnotation.Exercises.barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
		String className = UNITS_PACKAGE_NAME + unitType;
		Class<Unit> unitClass = (Class<Unit>) Class.forName(className);

		Constructor<Unit> constructor = unitClass.getDeclaredConstructor();

		return constructor.newInstance();
	}
}
