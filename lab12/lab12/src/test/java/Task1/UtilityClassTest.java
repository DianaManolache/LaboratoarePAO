package Task1;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UtilityClassTest {

    @Test
    public void testPrintCollection() {
        //non-empty collection
        List<Integer> integers = List.of(1, 2, 3, 4, 5);
        assertDoesNotThrow(() -> UtilityClass.printCollection(integers));

        //empty collection
        List<Integer> emptyList = List.of();
        assertDoesNotThrow(() -> UtilityClass.printCollection(emptyList));

        //null collection
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            UtilityClass.printCollection(null);
        });
        assertEquals("Collection cannot be null", exception.getMessage());
    }

    @Test
    public void testAggregate() {
        //non-empty collection
        List<Boolean> booleans = List.of(true, false, true, false, true);
        boolean result1 = UtilityClass.aggregate(booleans, true, (Boolean acc, Boolean v) -> acc && v);
        assertFalse(result1);

        int result2 = UtilityClass.aggregate(booleans, 0, (Integer acc, Boolean v) -> v ? acc + 1 : acc);
        assertEquals(3, result2);

        //empty collection
        List<Integer> emptyList = List.of();
        int result3 = UtilityClass.aggregate(emptyList, 0, (Integer acc, Integer v) -> acc + v);
        assertEquals(0, result3);

        //null collection
        Exception exception1 = assertThrows(IllegalArgumentException.class, () -> {
            UtilityClass.aggregate(null, 0, (Integer acc, Integer v) -> acc + v);
        });
        assertEquals("Collection and accumulator cannot be null", exception1.getMessage());

        //null accumulator
        Exception exception2 = assertThrows(IllegalArgumentException.class, () -> {
            UtilityClass.aggregate(emptyList, 0, null);
        });
        assertEquals("Collection and accumulator cannot be null", exception2.getMessage());
    }

    @Test
    public void testDuplicateCollection() {
        //non-empty collection
        List<String> strings = List.of("ana", "are", "mere");
        Collection<String> duplicatedStrings = UtilityClass.duplicateCollection(strings);
        assertEquals(List.of("ana", "ana", "are", "are", "mere", "mere"), duplicatedStrings);

        //an empty collection
        List<Integer> emptyList = List.of();
        Collection<Integer> duplicatedEmptyList = UtilityClass.duplicateCollection(emptyList);
        assertTrue(duplicatedEmptyList.isEmpty());

        //null collection
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            UtilityClass.duplicateCollection(null);
        });
        assertEquals("Collection cannot be null", exception.getMessage());
    }
}