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

        User user1 = new User("pesho", 25, LocalDate.now());
        user1.setId(1);

        System.out.println(em.persist(user1));
    }
}
