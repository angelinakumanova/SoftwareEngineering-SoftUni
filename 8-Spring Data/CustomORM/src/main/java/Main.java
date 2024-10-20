import entities.User;
import orm.config.MyConnector;
import orm.context.EntityManager;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws SQLException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        MyConnector.createConnection("root", "123456aK", "mini_orm");

        Connection connection = MyConnector.getConnection();
        EntityManager<User> em = new EntityManager<>(connection);

        User user1 = new User("Marietta", 17, LocalDate.of(2024, 10, 15));
        User user2 = new User("Newton", 46, LocalDate.of(2024, 2, 2));
        User user3 = new User("Haskel", 52, LocalDate.of(2023, 12, 15));
        User user4 = new User("Brander", 15, LocalDate.of(2023, 10, 28));

        em.doCreate(User.class);

        em.persist(user1);
        em.persist(user2);
        em.persist(user3);
        em.persist(user4);


        Iterable<User> users = em.find(User.class, " age >= 18");
        for (User user : users) {
            System.out.println(user);
        }
    }
}
