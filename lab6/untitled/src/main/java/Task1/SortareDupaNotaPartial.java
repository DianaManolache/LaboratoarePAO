package Task1;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class SortareDupaNotaPartial implements SortareStrategy {
    @Override
    public void sort(List<Student> studenti) {
        Collections.sort(studenti, Comparator.comparingDouble(Student::getNotaPartial).reversed());
    }
}
