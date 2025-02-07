package custom.lists;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyArrayListTest {

    private MyArrayList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new MyArrayList<>(5);  // Инициализация перед каждым тестом
    }

    @Test
    void testAddAndGet() {
        list.add(15);
        list.add(20);
        assertEquals(15, list.get(0)); // Ожидаем 15 в ячейке с индексом 0
        assertEquals(20, list.get(1)); // Ожидаем 20 в ячейке с индексом 1
    }

    @Test
    void testRemove() {
        list.add(228);
        list.add(349);
        list.add(400);
        list.remove(1); // Удаляем 349
        assertEquals(400, list.get(1)); // Ожидаем теперь в ячейке 1 число 400
        assertEquals(2, list.size()); // Size должен был уменьшиться до 2х
    }

    @Test
    void testSort() {
        list.add(502);
        list.add(234);
        list.add(500);
        list.sort();
        assertEquals(234, list.get(0)); // Ожидаем 234 в ячейке 0
        assertEquals(500, list.get(1)); // Ожидаем 500 в ячейке 1
        assertEquals(502, list.get(2)); // ожидаем 502 в ячейке 2
    }

    @Test
    void testIsEmpty() {
        assertTrue(list.isEmpty()); // Ожидаем true, т.к в листе нет элементов
    }

    @Test
    void testClear() {
        list.add(1);
        list.add(2);
        list.clear();
        assertTrue(list.isEmpty()); // Ожидаем true, т.к очистили лист от элементов
    }

    @Test
    void testOutOfBoundsException() {
        list.add(1);
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
        assertEquals(IndexOutOfBoundsException.class, exception.getClass());
    }
}