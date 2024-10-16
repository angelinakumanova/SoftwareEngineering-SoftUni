package JavaDBAppsIntroduction.Exercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class GetVillainsNames {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        String password = scanner.nextLine();

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", username, password);

        String query = "SELECT v.name, COUNT(*) AS minions_count FROM villains v " +
                        "JOIN minions_villains mv ON v.id = mv.villain_id " +
                        "GROUP BY v.name " +
                        "HAVING minions_count > 15 " +
                        "ORDER BY minions_count DESC;";

        ResultSet rs = connection.prepareStatement(query).executeQuery();

        while (rs.next()) {
            System.out.println(rs.getString("name") + " " + rs.getString("minions_count"));
        }
    }
}
