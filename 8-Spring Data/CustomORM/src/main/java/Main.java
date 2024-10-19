import entities.User;
import orm.config.MyConnector;
import orm.context.EntityManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws SQLException, IllegalAccessException, NoSuchFieldException {
        MyConnector.createConnection("root", "123456aK", "mini_orm");

        Connection connection = MyConnector.getConnection();
        EntityManager<User> em = new EntityManager(connection);

        User user1 = new User("user", 25, LocalDate.now());

        System.out.println(em.persist(user1));
    }
}
