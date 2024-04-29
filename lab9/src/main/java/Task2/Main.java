package Task2;

public class Main {
    public static void main(String[] args) {
        WordCounterImplementation wordCounter = new WordCounterImplementation();

        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
                + "Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "
                + "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi "
                + "ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit "
                + "in voluptate velit esse cillum dolore eu fugiat nulla pariatur. "
                + "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia "
                + "deserunt mollit anim id est laborum.";

        wordCounter.parse(text);

        System.out.println("Nr aparitii 'ipsum': " + wordCounter.getCount("ipsum"));
        System.out.println("Nr aparitii 'dolor': " + wordCounter.getCount("dolor"));
        System.out.println("Nr aparitii 'nonexistent': " + wordCounter.getCount("nonexistent"));

        System.out.println("Toate cuvintele unice si nr aparitii:");
        wordCounter.printWordCounts();

        wordCounter.reset();

        System.out.println("Dupa resetare, contorul este gol: " + wordCounter.getUniqueWords().isEmpty());
    }
}
