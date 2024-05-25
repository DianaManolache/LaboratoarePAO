package Library;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


public class AutorServiceForAdmin extends AutorServiceForUser {
    private final AutorRepository autorRepository;
    private final CarteRepository carteRepository;
    private final Scanner scanner;
    public AutorServiceForAdmin() throws SQLException {
        Connection connection = DBConnection.getConnection();
        this.autorRepository = new AutorRepository(connection);
        this.carteRepository = new CarteRepository(connection);
        this.scanner = new Scanner(System.in);
    }

    public AutorServiceForAdmin(AutorRepository autorRepository, CarteRepository carteRepository, Scanner scanner) {
        this.autorRepository = autorRepository;
        this.carteRepository = carteRepository;
        this.scanner = scanner;
    }

    @Override
    public void vizualizareAutori() {
        List<Autor> autori = autorRepository.findAll();
        if (autori.isEmpty()) {
            System.out.println("Nu există autori în bibliotecă.");
        } else {
            System.out.println("--- Lista de autori ---");
            for (Autor autor : autori) {
                System.out.println(autor);
            }
        }
    }

    @Override
    public void vizualizareToateCartileUnuiAutor() {
        System.out.print("Introduceți ID-ul autorului: ");
        int idAutor = Integer.parseInt(scanner.nextLine());
        Autor autor = autorRepository.findById(idAutor);
        if (autor == null) {
            System.out.println("Autorul cu ID-ul " + idAutor + " nu există.");
        } else {
            List<Carte> carti = carteRepository.gasesteDupaAutor(autor.getNume());
            if (carti.isEmpty()) {
                System.out.println("Autorul nu are cărți în bibliotecă.");
            } else {
                System.out.println("--- Cărțile autorului " + autor.getNume() + " ---");
                for (Carte carte : carti) {
                    System.out.println(carte);
                }
            }
        }
    }

    @Override
    public void vizualizareUndeGasescCartileUnuiAutor() {
        System.out.print("Introduceți ID-ul autorului: ");
        int idAutor = Integer.parseInt(scanner.nextLine());
        Autor autor = autorRepository.findById(idAutor);
        if (autor == null) {
            System.out.println("Autorul cu ID-ul " + idAutor + " nu există.");
        } else {
            List<String> locatii = carteRepository.gasesteLocatieDupaDenumire(autor.getNume());
            if (locatii.isEmpty()) {
                System.out.println("Nu se găsesc cărți ale autorului în bibliotecă.");
            } else {
                System.out.println("--- Locațiile cărților autorului " + autor.getNume() + " ---");
                for (String locatie : locatii) {
                    System.out.println(locatie);
                }
            }
        }
    }

    @Override
    public void adaugareAutor() {
        System.out.print("Introduceți numele noului autor: ");
        String numeAutor = scanner.nextLine();
        System.out.print("Introduceți ID-ul noului autor: ");
        int idAutor = Integer.parseInt(scanner.nextLine());
        Autor autor = new Autor(idAutor, numeAutor);
        autorRepository.save(autor);
        System.out.println("Autorul " + numeAutor + " cu ID-ul " + idAutor + " a fost adăugat cu succes.");
    }


    @Override
    public void stergereAutor() {
        System.out.print("Introduceți ID-ul autorului pe care doriți să-l ștergeți: ");
        int idAutor = Integer.parseInt(scanner.nextLine());
        autorRepository.delete(idAutor);
        System.out.println("Autorul cu ID-ul " + idAutor + " a fost șters cu succes.");
    }

    @Override
    public void modificareAutor() {
        System.out.print("Introduceți ID-ul autorului pe care doriți să-l modificați: ");
        int idAutor = Integer.parseInt(scanner.nextLine());
        Autor autor = autorRepository.findById(idAutor);
        if (autor == null) {
            System.out.println("Autorul cu ID-ul " + idAutor + " nu există.");
        } else {
            System.out.print("Introduceți noul nume al autorului: ");
            String numeNou = scanner.nextLine();
            autor.setNume(numeNou);
            autorRepository.update(autor);
            System.out.println("Numele autorului cu ID-ul " + idAutor + " a fost modificat cu succes.");
        }
    }
}
