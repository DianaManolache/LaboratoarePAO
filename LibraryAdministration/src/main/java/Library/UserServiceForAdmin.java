package Library;

import java.sql.*;
import java.util.Scanner;

public class UserServiceForAdmin implements UserService {
    @Override
    public void vizualizareCititori() {
        String query = "SELECT id, username FROM User WHERE is_admin = FALSE";
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            System.out.println("Cititori:");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") + ", Username: " + resultSet.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void vizualizareRestantieri() {
        String query = "SELECT DISTINCT u.id, u.username " +
                "FROM User u " +
                "JOIN UserFisa uf ON u.id = uf.user_id " +
                "JOIN Fisa f ON uf.fisa_id = f.id " +
                "WHERE f.data_return IS NULL AND f.data_imprumut < DATE_SUB(CURDATE(), INTERVAL 30 DAY)";
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            if (!resultSet.isBeforeFirst()) {
                System.out.println("Nu există restanțieri.");
            } else {
                System.out.println("Restanțieri:");
                while (resultSet.next()) {
                    System.out.println("ID: " + resultSet.getInt("id") + ", Username: " + resultSet.getString("username"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void adaugareCititor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        UserRepository userRepository = new UserRepository();
        User existingUser = userRepository.findByUsername(username);
        if (existingUser != null) {
            System.out.println("Un utilizator cu acest username există deja.");
        } else {
            User newUser = new User(username, password, false);
            userRepository.save(newUser);
            System.out.println("Cititor adăugat cu succes.");
        }
    }


    @Override
    public void stergereCititor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID cititor: ");
        int id = scanner.nextInt();

        UserRepository userRepository = new UserRepository();
        userRepository.delete(id);

        System.out.println("Cititor șters cu succes.");
    }

    @Override
    public void modificareCititor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID cititor: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Username nou: ");
        String newUsername = scanner.nextLine();
        System.out.print("Password nou: ");
        String newPassword = scanner.nextLine();

        User user = new User(id, newUsername, newPassword, false);
        UserRepository userRepository = new UserRepository();
        userRepository.update(user);

        System.out.println("Cititor modificat cu succes.");
    }

    @Override
    public void modificareDateFisa() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID fisa: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Data imprumut (YYYY-MM-DD): ");
        String dataImprumut = scanner.nextLine();
        System.out.print("Data return (YYYY-MM-DD): ");
        String dataReturn = scanner.nextLine();

        String query = "UPDATE Fisa SET data_imprumut = ?, data_return = ? WHERE id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setDate(1, Date.valueOf(dataImprumut));
            statement.setDate(2, Date.valueOf(dataReturn));
            statement.setInt(3, id);
            statement.executeUpdate();

            System.out.println("Fișa modificată cu succes.");
        } catch (IllegalArgumentException e) {
            System.out.println("Data introdusă este greșită. Te rog să reîncerci.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
