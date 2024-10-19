import entities.User;
import orm.config.MyConnector;
import orm.context.EntityManager;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws SQLException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        MyConnector.createConnection("root", "123456aK", "mini_orm");

        Connection connection = MyConnector.getConnection();
        EntityManager<User> em = new EntityManager(connection);

        User user1 = new User("pesho", 20, LocalDate.now());
        em.persist(user1);
        Iterable<User> users = em.find(User.class);

        users.forEach(System.out::println);

    }
}
