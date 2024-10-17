package JavaDBAppsIntroduction.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class AddMinion {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final Connection connection = new DBConnection("minions_db").getConnection();

    public static void main(String[] args) throws SQLException, IOException {

        String[] minionData = reader.readLine().split("\\s+");
        String[] villainData = reader.readLine().split("\\s+");

        String minionName = minionData[1];
        int minionAge = Integer.parseInt(minionData[2]);
        String town = minionData[3];
        int townId = getTownId(town);

        if(getTownId(town) == 0) {
            townId = createTown(town);
            System.out.printf("Town %s was added to the database.%n", town);
        }

        String villainName = villainData[1];
        int villainId = getVillainId(villainName);

        if(getVillainId(villainName) == 0) {
            villainId = createVillain(villainName);
            System.out.printf("Villain %s was added to the database.%n", villainName);
        }
        
        createMinion(minionName, minionAge, townId, villainName, villainId);

        connection.close();

    }

    private static void createMinion(String minionName, int age, int townId, String villainName, int villainId) throws SQLException {
        PreparedStatement preparedStatement = connection
                .prepareStatement("INSERT INTO minions (name, age, town_id) VALUE (?, ?, ?)");
        preparedStatement.setString(1, minionName);
        preparedStatement.setInt(2, age);
        preparedStatement.setInt(3, townId);
        preparedStatement.executeUpdate();

        PreparedStatement preparedStatement1 = connection.prepareStatement("INSERT INTO minions_villains VALUE (?, ?)");
        preparedStatement1.setInt(1, getMinionId(minionName));
        preparedStatement1.setInt(2, villainId);
        preparedStatement1.executeUpdate();

        System.out.printf("Successfully added %s to be minion of %s%n", minionName, villainName);
    }

    private static int getMinionId(String name) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT id FROM minions WHERE name = ?");
        preparedStatement.setString(1, name);

        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        return resultSet.getInt("id");
    }

    private static int createVillain(String villainName) throws SQLException {
        PreparedStatement preparedStatement = connection
                .prepareStatement("INSERT INTO villains (name, evilness_factor) VALUE(?, 'evil')");
        preparedStatement.setString(1, villainName);
        preparedStatement.executeUpdate();


        return getVillainId(villainName);
    }

    private static int getVillainId(String villainName) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT id FROM villains WHERE name = ?");
        preparedStatement.setString(1, villainName);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt("id");
        }

        return 0;
    }

    private static int createTown(String townName) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO towns (name) VALUE(?)");
        preparedStatement.setString(1, townName);
        preparedStatement.executeUpdate();

        return getTownId(townName);
    }

    private static int getTownId(String townName) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT id FROM towns WHERE name = ?");
        preparedStatement.setString(1, townName);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt("id");
        }

        return 0;
    }
}
