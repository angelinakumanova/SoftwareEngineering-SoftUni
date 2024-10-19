package orm.context;

import orm.annotations.Column;
import orm.annotations.Entity;
import orm.annotations.Id;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EntityManager<E> implements DbContext<E> {
    private Connection connection;

    public EntityManager(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean persist(E entity) throws IllegalAccessException, NoSuchFieldException, SQLException {
        int idValue = getId(entity);

        if (idValue == 0) {
            return doInsert(entity);
        }


        return doUpdate(entity, idValue);
    }

    private boolean doUpdate(E entity, int idValue) throws IllegalAccessException, SQLException {
        // UPDATE (table) SET (columns names) WHERE id = (id)
        String tableName = getTableName(entity);
        List<String> columnNames = getEntityColumns(entity);
        List<String> columnValues = getEntityValues(entity);

        List<String> updateColumns = new ArrayList<>();
        for (int i = 0; i < columnNames.size(); i++) {
            String formatted = String.format("%s=%s",
                    columnNames.get(i),
                    columnValues.get(i));

            updateColumns.add(formatted);
        }

        String updateSQLQuery = String.format("UPDATE %s SET %s WHERE id = %d",
                tableName,
                String.join(", ", updateColumns),
                idValue);

        int updateCount = connection.prepareStatement(updateSQLQuery).executeUpdate();

        return updateCount == 1;
    }

    private boolean doInsert(E entity) throws NoSuchFieldException, IllegalAccessException, SQLException {
        String tableName = getTableName(entity);
        List<String> columnNames = getEntityColumns(entity);
        List<String> columnValues = getEntityValues(entity);

        String insertSQLQuery = String.format("INSERT INTO %s (%s) VALUE (%s)",
                tableName,
                String.join(",", columnNames),
                String.join(",", columnValues));

        int insertResult = connection.prepareStatement(insertSQLQuery).executeUpdate();

        return insertResult == 1;
    }

    private List<String> getEntityValues(E entity) throws IllegalAccessException {
        List<String> columnValues = new ArrayList<String>();

        for (Field field : entity.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Column.class)) {
                field.setAccessible(true);
                columnValues.add("'" + field.get(entity).toString() + "'");
            }
        }

        return columnValues;
    }

    private List<String> getEntityColumns(E entity) {
        return Arrays
                .stream(entity.getClass().getDeclaredFields())
                .filter(f -> f.isAnnotationPresent(Column.class))
                .map(f -> f.getAnnotation(Column.class))
                .map(a -> a.name())
                .toList();


    }

    private String getTableName(E entity) {
        Entity annotation = entity.getClass().getAnnotation(Entity.class);

        if (annotation == null) {
            throw new IllegalArgumentException("Entity annotation missing!");
        }

        return annotation.name();
    }

    private int getId(E entity) throws IllegalAccessException {
        Field field = Arrays
                .stream(entity.getClass().getDeclaredFields())
                .filter(f -> f.isAnnotationPresent(Id.class))
                .findFirst()
                .orElseThrow(() -> new UnsupportedOperationException("Entity does not have a primary key"));

        field.setAccessible(true);
        return (int) field.get(entity);
    }

    @Override
    public Iterable<E> find(Class<E> table) {
        return null;
    }

    @Override
    public Iterable<E> find(Class<E> table, String where) {
        return null;
    }

    @Override
    public E findFirst(Class<E> table) {
        return null;
    }

    @Override
    public E findFirst(Class<E> table, String where) {
        return null;
    }
}
