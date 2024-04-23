package Task1;

import java.util.List;

class Sortare {
    private SortareStrategy strategy;

    public Sortare(SortareStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(SortareStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeSortare(List<Student> studenti) {
        strategy.sort(studenti);
    }
}
