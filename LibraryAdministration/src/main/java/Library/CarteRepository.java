package Library;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarteRepository implements Repository<Carte> {

    private final Connection connection;
    Connection newConnection = DBConnection.getConnection();
    CarteRepository carteRepository = new CarteRepository(newConnection);


    public CarteRepository(Connection connection) throws SQLException {
        this.connection = connection;
    }

    public List<Carte> findAll() {
        List<Carte> carti = new ArrayList<>();
        String query = "SELECT * FROM Carte";
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Carte carte = new Carte(
                        resultSet.getInt("id"),
                        resultSet.getString("nume"),
                        resultSet.getInt("autor_id"),
                        resultSet.getInt("sectiune_id"),
                        resultSet.getInt("nr_exemplare_totale")
                );
                carti.add(carte);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carti;
    }

    public List<Carte> imprumutataDeLaData1LaData2(Date startDate, Date endDate) {
        List<Carte> carti = new ArrayList<>();
        String query = "SELECT c.* FROM Carte c " +
                "JOIN Exemplar e ON c.id = e.carte_id " +
                "WHERE e.disponibil = true " +
                "AND NOT EXISTS (" +
                "   SELECT 1 FROM Fisa f " +
                "   WHERE f.exemplar_id = e.id " +
                "   AND f.data_imprumut BETWEEN ? AND ?" +
                ")";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDate(1, startDate);
            preparedStatement.setDate(2, endDate);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Carte carte = new Carte(
                            resultSet.getInt("id"),
                            resultSet.getString("nume"),
                            resultSet.getInt("autor_id"),
                            resultSet.getInt("sectiune_id"),
                            resultSet.getInt("nr_exemplare_totale")
                    );
                    carti.add(carte);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carti;
    }


    public List<Carte> cartileDisponibile() {
        List<Carte> carti = new ArrayList<>();
        String query = "SELECT * FROM Carte WHERE nr_exemplare_totale > 0";
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Carte carte = new Carte(
                        resultSet.getInt("id"),
                        resultSet.getString("nume"),
                        resultSet.getInt("autor_id"),
                        resultSet.getInt("sectiune_id"),
                        resultSet.getInt("nr_exemplare_totale")
                );
                carti.add(carte);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carti;
    }

    public List<Fisa> fiseleCartii(String denumireCarte) {
        List<Fisa> fise = new ArrayList<>();
        String query = "SELECT f.* FROM Fisa f " +
                "JOIN Exemplar e ON f.exemplar_id = e.id " +
                "JOIN Carte c ON e.carte_id = c.id " +
                "WHERE c.nume = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, denumireCarte);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Fisa fisa = new Fisa(
                            resultSet.getInt("id"),
                            resultSet.getInt("exemplar_id"),
                            resultSet.getDate("data_imprumut"),
                            resultSet.getDate("data_return")
                    );
                    fise.add(fisa);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fise;
    }

    public List<String> gasesteLocatieDupaDenumire(String numeAutor) {
        List<String> locatii = new ArrayList<>();
        String sql = "SELECT sectiune FROM Carte WHERE autor_id = (SELECT id FROM Autor WHERE nume = ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, numeAutor);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                locatii.add(resultSet.getString("sectiune"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return locatii;
    }

    @Override
    public void save(Carte carte) {
        String query = "INSERT INTO Carte (denumire, autor_id, sectiune_id, nr_exemplare_totale) VALUES (?, ?, ?, ?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, carte.getDenumire());
            preparedStatement.setInt(2, carte.getAutorId());
            preparedStatement.setInt(3, carte.getSectiuneId());
            preparedStatement.setInt(4, carte.getNrTotalExemplare());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("A apărut o eroare la salvarea cărții: " + e.getMessage());
        }
    }

    @Override
    public Carte findById(int id) {
        return null;
    }
    public List<Carte> gasesteDupaAutor(String numeAutor) {
        List<Carte> carti = new ArrayList<>();
        String sql = "SELECT * FROM Carte WHERE autor_id = (SELECT id FROM Autor WHERE nume = ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, numeAutor);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idCarte = resultSet.getInt("id");
                String numeCarte = resultSet.getString("nume");
                Carte carte = new Carte(idCarte, numeCarte);
                carti.add(carte);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carti;
    }

    @Override
    public void update(Carte carte) {
        String query = "UPDATE Carte SET nume = ?, autor_id = ?, sectiune_id = ?, nr_exemplare_totale = ? WHERE id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, carte.getDenumire());
            preparedStatement.setInt(2, carte.getAutorId());
            preparedStatement.setInt(3, carte.getSectiuneId());
            preparedStatement.setInt(4, carte.getNrTotalExemplare());
            preparedStatement.setInt(5, carte.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("A apărut o eroare la actualizarea cărții: " + e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM Carte WHERE id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("A apărut o eroare la ștergerea cărții: " + e.getMessage());
        }
    }

    public void saveSectiune(Sectiune sectiune) throws SQLException {
        String query = "INSERT INTO Sectiune (denumire, sala, rand, coloana, raft) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, sectiune.getDenumire());
            preparedStatement.setString(2, sectiune.getSala());
            preparedStatement.setInt(3, sectiune.getRand());
            preparedStatement.setInt(4, sectiune.getColoana());
            preparedStatement.setInt(5, sectiune.getRaft());
            preparedStatement.executeUpdate();
        }
    }

    public void updateSectiune(Sectiune sectiune) throws SQLException {
        String query = "UPDATE Sectiune SET denumire = ?, sala = ?, rand = ?, coloana = ?, raft = ? WHERE id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, sectiune.getDenumire());
            preparedStatement.setString(2, sectiune.getSala());
            preparedStatement.setInt(3, sectiune.getRand());
            preparedStatement.setInt(4, sectiune.getColoana());
            preparedStatement.setInt(5, sectiune.getRaft());
            preparedStatement.setInt(6, sectiune.getId());
            preparedStatement.executeUpdate();
        }
    }

    public void deleteSectiune(int id) throws SQLException {
        String query = "DELETE FROM Sectiune WHERE id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

    public void saveExemplar(Exemplar exemplar) throws SQLException {
        PreparedStatement statement = null;
        ResultSet generatedKeys = null;
        String query = "INSERT INTO exemplare (carte_id, disponibil) VALUES (?, ?)";
        try {
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, exemplar.getCarteId());
            statement.setBoolean(2, exemplar.isDisponibil());
            statement.executeUpdate();
            generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);
                exemplar.setId(id);
            }
        } finally {
            if (generatedKeys != null) {
                generatedKeys.close();
            }
            if (statement != null) {
                statement.close();
            }
        }
    }



    public void updateExemplar(Exemplar exemplar) throws SQLException {
        String query = "UPDATE Exemplar SET carte_id = ?, disponibil = ? WHERE id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, exemplar.getCarteId());
            preparedStatement.setBoolean(2, exemplar.isDisponibil());
            preparedStatement.setInt(3, exemplar.getId());
            preparedStatement.executeUpdate();
        }
    }

    public void deleteExemplar(int id) throws SQLException {
        String query = "DELETE FROM Exemplar WHERE id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

    public void updateFisa(Fisa fisa) throws SQLException {
        String query = "UPDATE Fisa SET exemplar_id = ?, data_imprumut = ?, data_return = ? WHERE id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, fisa.getExemplarId());
            preparedStatement.setDate(2, new java.sql.Date(fisa.getDataImprumut().getTime()));
            preparedStatement.setDate(3, new java.sql.Date(fisa.getDataReturn().getTime()));
            preparedStatement.setInt(4, fisa.getId());
            preparedStatement.executeUpdate();
        }
    }
}
