package custom.lists;

import java.util.Arrays;

public class MyArrayList<T extends Comparable<T>> implements MyList<T> {
    /**
     * Начальная емкость динамического массива по умолчанию.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Массив для хранения элементов.
     */
    private Object[] elements;

    /**
     * Количество элементов в массиве.
     */
    private int size;

    /**
     * Создаем пустой динамический массив с начальной емкостью по умолчанию.
     */
    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    /**
     * Добавляет новый элемент в конец массива.
     * Если текущей емкости массива недостаточно, она увеличивается.
     *
     * @param element данные, которые нужно добавить в массив
     */
    @Override
    public void add(T element) {
        increaseCapacity(); // Проверяем и увеличиваем емкость массива, если это необходимо
        elements[size++] = element; // Добавляем элемент в массив и увеличиваем размер
    }

    /**
     * Возвращает элемент по указанному индексу.
     *
     * @param index индекс элемента для получения
     * @return элемент по указанному индексу
     * @throws IndexOutOfBoundsException если индекс выходит за пределы допустимого диапазона
     */
    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    /**
     * Удаляет элемент по указанному индексу.
     * Элементы справа от удаляемого сдвигаются влево на одну позицию.
     * Последний элемент устанавливается в null для освобождения памяти.
     *
     * @param index индекс элемента для удаления
     * @throws IndexOutOfBoundsException если индекс выходит за пределы допустимого диапазона
     */
    @Override
    public void remove(int index) {
        checkIndex(index); // Проверка индекса на корректность.
        // Перемещаем элементы после удаляемого индекса на одну позицию влево, чтобы сохранить порядок элементов в массиве.
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null; // Уменьшаем размер и очищаем последний элемент
    }

    /**
     * Возвращает количество элементов в списке.
     *
     * @return размер списка
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Проверяет, пуст ли список.
     *
     * @return true, если список пуст; иначе false
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Очищает список, удаляя все элементы.
     * Старые элементы становятся недоступны и могут быть удалены сборщиком мусора.
     */
    @Override
    public void clear() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Обеспечивает достаточную емкость массива для хранения новых элементов.
     * Если текущей емкости недостаточно, она увеличивается в два раза.
     */
    private void increaseCapacity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }

    /**
     * Проверяет корректность указанного индекса.
     *
     * @param index индекс для проверки
     * @throws IndexOutOfBoundsException если индекс выходит за пределы допустимого диапазона
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Такого индекса нет " + index);
        }
    }

    /**
     * Сортирует массив с использованием алгоритма сортировки "пузырьком".
     * Этот алгоритм имеет временную сложность O(n^2) и подходит для небольших массивов.
     */
    @Override
    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                T currentElement = (T) elements[j];
                T nextElement = (T) elements[j + 1];
                if (currentElement.compareTo(nextElement) < 0) {
                    elements[j] = nextElement;
                    elements[j + 1] = currentElement;
                }
            }
        }
    }
}
