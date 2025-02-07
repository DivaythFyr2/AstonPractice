package custom.lists;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;


public class MyLinkedListTest {
    private MyLinkedList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new MyLinkedList<>();
    }

    @Test
    void testAddAndGet() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(1, list.get(0)); // Первый элемент должен быть 1
        assertEquals(2, list.get(1)); // Первый элемент должен быть 2
        assertEquals(3, list.get(2)); // Первый элемент должен быть 3
    }

    @Test
    void testRemove() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(1);
        assertEquals(3, list.get(1)); // Ожидаем тройку в ячейке с индексом 1
        assertEquals(2, list.size()); // Ожидаем размер списка 2 после удаления
    }

    @Test
    void testSort() {
        list.add(36);
        list.add(20);
        list.add(30);
        list.sort();
        assertEquals(20, list.get(0)); // После сортировки первый элемент должен быть 20
        assertEquals(30, list.get(1)); // После сортировки второй элемент должен быть 30
        assertEquals(36, list.get(2)); // После сортировки третий элемент должен быть 36
    }

    @Test
    void testIsEmpty() {
        assertTrue(list.isEmpty()); // Ожидаем true, т.к в листе нет элементов
    }

    @Test
    void testSize() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.size()); // Ожидаем 3, т.к добавили 3 элемента
    }

    @Test
    void testClear() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.clear();
        assertEquals(0, list.size()); // Ожидаем 0, т.к очистили лист от элементов
        assertTrue(list.isEmpty()); // Ожидаем true, т.к лист пустой
    }

    @Test
    void testOutOfBounds() {
        list.add(10);
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
        assertEquals(IndexOutOfBoundsException.class, exception.getClass());
    }
}