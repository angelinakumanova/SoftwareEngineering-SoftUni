package JavaDBAppsIntroduction.Lab;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        String password = scanner.nextLine();

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/diablo", username, password);

        String selectQuery = "SELECT u.user_name, u.first_name, u.last_name, COUNT(*) AS games_count FROM users u ";
        String joinQuery = "JOIN users_games ug ON u.id = ug.user_id ";
        String whereQuery = "WHERE u.user_name = ? ";
        String groupQuery = "GROUP BY u.id";
        String query = selectQuery + joinQuery + whereQuery + groupQuery;
        PreparedStatement stm = connection.prepareStatement(query);

        String searchedUsername = scanner.nextLine();
        stm.setString(1, searchedUsername);

        try {
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                System.out.printf("Username: %s | Games played: %d | First and last name: %s %s%n",
                        rs.getString("user_name"),
                        rs.getInt("games_count"),
                        rs.getString("first_name"),
                        rs.getString("last_name"));
            }

        } catch (SQLException e) {
            System.out.println("Such user doesn't exist");

        }
    }
}
