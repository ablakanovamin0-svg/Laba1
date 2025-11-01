package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс для тестирования функционала методов класса List
 * @author ablakanovamin0-svg
 * @version 1.0
 */
public class Tests {
    /**
     * Проверка работы метода createList
     */
    @Test
    void createListTest() {
        List<Integer> list = new List<>();
        assertTrue(list.empty());
        assertEquals(0, list.getLength());
    }

    /**
     * Проверка работы юетода getElem
     */
    @Test
    void getElemTest() {
        List<Integer> list = new List<>();
        list.insert(1);;
        list.insert(2);
        assertEquals(2, list.getElem(1));
        assertEquals(1, list.getElem(0));
        list.insertFirst(3);
        assertEquals(3, list.getElem(0));
        assertThrows(IndexOutOfBoundsException.class, () -> {list.getElem(3);});
        assertThrows(IndexOutOfBoundsException.class, () -> {list.getElem(-1);});
    }

    /**
     * Провема работы метода getLast
     */
    @Test
    void getLastTest() {
        List<Integer> list = new List<>();
        list.insert(1);;
        assertEquals(1, list.getLast());
        list.insert(2);
        assertEquals(2, list.getLast());
        list.clearList();
        assertThrows(IllegalStateException.class, () -> {list.getLast();});
    }

    /**
     * Проверка работы метода insert
     */
    @Test
    void insertTest() {
        List<Integer> list = new List<>();
        list.insert(1);;
        assertTrue(list.searchForElem(1));
        list.insert(2);
        assertTrue(list.searchForElem(2));
        list.insertFirst(3);
        assertTrue(list.searchForElem(3));
        assertFalse(list.searchForElem(4));
    }
    @Test
    void toStringTest() {
        List<Integer> intList = new List<>();
        assertEquals("", intList.toString());
        intList.insert(1);
        assertEquals("1", intList.toString());
        intList.insert(2);
        assertEquals("1 2", intList.toString());
        intList.deleteElem(0);
        assertEquals("2", intList.toString());
        intList.clearList();
        assertEquals("", intList.toString());
        List<String>stringList = new List<>();
        assertEquals("", stringList.toString());
        stringList.insert("agbj");
        assertEquals("agbj", stringList.toString());
        stringList.insert("gfijgifj");
        assertEquals("agbj gfijgifj", stringList.toString());
        stringList.deleteElem(1);
        assertEquals("agbj", stringList.toString());
        stringList.clearList();
        assertEquals("", stringList.toString());
    }
}
