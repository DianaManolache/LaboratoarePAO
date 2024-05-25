package Library;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AutorRepository implements Repository<Autor> {
    private final Connection connection;

    public AutorRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Autor autor) {
        String sql = "INSERT INTO Autor (nume) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, autor.getNume());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                autor.setId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Autor findById(int id) {
        String sql = "SELECT * FROM Autor WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Autor(resultSet.getInt("id"), resultSet.getString("nume"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Autor> findAll() {
        List<Autor> autori = new ArrayList<>();
        String sql = "SELECT * FROM Autor";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                autori.add(new Autor(resultSet.getInt("id"), resultSet.getString("nume")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return autori;
    }

    @Override
    public void update(Autor autor) {
        String sql = "UPDATE Autor SET nume = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, autor.getNume());
            statement.setInt(2, autor.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Autor WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
