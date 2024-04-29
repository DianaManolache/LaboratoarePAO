package Task2;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class WordCounterImplementation implements WordCounter {

    private Map<String, Integer> wordCounts;

    public WordCounterImplementation() {
        this.wordCounts = new HashMap<>();
    }

    @Override
    public void parse(String text) {
        String[] words = text.split("\\s+");
        for (String word : words) {
            word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
            if (!word.isEmpty()) {
                wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
            }
        }
    }

    @Override
    public int getCount(String word) {
        return wordCounts.getOrDefault(word.toLowerCase(), 0);
    }

    @Override
    public SortedSet<String> getUniqueWords() {
        return new TreeSet<>(wordCounts.keySet());
    }

    @Override
    public void printWordCounts() {
        wordCounts.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

    @Override
    public void reset() {
        wordCounts.clear();
    }
}
