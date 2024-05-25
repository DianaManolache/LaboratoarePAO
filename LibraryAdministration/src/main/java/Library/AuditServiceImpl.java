package Library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuditServiceImpl implements AuditService {
    private Connection connection;

    public AuditServiceImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void logCommand(String command) {
        String insertCommand = "INSERT INTO CommandHistory (command_text) VALUES (?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertCommand)) {
            preparedStatement.setString(1, command);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> getCommandHistory() {
        List<String> commandHistory = new ArrayList<>();
        String selectCommand = "SELECT command_text FROM CommandHistory";
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectCommand)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String command = resultSet.getString("command_text");
                commandHistory.add(command);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return commandHistory;
    }
}
