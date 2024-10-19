package orm.context;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public interface DbContext<E> {
    boolean persist(E entity) throws IllegalAccessException, NoSuchFieldException, SQLException;

    Iterable<E> find(Class<E> table) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;

    Iterable<E> find(Class<E> table, String where);

    E findFirst(Class<E> table);

    E findFirst(Class<E> table, String where);
}
