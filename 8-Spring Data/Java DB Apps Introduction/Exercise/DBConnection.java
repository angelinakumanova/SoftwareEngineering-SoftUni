package JavaDBAppsIntroduction.Exercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    private Connection connection;
    private String database;

    DBConnection(String database) {
        this.database = database;
    }

    public Connection getConnection() {
        String username = "root";
        String password = "";

        Properties props = new Properties();
        props.setProperty("user", username);
        props.setProperty("password", password);

        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + this.database, props);
        } catch (SQLException e) {
            System.out.println("Unable to connect to database");
            throw new RuntimeException(e);
        }

        return this.connection;
    }
}
