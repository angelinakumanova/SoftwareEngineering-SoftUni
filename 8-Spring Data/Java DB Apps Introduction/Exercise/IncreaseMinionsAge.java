package JavaDBAppsIntroduction.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IncreaseMinionsAge {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final Connection connection = new DBConnection("minions_db").getConnection();

    public static void main(String[] args) throws IOException, SQLException {
        String[] minionIds = reader.readLine().split("\\s+");

        updateMinions(minionIds);
        printMinions();
    }

    private static void printMinions() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM minions");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.printf("%s %d%n", resultSet.getString("name"), resultSet.getInt("age"));
        }
    }

    private static void updateMinions(String[] minionIds) throws SQLException {
        PreparedStatement preparedStatement = connection
                .prepareStatement("UPDATE minions SET name = LOWER(name), age = age + 1 WHERE id = ?");

        for (String minionId : minionIds) {
            int id = Integer.parseInt(minionId);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }
    
    
}
