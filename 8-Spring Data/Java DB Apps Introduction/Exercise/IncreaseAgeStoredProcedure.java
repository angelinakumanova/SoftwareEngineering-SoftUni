package JavaDBAppsIntroduction.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class IncreaseAgeStoredProcedure {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final Connection connection = new DBConnection("minions_db").getConnection();

    public static void main(String[] args) throws IOException, SQLException {
        int minionId = Integer.parseInt(reader.readLine());

        updateMinionAge(minionId);
        printMinion(minionId);
    }

    private static void updateMinionAge(int minionId) throws SQLException {
        CallableStatement callableStatement = connection.prepareCall("CALL usp_get_older(?)");
        callableStatement.setInt(1, minionId);
        callableStatement.executeUpdate();
    }

    private static void printMinion(int minionId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT name, age FROM minions WHERE id = ?");
        preparedStatement.setInt(1, minionId);
        ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();
        System.out.printf("%s %d%n", resultSet.getString("name"), resultSet.getInt("age"));

    }
}
