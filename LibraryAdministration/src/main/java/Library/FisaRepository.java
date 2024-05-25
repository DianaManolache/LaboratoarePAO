package Library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FisaRepository implements Repository<Fisa> {

    @Override
    public void save(Fisa fisa) {
        String query = "INSERT INTO Fisa (exemplar_id, data_imprumut, data_return) VALUES (?, ?, ?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, fisa.getExemplarId());
            preparedStatement.setDate(2, new java.sql.Date(fisa.getDataImprumut().getTime()));
            preparedStatement.setDate(3, new java.sql.Date(fisa.getDataReturn().getTime()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("A apărut o eroare la salvarea fișei: " + e.getMessage());
        }
    }

    @Override
    public Fisa findById(int id) {
        Fisa fisa = null;
        String query = "SELECT * FROM Fisa WHERE id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    fisa = new Fisa(
                            resultSet.getInt("id"),
                            resultSet.getInt("exemplar_id"),
                            resultSet.getDate("data_imprumut"),
                            resultSet.getDate("data_return")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("A apărut o eroare la găsirea fișei: " + e.getMessage());
        }
        return fisa;
    }

    @Override
    public List<Fisa> findAll() {
        List<Fisa> fise = new ArrayList<>();
        String query = "SELECT * FROM Fisa";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Fisa fisa = new Fisa(
                        resultSet.getInt("id"),
                        resultSet.getInt("exemplar_id"),
                        resultSet.getDate("data_imprumut"),
                        resultSet.getDate("data_return")
                );
                fise.add(fisa);
            }
        } catch (SQLException e) {
            System.out.println("A apărut o eroare la găsirea tuturor fișelor: " + e.getMessage());
        }
        return fise;
    }

    @Override
    public void update(Fisa fisa) {
        String query = "UPDATE Fisa SET exemplar_id = ?, data_imprumut = ?, data_return = ? WHERE id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, fisa.getExemplarId());
            preparedStatement.setDate(2, new java.sql.Date(fisa.getDataImprumut().getTime()));
            preparedStatement.setDate(3, new java.sql.Date(fisa.getDataReturn().getTime()));
            preparedStatement.setInt(4, fisa.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("A apărut o eroare la actualizarea fișei: " + e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM Fisa WHERE id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("A apărut o eroare la ștergerea fișei: " + e.getMessage());
        }
    }
}
