package JavaDBAppsIntroduction.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChangeTownNamesCasing {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final Connection connection = new DBConnection("minions_db").getConnection();

    public static void main(String[] args) throws IOException, SQLException {
        String country = reader.readLine();

        int updatedTowns = updateTowns(country);

        if(updatedTowns == 0) {
            System.out.println("No town names were affected.");
        } else {
            System.out.printf("%d town names were affected.\n", updatedTowns);
            printTowns(country);
        }

    }

    private static int updateTowns(String countryName) throws SQLException {
        PreparedStatement updateStatement = connection
                .prepareStatement("UPDATE towns SET name = UPPER(name) WHERE country = ?");
        updateStatement.setString(1, countryName);

        return updateStatement.executeUpdate();
    }

    private static void printTowns(String countryName) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM towns WHERE country = ?");
        statement.setString(1, countryName);

        ResultSet resultSet = statement.executeQuery();

        List<String> towns = new ArrayList<>();
        while (resultSet.next()) {
            towns.add(resultSet.getString("name"));
        }

        System.out.println("[" + String.join(", ", towns) + "]");
    }
}
