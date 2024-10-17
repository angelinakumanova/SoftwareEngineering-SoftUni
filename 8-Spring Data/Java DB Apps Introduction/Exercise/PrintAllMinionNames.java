package JavaDBAppsIntroduction.Exercise;

import java.sql.*;

public class PrintAllMinionNames {
    private static final Connection connection = new DBConnection("minions_db").getConnection();

    public static void main(String[] args) throws SQLException {
        printMinions();
    }

    private static void printMinions() throws SQLException {
        PreparedStatement preparedStatement = connection
                .prepareStatement("SELECT name FROM minions",
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = preparedStatement.executeQuery();

        int startPointer = 1;
        resultSet.last();
        int endPointer = resultSet.getRow();

        while (startPointer <= endPointer) {
            if (startPointer <= endPointer) {
                resultSet.absolute(startPointer);
                System.out.println(resultSet.getString(1));
                startPointer++;
            }

            if (endPointer > startPointer) {
                resultSet.absolute(endPointer);
                System.out.println(resultSet.getString(1));
                endPointer--;
            }

        }
    }
}
