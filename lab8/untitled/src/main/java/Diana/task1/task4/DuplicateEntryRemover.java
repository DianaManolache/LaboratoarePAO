package Diana.task1.task4;

import java.sql.*;

public class DuplicateEntryRemover {

    private static final String URL = "jdbc:mysql://localhost:3306/laborator";
    private static final String USER = "student";
    private static final String PASSWORD = "student";

    public static void main(String[] args) {
        removeDuplicateEntries();
    }

    public static void removeDuplicateEntries() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String selectQuery = "SELECT * FROM smarterCalculatorResults";
            PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
            ResultSet resultSet = selectStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String operationType = resultSet.getString("operation_type");
                String leftOperand = resultSet.getString("left_operand");
                String rightOperand = resultSet.getString("right_operand");
                String operation = resultSet.getString("operation");
                String result = resultSet.getString("result");

                if (hasDuplicateEntry(connection, id, operationType, leftOperand, rightOperand, operation, result)) {
                    deleteEntry(connection, id);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static boolean hasDuplicateEntry(Connection connection, int id, String operationType, String leftOperand, String rightOperand, String operation, String result) throws SQLException {
        String selectQuery = "SELECT * FROM smarterCalculatorResults WHERE operation_type = ? AND left_operand = ? AND right_operand = ? AND operation = ? AND result = ?";
        PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
        selectStatement.setString(1, operationType);
        selectStatement.setString(2, leftOperand);
        selectStatement.setString(3, rightOperand);
        selectStatement.setString(4, operation);
        selectStatement.setString(5, result);
        ResultSet resultSet = selectStatement.executeQuery();

        int count = 0;
        while (resultSet.next()) {
            int currentId = resultSet.getInt("id");
            if (currentId != id) {
                count++;
            }
        }

        return count > 0;
    }

    private static void deleteEntry(Connection connection, int id) throws SQLException {
        String deleteQuery = "DELETE FROM smarterCalculatorResults WHERE id = ?";
        PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
        deleteStatement.setInt(1, id);
        deleteStatement.executeUpdate();
    }
}
