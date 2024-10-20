package orm.context;

import orm.annotations.Column;
import orm.annotations.Entity;
import orm.annotations.Id;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EntityManager<E> implements DbContext<E> {
    private Connection connection;

    public EntityManager(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean persist(E entity) throws IllegalAccessException, SQLException {
        int idValue = getId(entity);

        if (idValue == 0) {
            return doInsert(entity);
        }


        return doUpdate(entity, idValue);
    }

    @Override
    public Iterable<E> find(Class<E> table) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return find(table, null);
    }

    @Override
    public Iterable<E> find(Class<E> table, String where) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String tableName = getTableName(table);
        String selectSQL = "SELECT * FROM " + tableName  + (where == null ? "" : " WHERE " + where);

        ResultSet resultSet = connection.prepareStatement(selectSQL).executeQuery();

        List<E> entities = new ArrayList<>();
        while (resultSet.next()) {
            entities.add(mapEntity(table, resultSet));
        }
        return entities;
    }

    @Override
    public E findFirst(Class<E> table) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return findFirst(table, null);
    }

    @Override
    public E findFirst(Class<E> table, String where) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Iterable<E> es = find(table, where);

        if (es.iterator().hasNext()) {
            return es.iterator().next();
        }
        return null;
    }

    @Override
    public void doCreate(Class<E> entityClass) throws SQLException {
        String tableName = getTableName(entityClass);
        String columnDefinitions = getColumnDefinitions(entityClass);

        String query = String.format("CREATE TABLE %s (%s);", tableName, columnDefinitions);

        connection.createStatement().execute(query);

        System.out.println(query);
    }

    private String getColumnDefinitions(Class<E> entityClass) {
        StringBuilder sb = new StringBuilder();

        Arrays.stream(entityClass.getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Id.class) || field.isAnnotationPresent(Column.class))
                .forEach(field -> {
                    String type = getFieldSQLType(field.getType());
                    if(field.getDeclaredAnnotations()[0].annotationType() == Id.class) {
                        sb.append("id " + type + " PRIMARY KEY AUTO_INCREMENT, " );
                        return;
                    }
                    String name = field.getAnnotation(Column.class).name();

                    sb.append(name + " ").append(type + ", ");
                });

        return sb.substring(0, sb.toString().lastIndexOf(","));
    }

    private String getFieldSQLType(Class<?> type) {
        if (type == int.class || type == Integer.class) {
            return "INT";
        } else if (type == String.class) {
            return "VARCHAR(255)";
        } else if (type == LocalDate.class) {
            return "DATE";
        }

        return "";
    }

    private boolean doUpdate(E entity, int idValue) throws IllegalAccessException, SQLException {
        // UPDATE (table) SET (columns names) WHERE id = (id)
        String tableName = getTableName(entity.getClass());
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

    private boolean doInsert(E entity) throws IllegalAccessException, SQLException {
        String tableName = getTableName(entity.getClass());
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

    private String getTableName(Class<?> entity) {
        Entity annotation = entity.getAnnotation(Entity.class);

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

    private E mapEntity(Class<E> type, ResultSet dbResult) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, SQLException {
        E result = type.getDeclaredConstructor().newInstance();

        for (Field field : type.getDeclaredFields()) {
            if (!field.isAnnotationPresent(Id.class) &&
                    !field.isAnnotationPresent(Column.class)) {
                continue;
            }

            result = mapField(result, field, dbResult);
        }

        return result;
    }

    private E mapField(E object, Field field, ResultSet dbResult) throws IllegalAccessException, SQLException {
        String column = "id";

        if (field.isAnnotationPresent(Column.class)) {
            column = field.getAnnotation(Column.class).name();
        }

        Object dbValue = mapValue(field, column, dbResult);

        field.setAccessible(true);
        field.set(object, dbValue);

        return object;
    }

    private Object mapValue(Field field, String column, ResultSet dbResult) throws SQLException {
        if (field.getType() == int.class || field.getType() == Integer.class) {
            return dbResult.getInt(column);
        } else if (field.getType() == String.class) {
            return dbResult.getString(column);
        } else if (field.getType() == LocalDate.class) {
            String date = dbResult.getString(column);

            return LocalDate.parse(date);
        }

        throw new IllegalArgumentException("Unsupported type " + field.getType());
    }
}
