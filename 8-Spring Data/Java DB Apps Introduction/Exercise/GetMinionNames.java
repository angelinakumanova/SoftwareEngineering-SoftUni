package JavaDBAppsIntroduction.Exercise;

import java.sql.*;
import java.util.Scanner;

public class GetMinionNames {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        String password = scanner.nextLine();

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", username, password);

        String query = "SELECT v.name, m.name, m.age FROM minions_villains mv " +
                        "JOIN villains v ON mv.villain_id = v.id " +
                        "JOIN minions m ON mv.minion_id = m.id " +
                        "WHERE mv.villain_id = ?";

        PreparedStatement stm = connection.prepareStatement(query);

        int villainId = Integer.parseInt(scanner.nextLine());
        stm.setInt(1, villainId);

        try {
            ResultSet resultSet = stm.executeQuery();

            int count =  0;
            while (resultSet.next()) {
                if (count == 0) {
                    System.out.printf("Villain: %s%n", resultSet.getString("v.name"));
                }
                count++;
                System.out.printf("%d. %s %d %n", count, resultSet.getString("m.name"), resultSet.getInt("m.age"));
            }

        } catch (SQLException e) {
            System.out.printf("No villain with ID %d exists in the database.", villainId);
        }


    }
}
