package Library;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class CarteServiceForAdmin extends CarteServiceForUser {
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
//    private CarteRepository carteRepository = new CarteRepository();
//
//    @Override
//    public void vizualizareToateCartile() {
//        List<Carte> carti = carteRepository.findAll();
//        if (carti.isEmpty()) {
//            System.out.println("Nu există cărți în bibliotecă.");
//        } else {
//            System.out.println("Lista cărților disponibile în bibliotecă:");
//            for (Carte carte : carti) {
//                System.out.println("ID: " + carte.getId() + ", Denumire: " + carte.getDenumire() +
//                        ", Autor ID: " + carte.getAutorId() + ", Sectiune ID: " + carte.getSectiuneId() +
//                        ", Nr. Total Exemplare: " + carte.getNrTotalExemplare());
//            }
//        }
//    }
//
//    @Override
//    public void vizualizareCartileImprumutate() {
//        Scanner scanner = new Scanner(System.in);
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//
//        try {
//            System.out.print("Introduceți data de început (yyyy-MM-dd): ");
//            String startDateInput = scanner.nextLine();
//            Date startDate = new Date(dateFormat.parse(startDateInput).getTime());
//
//            System.out.print("Introduceți data de sfârșit (yyyy-MM-dd): ");
//            String endDateInput = scanner.nextLine();
//            Date endDate = new Date(dateFormat.parse(endDateInput).getTime());
//
//            List<Carte> carti = carteRepository.imprumutataDeLaData1LaData2(startDate, endDate);
//            for (Carte carte : carti) {
//                System.out.println("ID: " + carte.getId() + ", Denumire: " + carte.getDenumire() +
//                        ", Autor ID: " + carte.getAutorId() + ", Sectiune ID: " + carte.getSectiuneId() +
//                        ", Nr. Total Exemplare: " + carte.getNrTotalExemplare());
//            }
//        } catch (ParseException e) {
//            System.out.println("Formatul datei este invalid. Vă rugăm să introduceți data în formatul yyyy-MM-dd.");
//        }
//    }
//
//    @Override
//    public void vizualizareCartileDisponibile() {
//        List<Carte> carti = carteRepository.cartileDisponibile();
//        for (Carte carte : carti) {
//            System.out.println("ID: " + carte.getId() + ", Denumire: " + carte.getDenumire() +
//                    ", Autor ID: " + carte.getAutorId() + ", Sectiune ID: " + carte.getSectiuneId() +
//                    ", Nr. Total Exemplare: " + carte.getNrTotalExemplare());
//        }
//    }
//
//    @Override
//    public void vizualizareFiseleExemplarelor() {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Introduceți denumirea cărții: ");
//        String denumireCarte = scanner.nextLine();
//
//        List<Fisa> fise = carteRepository.fiseleCartii(denumireCarte);
//        for (Fisa fisa : fise) {
//            System.out.println("ID Fisa: " + fisa.getId() + ", Data Imprumut: " + fisa.getDataImprumut() + ", Data Return: " + fisa.getDataReturn());
//        }
//    }
//
//    @Override
//    public void vizualizareLocatieCarte() {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Introduceți denumirea cărții: ");
//        String denumireCarte = scanner.nextLine();
//
//        Sectiune locatie = carteRepository.gasesteLocatieDupaDenumire(denumireCarte);
//        if (locatie != null) {
//            System.out.println("ID: " + locatie.getId() + ", Denumire: " + locatie.getDenumire() +
//                    ", Sala: " + locatie.getSala() + ", Rand: " + locatie.getRand() +
//                    ", Coloana: " + locatie.getColoana() + ", Raft: " + locatie.getRaft());
//        } else {
//            System.out.println("Locație nu a fost găsită pentru cartea cu denumirea: " + denumireCarte);
//        }
//    }
//
//    @Override
//    public void adaugareLocatie() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Introduceți ID-ul noii locații: ");
//        int id = scanner.nextInt();
//        scanner.nextLine(); // Consumă newline
//        System.out.print("Introduceți denumirea noii locații: ");
//        String denumire = scanner.nextLine();
//        System.out.print("Introduceți sala: ");
//        String sala = scanner.nextLine();
//        System.out.print("Introduceți rândul: ");
//        int rand = scanner.nextInt();
//        System.out.print("Introduceți coloana: ");
//        int coloana = scanner.nextInt();
//        System.out.print("Introduceți raftul: ");
//        int raft = scanner.nextInt();
//
//        Sectiune sectiune = new Sectiune(id, denumire, sala, rand, coloana, raft);
//        carteRepository.saveSectiune(sectiune);
//        System.out.println("Locația a fost adăugată cu succes!");
//    }
//
//    @Override
//    void adaugareCarte() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Introduceți denumirea cărții: ");
//        String denumire = scanner.nextLine();
//        System.out.print("Introduceți ID-ul autorului: ");
//        int autorId = scanner.nextInt();
//        scanner.nextLine(); // Consumă newline
//        System.out.print("Introduceți ID-ul secțiunii: ");
//        int sectiuneId = scanner.nextInt();
//        System.out.print("Introduceți numărul total de exemplare: ");
//        int nrTotalExemplare = scanner.nextInt();
//
//        Carte carte = new Carte(denumire, autorId, sectiuneId, nrTotalExemplare);
//        carteRepository.save(carte);
//        System.out.println("Cartea a fost adăugată cu succes!");
//    }
//
//    @Override
//    void adaugareExemplar() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Introduceți ID-ul cărții: ");
//        int carteId = scanner.nextInt();
//        System.out.print("Exemplarul este disponibil? (true/false): ");
//        boolean disponibil = scanner.nextBoolean();
//
//        Exemplar exemplar = new Exemplar(carteId, disponibil);
//        try {
//            carteRepository.saveExemplar(exemplar);
//            System.out.println("Exemplarul a fost adăugat cu succes!");
//        } catch (SQLException e) {
//            System.out.println("A apărut o eroare la adăugarea exemplarului: " + e.getMessage());
//        }
//    }
//
//    @Override
//    void stergereLocatie() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Introduceți ID-ul locației de șters: ");
//        int id = scanner.nextInt();
//
//        try {
//            carteRepository.deleteSectiune(id);
//            System.out.println("Locația a fost ștearsă cu succes!");
//        } catch (SQLException e) {
//            System.out.println("A apărut o eroare la ștergerea locației: " + e.getMessage());
//        }
//    }
//
//    @Override
//    void stergereCarte() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Introduceți ID-ul cărții de șters: ");
//        int id = scanner.nextInt();
//
//        carteRepository.delete(id);
//        System.out.println("Cartea a fost ștearsă cu succes!");
//    }
//
//    @Override
//    void stergereExemplar() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Introduceți ID-ul exemplarului de șters: ");
//        int id = scanner.nextInt();
//
//        try {
//            carteRepository.deleteExemplar(id);
//            System.out.println("Exemplarul a fost șters cu succes!");
//        } catch (SQLException e) {
//            System.out.println("A apărut o eroare la ștergerea exemplarului: " + e.getMessage());
//        }
//    }
//
//    @Override
//    void modificareLocatie() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Introduceți ID-ul locației de modificat: ");
//        int id = scanner.nextInt();
//        scanner.nextLine(); // Consumă newline
//        System.out.print("Introduceți noua denumire a locației: ");
//        String denumire = scanner.nextLine();
//        System.out.print("Introduceți noua sală: ");
//        String sala = scanner.nextLine();
//        System.out.print("Introduceți noul rând: ");
//        int rand = scanner.nextInt();
//        System.out.print("Introduceți noua coloană: ");
//        int coloana = scanner.nextInt();
//        System.out.print("Introduceți noul raft: ");
//        int raft = scanner.nextInt();
//
//        Sectiune sectiune = new Sectiune(id, denumire, sala, rand, coloana, raft);
//        try {
//            carteRepository.updateSectiune(sectiune);
//            System.out.println("Locația a fost modificată cu succes!");
//        } catch (SQLException e) {
//            System.out.println("Eroare la modificarea locației: " + e.getMessage());
//        }
//    }
//
//
//    @Override
//    void modificareCarte() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Introduceți ID-ul cărții de modificat: ");
//        int id = scanner.nextInt();
//        scanner.nextLine(); // Consumă newline
//        System.out.print("Introduceți noua denumire a cărții: ");
//        String denumire = scanner.nextLine();
//        System.out.print("Introduceți noul ID al autorului: ");
//        int autorId = scanner.nextInt();
//        System.out.print("Introduceți noul ID al secțiunii: ");
//        int sectiuneId = scanner.nextInt();
//        System.out.print("Introduceți noul număr total de exemplare: ");
//        int nrTotalExemplare = scanner.nextInt();
//
//        Carte carte = new Carte(id, denumire, autorId, sectiuneId, nrTotalExemplare);
//        carteRepository.update(carte);
//        System.out.println("Cartea a fost modificată cu succes!");
//    }
//
//
//    @Override
//    void modificareExemplar() {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Introduceți ID-ul exemplarului pe care doriți să-l modificați: ");
//        int exemplarId = scanner.nextInt();
//        scanner.nextLine();
//
//        System.out.print("Introduceți noua disponibilitate a exemplarului (true/false): ");
//        boolean disponibilitate = scanner.nextBoolean();
//        scanner.nextLine();
//
//
//        Exemplar exemplar = new Exemplar();
//        exemplar.setId(exemplarId);
//        exemplar.setDisponibil(disponibilitate);
//
//        carteRepository.updateExemplar(exemplar);
//
//        System.out.println("Exemplarul a fost actualizat cu succes!");
//    }
//
//    @Override
//    void modificareFisa() {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Introduceți ID-ul fișei pe care doriți să o modificați: ");
//        int fisaId = scanner.nextInt();
//        scanner.nextLine(); // Consumă newline
//
//
//        System.out.print("Introduceți noua data de returnare (yyyy-MM-dd): ");
//        String dataReturn = scanner.nextLine();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        java.util.Date parsedDate;
//        try {
//            parsedDate = dateFormat.parse(dataReturn);
//        } catch (ParseException e) {
//            System.out.println("Formatul datei este invalid. Vă rugăm să introduceți data în formatul yyyy-MM-dd.");
//            return;
//        }
//        java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
//
//        Fisa fisa = new Fisa();
//        fisa.setId(fisaId);
//        fisa.setDataReturn(sqlDate);
//
//        carteRepository.updateFisa(fisa);
//
//        System.out.println("Fișa a fost actualizată cu succes!");
//    }
}