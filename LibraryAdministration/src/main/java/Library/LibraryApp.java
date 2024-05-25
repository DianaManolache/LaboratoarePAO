package Library;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class LibraryApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final UserRepository userRepository = new UserRepository();
    //private static final CarteRepository carteRepository = new CarteRepository();
    //private static final AuditService auditService = new AuditServiceImpl();

    public static void main(String[] args) throws SQLException {
        adaugaAdministratoriDinFisier("admin_data");
        afiseazaMeniu();
    }

    private static void adaugaAdministratoriDinFisier(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("%");
                if (parts.length == 3) {
                    String username = parts[0];
                    String password = parts[1];
                    boolean isAdmin = Boolean.parseBoolean(parts[2]);

                    if (userRepository.findByUsername(username) == null) {
                        User user = new User(0, username, password, isAdmin); // id-ul auto-incrementat in bd
                        userRepository.save(user);
                        System.out.println("Administrator " + username + " adaugat cu succes.");
                    } else {
                        System.out.println("Administratorul " + username + " exista deja.");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void afiseazaMeniu() throws SQLException {
        System.out.println("-----------BINE ATI VENIT!-----------\n");
        System.out.println("Acesta este site-ul de administrare al bibliotecii Libris.\n");
        System.out.println("Operatiile disponibile utilizatorului difera astfel:");
        System.out.println("---Administrator: adauga, modifica, vizualizeaza sau sterge carti, autori, cititori, sectiuni");
        System.out.println("---Cititor: vizualizeaza carti, autori, sectiuni\n");
        System.out.println("0) Pentru a parasi site-ul, apasati tasta 0.");
        System.out.println("1) Pentru a merge mai departe, apasati tasta 1.");
        System.out.println("2) Daca apasati orice alta tasta, nu se va intampla nimic.");
        System.out.print("Tasta: ");
        String choice = scanner.nextLine();
        switch (choice) {
            case "0":
                System.out.print("\nLa revedere!");
                System.exit(0);
            case "1":
                meniuLogare();
                break;
            default:
                afiseazaMeniu();
                break;
        }
    }

    public static void meniuLogare() throws SQLException {
        System.out.println("\n-------Meniu logare-------");
        System.out.println("0) Pentru a parasi site-ul, apasati tasta 0.");
        System.out.println("1) Pentru conectare, apasati tasta 1.");
        System.out.println("2) Pentru inregistrare, apasati tasta 2.");
        System.out.println(" In cazul in care apasati orice alta tasta, pagina se reincarca.");
        System.out.print("Tasta: ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "0":
                System.out.print("\nLa revedere!");
                System.exit(0);
            case "1":
                login();
                break;
            case "2":
                register();
                break;
            default:
                System.out.print(" Tasta gresita. Reincercati.");
                meniuLogare();
                break;
        }
    }

    private static void login() throws SQLException {
        System.out.println("\n-------Logare-------");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Autentificare reușită! Bine ai venit, " + username + "!");
            //auditService.logCommand("login: " + username);

            if (user.isAdmin()) {
                afiseazaMeniuAdmin();
            } else {
                afiseazaMeniuCititor();
            }
        } else {
            System.out.println("Username sau parola incorecte. Vă rugăm să încercați din nou.");
            meniuLogare();
        }
    }

    private static void register() throws SQLException {
        System.out.println("\n-------Inregistrare-------");
        System.out.print("Alegeți un username: ");
        String username = scanner.nextLine();
        System.out.print("Alegeți o parolă: ");
        String password = scanner.nextLine();

        if (userRepository.findByUsername(username) == null) {
            User user = new User(0, username, password, false); // id-ul este auto-incrementat în baza de date
            userRepository.save(user);
            System.out.println("Înregistrare reușită! Acum vă puteți autentifica.");
            meniuLogare();
        } else {
            System.out.println("Username-ul există deja. Vă rugăm să alegeți altul.");
            meniuLogare();
        }
    }

    private static void afiseazaMeniuAdmin() throws SQLException {
        System.out.println("\n--- Meniu Administrator ---");
        System.out.println("Pentru operatii ce tin de:");
        System.out.println("0) parasirea site-ului, apasati tasta 0;");
        System.out.println("1) carti, apasati tasta 1;");
        System.out.println("2) autori, apasati tasta 2;");
        System.out.println("3) cititori, apasati tasta 3.");
        System.out.println("4) Pentru a va deconecta, apasati tasta 4.");
        System.out.println(" In cazul in care apasati gresit, pagina va ramane aceeasi.");
        System.out.print("Tasta: ");
        String choice = scanner.nextLine();
        switch (choice) {
            case "0":
                System.out.print("\nLa revedere!");
                System.exit(0);
            case "1":
                operatiiCartiAdmin();
                break;
            case "2":
                operatiiAutoriAdmin();
                break;
            case "3":
                operatiiCititoriAdmin();
                break;
            case "4":
                System.out.println("\nDeconectat cu succes!\n");
                afiseazaMeniu();
                break;
            default:
                System.out.print("\nTasta gresita. Reincearca.");
                afiseazaMeniuAdmin();
                break;
        }
    }

    private static void afiseazaMeniuCititor() throws SQLException {
        System.out.println("\n--- Meniu Cititor ---");
        System.out.println("Pentru operatii ce tin de:");
        System.out.println("0) parasirea site-ului, apasati tasta 0;");
        System.out.println("1) carti, apasati tasta 1;");
        System.out.println("2) autori, apasati tasta 2.");
        System.out.println("3) Pentru a va deconecta, apasati tasta 3.");
        System.out.println(" In cazul in care apasati gresit, pagina va ramane aceeasi.");
        System.out.print("Tasta: ");
        String choice = scanner.nextLine();
        switch (choice) {
            case "0":
                System.out.print("\nLa revedere!");
                System.exit(0);
            case "1":
                operatiiCartiUser();
                break;
            case "2":
                operatiiAutoriUser();
                break;
            case "3":
                System.out.println("\nDeconectat cu succes!\n");
                afiseazaMeniu();
                break;
            default:
                System.out.print("\nTasta gresita. Reincearca.");
                afiseazaMeniuCititor();
                break;
        }
    }
    private static void operatiiCartiAdmin() throws SQLException {
        System.out.println("\n--- Carti ---");
        System.out.println("0) Pentru parasirea site-ului, apasati tasta 0.");
        System.out.println("1) Pentru a va intoarce la pagina anterioara, apasati tasta 1.");
        System.out.println("2) Pentru a vizualiza toate cartile imprumutate intr-un interval de timp, apasati tasta 2.");
        System.out.println("3) Pentru a vizualiza toate cartile disponibile, apasati tasta 3.");
        System.out.println("4) Pentru a vizualiza fisele tuturor exemplarelor unei carti, apasati tasta 4.");
        System.out.println("5) Pentru a vizualiza locatia unei carti, apasati tasta 5.");
        System.out.println("6) Pentru a vizualiza TOATE cartile, apasati tasta 6.");
        System.out.println("7) Pentru a adauga o locatie, apasati tasta 7.");
        System.out.println("8) Pentru a adauga o carte, apasati tasta 8.");
        System.out.println("9) Pentru a adauga un exemplar, apasati tasta 9.");
        System.out.println("10) Pentru a modifica o locatie, apasati tasta 10.");
        System.out.println("11) Pentru a modifica o carte, apasati tasta 11.");
        System.out.println("12) Pentru a modifica un exemplar, apasati tasta 12.");
        System.out.println("13) Pentru a modifica datele unei fise, apasati tasta 13.");
        System.out.println("14) Pentru a sterge o locatie, apasati tasta 14.");
        System.out.println("15) Pentru a sterge o carte, apasati tasta 15.");
        System.out.println("16) Pentru a sterge un exemplar, apasati tasta 16.");
        System.out.println("17) Pentru a va deconecta, apasati tasta 17.");
        System.out.println(" In cazul in care apasati gresit, pagina va ramane aceeasi.");
        System.out.print("Tasta: ");
        String choice = scanner.nextLine();
        CarteServiceForAdmin carteServiceForAdmin = new CarteServiceForAdmin();
        switch (choice) {
            case "0":
                System.out.print("\nLa revedere!");
                System.exit(0);
            case "1":
                afiseazaMeniuAdmin();
                break;
            case "2":
                carteServiceForAdmin.vizualizareCartileImprumutate();
                operatiiCartiAdmin();
                break;
            case "3":
                carteServiceForAdmin.vizualizareCartileDisponibile();
                operatiiCartiAdmin();
                break;
            case "4":
                carteServiceForAdmin.vizualizareFiseleExemplarelor();
                operatiiCartiAdmin();
                break;
            case "5":
                carteServiceForAdmin.vizualizareLocatieCarte();
                operatiiCartiAdmin();
                break;
            case "6":
                carteServiceForAdmin.vizualizareToateCartile();
                operatiiCartiAdmin();
                break;
            case "7":
                carteServiceForAdmin.adaugareLocatie();
                operatiiCartiAdmin();
                break;
            case "8":
                carteServiceForAdmin.adaugareCarte();
                operatiiCartiAdmin();
                break;
//            case "9":
//                carteServiceForAdmin.adaugareExemplar();
//                operatiiCartiAdmin();
//                break;
            case "10":
                carteServiceForAdmin.modificareLocatie();
                operatiiCartiAdmin();
                break;
            case "11":
                carteServiceForAdmin.modificareCarte();
                operatiiCartiAdmin();
                break;
            case "12":
                carteServiceForAdmin.modificareExemplar();
                operatiiCartiAdmin();
                break;
            case "13":
                carteServiceForAdmin.modificareFisa();
                operatiiCartiAdmin();
                break;
            case "14":
                carteServiceForAdmin.stergereLocatie();
                operatiiCartiAdmin();
                break;
            case "15":
                carteServiceForAdmin.stergereCarte();
                operatiiCartiAdmin();
                break;
            case "16":
                carteServiceForAdmin.stergereExemplar();
                operatiiCartiAdmin();
                break;
            case "17":
                System.out.println("\nDeconectat cu succes!\n");
                afiseazaMeniu();
                break;
            default:
                System.out.print("\nTasta gresita. Reincearca.");
                afiseazaMeniuAdmin();
                break;
        }
    }

    private static void operatiiAutoriAdmin() throws SQLException {
        System.out.println("\n--- Autori ---");
        System.out.println("0) Pentru parasirea site-ului, apasati tasta 0.");
        System.out.println("1) Pentru a va intoarce la pagina anterioara, apasati tasta 1.");
        System.out.println("2) Pentru a vizualiza toti autorii, apasati tasta 2.");
        System.out.println("3) Pentru a vizualiza toate cartile de la un autor, apasati tasta 3.");
        System.out.println("4) Pentru a vizualiza unde gasesc cartile unui autor, apasati tasta 4.");
        System.out.println("5) Pentru a adauga un autor, apasati tasta 5.");
        System.out.println("6) Pentru a a sterge un autor, apasati tasta 6.");
        System.out.println("7) Pentru a modifica un autor, apasati tasta 7.");
        System.out.println("8) Pentru a va decontecta, apasati tasta 8.");
        System.out.println(" In cazul in care apasati gresit, pagina va ramane aceeasi.");
        System.out.print("Tasta: ");
        String choice = scanner.nextLine();
        AutorServiceForAdmin autorServiceForAdmin = new AutorServiceForAdmin();
        switch (choice) {
            case "0":
                System.out.print("\nLa revedere!");
                System.exit(0);
            case "1":
                afiseazaMeniuAdmin();
                break;
            case "2":
                autorServiceForAdmin.vizualizareAutori();
                operatiiAutoriAdmin();
                break;
            case "3":
                autorServiceForAdmin.vizualizareToateCartileUnuiAutor();
                operatiiAutoriAdmin();
                break;
            case "4":
                autorServiceForAdmin.vizualizareUndeGasescCartileUnuiAutor();
                operatiiAutoriAdmin();
                break;
            case "5":
                autorServiceForAdmin.adaugareAutor();
                operatiiAutoriAdmin();
                break;
            case "6":
                autorServiceForAdmin.stergereAutor();
                operatiiAutoriAdmin();
                break;
            case "7":
                autorServiceForAdmin.modificareAutor();
                operatiiAutoriAdmin();
                break;
            case "8":
                System.out.println("\nDeconectat cu succes!\n");
                afiseazaMeniu();
                break;
            default:
                System.out.print("\nTasta gresita. Reincearca.");
                afiseazaMeniuCititor();
                break;
        }

    }

    private static void operatiiCititoriAdmin() throws SQLException {
        System.out.println("\n--- Cititori ---");
        System.out.println("0) Pentru parasirea site-ului, apasati tasta 0.");
        System.out.println("1) Pentru a va intoarce la pagina anterioara, apasati tasta 1.");
        System.out.println("2) Pentru a vizualiza toti cititorii, apasati tasta 2.");
        System.out.println("3) Pentru a vizualiza cartile care nu au fost inca aduse inapoi, desi ar fi trebuit, apasati tasta 3.");
        System.out.println("4) Pentru a adauga un cititor, apasati tasta 4.");
        System.out.println("5) Pentru a sterge un cititor, apasati tasta 5.");
        System.out.println("6) Pentru a modifica un cititor, apasati tasta 6.");
        System.out.println("7) Pentru a modifica datele dintr-o fisa, apasati tasta 7.");
        System.out.println("8) Pentru a va deconecta, apasati tasta 8.");
        System.out.println(" In cazul in care apasati gresit, pagina va ramane aceeasi.");
        System.out.print("Tasta: ");
        String choice = scanner.nextLine();
        UserServiceForAdmin userServiceForAdmin = new UserServiceForAdmin();
        switch (choice) {
            case "0":
                System.out.print("\nLa revedere!");
                System.exit(0);
            case "1":
                afiseazaMeniuAdmin();
                break;
            case "2":
                userServiceForAdmin.vizualizareCititori();
                operatiiCititoriAdmin();
                break;
            case "3":
                userServiceForAdmin.vizualizareRestantieri();
                operatiiCititoriAdmin();
                break;
            case "4":
                userServiceForAdmin.adaugareCititor();
                operatiiCititoriAdmin();
                break;
            case "5":
                userServiceForAdmin.stergereCititor();
                operatiiCititoriAdmin();
                break;
            case "6":
                userServiceForAdmin.modificareCititor();
                operatiiCititoriAdmin();
                break;
            case "7":
                userServiceForAdmin.modificareDateFisa();
                operatiiCititoriAdmin();
                break;
            case "8":
                System.out.println("\nDeconectat cu succes!\n");
                afiseazaMeniu();
                break;
            default:
                System.out.print("\nTasta gresita. Reincearca.");
                afiseazaMeniuCititor();
                break;
        }
    }
    private static void operatiiCartiUser() throws SQLException {
        System.out.println("\n--- Carti ---");
        System.out.println("0) Pentru parasirea site-ului, apasati tasta 0.");
        System.out.println("1) Pentru a va intoarce la pagina anterioara, apasati tasta 1.");
        System.out.println("2) Pentru a vizualiza toate cartile imprumutate intr-un interval de timp, apasati tasta 2.");
        System.out.println("3) Pentru a vizualiza toate cartile disponibile, apasati tasta 3.");
        System.out.println("4) Pentru a vizualiza fisele tuturor exemplarelor unei carti, apasati tasta 4.");
        System.out.println("5) Pentru a vizualiza locatia unei carti, apasati tasta 5.");
        System.out.println("6) Pentru a vizualiza TOATE cartile, apasati tasta 6.");
        System.out.println("7) Pentru a va deconecta, apasati tasta 7.");
        System.out.println(" In cazul in care apasati gresit, pagina va ramane aceeasi.");
        System.out.print("Tasta: ");
        String choice = scanner.nextLine();
        CarteServiceForUser carteServiceForUser = new CarteServiceForUser() {
            @Override
            void adaugareLocatie() {

            }

            @Override
            void adaugareCarte() {

            }

            @Override
            void adaugareExemplar() {

            }

            @Override
            void stergereLocatie() {

            }

            @Override
            void stergereCarte() {

            }

            @Override
            void stergereExemplar() {

            }

            @Override
            void modificareLocatie() {

            }

            @Override
            void modificareCarte() {

            }

            @Override
            void modificareExemplar() {

            }

            @Override
            void modificareFisa() {

            }
        };
        switch (choice) {
            case "0":
                System.out.print("\nLa revedere!");
                System.exit(0);
            case "1":
                afiseazaMeniuCititor();
                break;
            case "2":
                carteServiceForUser.vizualizareCartileImprumutate();
                operatiiCartiUser();
                break;
            case "3":
                carteServiceForUser.vizualizareCartileDisponibile();
                operatiiCartiUser();
                break;
            case "4":
                carteServiceForUser.vizualizareFiseleExemplarelor();
                operatiiCartiUser();
                break;
            case "5":
                carteServiceForUser.vizualizareLocatieCarte();
                operatiiCartiUser();
                break;
            case "6":
                carteServiceForUser.vizualizareToateCartile();
                operatiiCartiUser();
                break;
            case "7":
                System.out.println("\nDeconectat cu succes!\n");
                afiseazaMeniu();
                break;
            default:
                System.out.print("\nTasta gresita. Reincearca.");
                afiseazaMeniuCititor();
                break;
        }
    }
    private static void operatiiAutoriUser() throws SQLException {
        System.out.println("\n--- Autori ---");
        System.out.println("0) Pentru parasirea site-ului, apasati tasta 0.");
        System.out.println("1) Pentru a vizualiza toti autorii, apasati tasta 1.");
        System.out.println("2) Pentru a vizualiza toate cartile de la un autor, apasati tasta 2.");
        System.out.println("3) Pentru a vizualiza unde gasesc cartile unui autor, apasati tasta 3.");
        System.out.println("4) Pentru a va deconecta, apasati tasta 4.");
        System.out.println(" In cazul in care apasati gresit, pagina va ramane aceeasi.");
        System.out.print("Tasta: ");
        String choice = scanner.nextLine();
        AutorServiceForUser autorServiceForUser = new AutorServiceForUser() {
            @Override
            void adaugareAutor() {

            }

            @Override
            void stergereAutor() {

            }

            @Override
            void modificareAutor() {

            }
        };
        switch (choice) {
            case "0":
                System.out.print("\nLa revedere!");
                System.exit(0);
            case "1":
                afiseazaMeniuCititor();
                break;
            case "2":
                autorServiceForUser.vizualizareToateCartileUnuiAutor();
                operatiiAutoriUser();
                break;
            case "3":
                autorServiceForUser.vizualizareUndeGasescCartileUnuiAutor();
                operatiiAutoriUser();
                break;
            case "4":
                System.out.println("\nDeconectat cu succes!\n");
                afiseazaMeniu();
                break;
            default:
                System.out.print("\nTasta gresita. Reincearca.");
                operatiiAutoriUser();
                break;
        }

    }
}