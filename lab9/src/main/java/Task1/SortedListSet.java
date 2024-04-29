package Task1;

import java.util.*;

public class SortedListSet<T extends Comparable<T>> extends LinkedList<T> implements SortedSet<T> {
    private Comparator<T> comparator;
    public SortedListSet() {
        this.comparator = Comparator.naturalOrder();
    }

    public SortedListSet(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    @Override
    public Comparator<? super T> comparator() {
        return comparator;
    }

    public Comparator<T> getComparator() {
        return comparator;
    }

    @Override
    public boolean add(T o) {
        if (contains(o)) {
            return false;
        }
        ListIterator<T> iterator = listIterator();
        while (iterator.hasNext()) {
            if (comparator.compare(iterator.next(), o) > 0) {
                iterator.previous();
                iterator.add(o);
                return true;
            }
        }
        iterator.add(o);
        return true;
    }

    @Override
    public T first() {
        if (isEmpty()) {
            throw new NoSuchElementException("Set is empty");
        }
        return getFirst();
    }

    @Override
    public T last() {
        if (isEmpty()) {
            throw new NoSuchElementException("Set is empty");
        }
        return getLast();
    }

    @Override
    public SortedSet<T> subSet(T from, T to) {
        if (comparator.compare(from, to) > 0) {
            throw new IllegalArgumentException("'from' element is greater than 'to' element");
        }
        SortedSet<T> subset = new SortedListSet<>(comparator);
        for (T element : this) {
            if (comparator.compare(element, from) >= 0 && comparator.compare(element, to) < 0) {
                subset.add(element);
            }
        }
        return subset;
    }

    @Override
    public SortedSet<T> headSet(T to) {
        SortedSet<T> subset = new SortedListSet<>(comparator);
        for (T element : this) {
            if (comparator.compare(element, to) < 0) {
                subset.add(element);
            } else {
                break;
            }
        }
        return subset;
    }

    @Override
    public SortedSet<T> tailSet(T from) {
        SortedSet<T> subset = new SortedListSet<>(comparator);
        boolean found = false;
        for (T element : this) {
            if (comparator.compare(element, from) >= 0) {
                subset.add(element);
                found = true;
            }
        }
        if (!found) {
            throw new IllegalArgumentException("'from' element is not found in the set");
        }
        return subset;
    }
}