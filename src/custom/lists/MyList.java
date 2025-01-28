package custom.lists;

/**
 * Общий интерфейс для коллекций типа List.
 *
 * @param <T> тип элементов в списке
 */

public interface MyList<T extends Comparable<T>> {

    /**
     * Добавляет элемент в список.
     *
     * @param element элемент для добавления
     */
    void add(T element);

    /**
     * Возвращает элемент по указанному индексу.
     *
     * @param index индекс элемента
     * @return элемент по индексу
     * @throws IndexOutOfBoundsException если индекс выходит за пределы списка
     */
    T get(int index);

    /**
     * Удаляет элемент по указанному индексу.
     *
     * @param index индекс элемента для удаления
     * @throws IndexOutOfBoundsException если индекс выходит за пределы списка
     */
    void remove(int index);

    /**
     * Возвращает количество элементов в списке.
     *
     * @return размер списка
     */
    int size();

    /**
     * Проверяет, пуст ли список.
     *
     * @return true, если список пуст; иначе false
     */
    boolean isEmpty();

    /**
     * Очищает список, удаляя все элементы.
     */
    void clear();

    /**
     * Сортирует элементы списка в порядке возрастания.
     */
    void sort();
}