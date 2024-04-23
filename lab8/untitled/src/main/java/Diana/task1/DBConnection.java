package Diana.task1;

import Diana.task1.calculatorResult.CalculationResult;
import Diana.task1.calculatorResult.PrintingCalculationResult;

import java.sql.*;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/laborator";
    private static final String USER = "student";
    private static final String PASSWORD = "student";
    public DBConnection() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS smarterCalculatorResults (id INT auto_increment primary key, operation_type VARCHAR(20) NOT NULL, left_operand VARCHAR(254) NOT NULL, right_operand VARCHAR(254) NOT NULL, operation VARCHAR(2) NOT NULL, result VARCHAR(255) NOT NULL)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveCalculationResult(String operationType, Object leftOperand, Object rightOperand, String operation, Object result) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO smarterCalculatorResults(operation_type, left_operand, right_operand, operation, result) VALUES (?, ?, ?, ?, ?)")) {

            preparedStatement.setString(1, operationType);
            preparedStatement.setString(2, leftOperand.toString());
            preparedStatement.setString(3, rightOperand.toString());
            preparedStatement.setString(4, operation);
            preparedStatement.setString(5, result.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /////////////////////////////////
    //////Partea de cod pt task2/////
    /////////////////////////////////
    public void readAndPrintAllResults() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT operation_type, left_operand, right_operand, operation, result FROM smarterCalculatorResults");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String operationType = resultSet.getString("operation_type");
                String leftOperand = resultSet.getString("left_operand");
                String rightOperand = resultSet.getString("right_operand");
                String operation = resultSet.getString("operation");
                String result = resultSet.getString("result");

                CalculationRequest calculationRequest = new CalculationRequest(leftOperand, rightOperand, operation);

                new PrintingCalculationResult(new CalculationResult() {
                    @Override
                    public Object computeResult() {
                        return result;
                    }

                    @Override
                    public CalculationRequest getRequest() {
                        return calculationRequest;
                    }
                }).computeResult();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /////////////////////////////////
    //////Partea de cod pt task3/////
    /////////////////////////////////
    public void deleteResultsByOperationType(String operationType) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM smarterCalculatorResults WHERE operation_type = ?")) {

            preparedStatement.setString(1, operationType);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
