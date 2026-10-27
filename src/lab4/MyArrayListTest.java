package lab4;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    @Test
    void testMyArrayListCoverage() {
        MyArrayList<Integer> list = new MyArrayList<>();

        for (int i = 0; i < 15; i++) {
            list.add(i);
        }
        assertEquals(15, list.size());

        assertEquals(5, list.get(5));

        list.add(0, 99);
        assertEquals(99, list.get(0));

        list.set(1, 100);
        assertEquals(100, list.get(1));

        int removed = list.remove(0);
        assertEquals(99, removed);
        assertEquals(15, list.size());

        list.add(null);
        assertTrue(list.indexOf(100) >= 0);
        assertTrue(list.indexOf(null) >= 0);
        assertEquals(-1, list.indexOf(999));

        MyList<Number> numList = new MyArrayList<>();
        List<Integer> ints = Arrays.asList(1, 2, 3);
        assertTrue(numList.addAll(ints));
        assertTrue(numList.addAll(1, ints));
        assertFalse(numList.addAll(null));
        assertEquals(6, numList.size());

        Object[] arr = numList.toArray();
        assertEquals(6, arr.length);

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(100, 1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(100));
    }
}