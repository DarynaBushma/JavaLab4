package lab4;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {

    @Test
    void testMyLinkedListCoverage() {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.add(10);
        list.add(20);
        list.add(30);
        assertEquals(3, list.size());

        assertEquals(10, list.get(0));
        assertEquals(30, list.get(2));

        list.add(3, 40);
        list.add(0, 5);
        assertEquals(5, list.get(0));

        list.set(2, 25);
        assertEquals(25, list.get(2));

        assertEquals(5, list.remove(0));
        assertEquals(40, list.remove(list.size() - 1));
        assertEquals(25, list.remove(1));

        list.add(null);
        assertTrue(list.indexOf(30) >= 0);
        assertTrue(list.indexOf(null) >= 0);
        assertEquals(-1, list.indexOf(999));

        MyLinkedList<Number> numList = new MyLinkedList<>();
        List<Integer> ints = Arrays.asList(1, 2, 3);
        assertTrue(numList.addAll(ints));
        assertTrue(numList.addAll(1, ints));
        assertFalse(numList.addAll(null));
        assertEquals(6, numList.size());

        Object[] arr = numList.toArray();
        assertEquals(6, arr.length);

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
    }
}