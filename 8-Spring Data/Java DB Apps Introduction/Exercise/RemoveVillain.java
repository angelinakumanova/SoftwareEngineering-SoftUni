package JavaDBAppsIntroduction.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RemoveVillain {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final Connection connection = new DBConnection("minions_db").getConnection();

    public static void main(String[] args) throws IOException, SQLException {
        int villainId = Integer.parseInt(reader.readLine());

        if (villainExists(villainId)) {
            int removedMinions = deleteMinions(villainId);
            String villainName = getVillainName(villainId);
            deleteVillain(villainId);

            System.out.printf("%s was deleted\n" +
                            "%d minions released\n", villainName, removedMinions);
        } else {
            System.out.println("No such villain was found");
        }
    }

    private static String getVillainName(int villainId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT name FROM villains WHERE id = ?");
        preparedStatement.setInt(1, villainId);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        return resultSet.getString("name");
    }

    private static void deleteVillain(int villainId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM villains WHERE id = ?");
        preparedStatement.setInt(1, villainId);
        preparedStatement.executeUpdate();
    }

    private static int deleteMinions(int villainId) throws SQLException {
        PreparedStatement preparedStatement = connection
                .prepareStatement("DELETE FROM minions_villains WHERE villain_id = ?");
        preparedStatement.setInt(1, villainId);

        return preparedStatement.executeUpdate();
    }

    private static boolean villainExists(int villainId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM villains WHERE id = ?");
        preparedStatement.setInt(1, villainId);

        ResultSet resultSet = preparedStatement.executeQuery();

        return resultSet.next();
    }
}
