package custom.lists;

public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {
    /**
     * Головной узел связного списка.
     */
    private Node<T> head;

    /**
     * Хвостовой узел связного списка.
     */
    private Node<T> tail;

    /**
     * Количество элементов в связном списке.
     */
    private int size;

    /**
     * Внутренний класс, представляющий узел связного списка.
     *
     * @param <T> тип данных, хранящихся в узле
     */
    private static class Node<T> {
        /**
         * Обобщенное поле для хранения значений произвольного типа в узлах списка.
         */
        T data;

        /**
         * Ссылка на следующий узел в односвязном списке.
         */
        Node<T> next;

        /**
         * Создает узел с указанными данными.
         *
         * @param data данные, которые нужно сохранить в узле
         */
        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Добавляет новый элемент в конец связного списка.
     * Если список пуст, новый элемент становится и головным, и хвостовым узлом.
     * Иначе новый узел добавляется после текущего хвостового узла, и хвост обновляется.
     *
     * @param data данные, которые нужно добавить в список
     */
    @Override
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;  // Инициализируем хвост, если список был пуст
        } else {
            tail.next = newNode; // Присоединяем новый узел к текущему хвосту
            tail = newNode; // Обновляем хвостовой узел
        }
        size++;
    }

    /**
     * Возвращает элемент по указанному индексу.
     * Используется цикл для перехода от головного узла к указанному индексу.
     *
     * @param index индекс элемента для получения
     * @return элемент по указанному индексу
     * @throws IndexOutOfBoundsException если индекс выходит за пределы допустимого диапазона
     */
    @Override
    public T get(int index) {
        checkIndex(index);
        Node<T> current = head;
        // Проходимся по списку, пока не достигнем нужного индекса
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    /**
     * Удаляет элемент по указанному индексу.
     * Если индекс равен 0, удаляется головной узел.
     * В противном случае находим предыдущий узел, чтобы удалить текущий.
     *
     * @param index индекс элемента для удаления
     * @throws IndexOutOfBoundsException если индекс выходит за пределы допустимого диапазона
     */
    @Override
    public void remove(int index) {
        checkIndex(index);
        if (index == 0) {
            // Удаляем головной узел
            head = head.next;
            if (head == null) {
                tail = null; // Обнуляем хвост, если список стал пустым
            }
        } else {
            Node<T> current = head;
            // Перемещаемся до узла, предшествующего удаляемому
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            // Переподключаем ссылки, пропуская удаляемый узел
            current.next = current.next.next;
            if (current.next == null) {
                tail = current; // Обновляем хвост, если удалили последний элемент
            }
        }
        size--;
    }

    /**
     * Возвращает количество элементов в связном списке.
     *
     * @return размер связного списка
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
     * Обнуляет ссылки на головной и хвостовой узлы.
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
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
     * Сортирует элементы списка методом пузырьковой сортировки.
     * Этот алгоритм имеет временную сложность O(n^2) и подходит для небольших списков.
     */
    @Override
    public void sort() {
        if (size < 2) {
            return; // Если в списке меньше двух элементов, сортировка не требуется
        }

        boolean swapped;
        do {
            swapped = false;
            Node<T> current = head;

            while (current != null && current.next != null) {
                if (current.data.compareTo(current.next.data) > 0) {
                    // Меняем местами данные узлов, если они находятся в неправильном порядке
                    T temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }
}
