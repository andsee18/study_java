package Repeat.september1;

/**
 * Собственная реализация динамического массива
 * КЛЮЧЕВЫЕ КОНЦЕПЦИИ:
 * 1. capacity - текущий размер внутреннего массива
 * 2. size - количество реальных элементов
 * 3. При добавлении: если size == capacity, увеличиваем capacity в 1.5x или 2x
 * 4. add() в конец = O(1) в среднем, O(n) когда нужна переаллокация
 * 5. add() в середину = O(n) - нужно сдвинуть элементы
 * 6. remove() = O(n) - нужно сдвинуть элементы
 * 7. get() = O(1) - прямой доступ по индексу
 */
public class MyArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size = 0;

    public MyArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int initialCapacity) {
        this.elements = new Object[initialCapacity];
    }

    /**
     * Добавить элемент в конец (размер = size++)
     */
    public void add(E element) {
        // Проверка: нужна ли переаллокация?
        if (size == elements.length) {
            ensureCapacity();
        }
        elements[size] = element;
        size++;
    }

    /**
     * Добавить элемент на конкретный индекс
     * Сдвигает все элементы с этого индекса вправо
     */
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (size == elements.length) {
            ensureCapacity();
        }

        // Сдвигаем элементы вправо, начиная с конца
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }

        elements[index] = element;
        size++;
    }

    /**
     * Получить элемент по индексу
     */
    @SuppressWarnings("unchecked")
    public E get(int index) {
        checkIndex(index);
        return (E) elements[index];
    }

    /**
     * Удалить элемент по индексу
     * Сдвигает все элементы слева
     */
    public E remove(int index) {
        checkIndex(index);

        @SuppressWarnings("unchecked")
        E oldValue = (E) elements[index];

        // Сдвигаем элементы влево
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }

        elements[--size] = null; // помощь для GC
        return oldValue;
    }

    /**
     * Удалить первый встреченный элемент по значению
     */
    public boolean remove(Object obj) {
        for (int i = 0; i < size; i++) {
            if ((obj == null && elements[i] == null) || 
                (obj != null && obj.equals(elements[i]))) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Получить размер
     */
    public int size() {
        return size;
    }

    /**
     * Получить capacity (текущий размер внутреннего массива)
     */
    public int capacity() {
        return elements.length;
    }

    /**
     * Пуст ли массив
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Содержит ли элемент
     */
    public boolean contains(Object obj) {
        for (int i = 0; i < size; i++) {
            if ((obj == null && elements[i] == null) || 
                (obj != null && obj.equals(elements[i]))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Очистить список
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    /**
     * КЛЮЧЕВОЙ МЕТОД! Увеличить capacity в 1.5 раза
     * Создаем новый больший массив и копируем старые элементы
     */
    private void ensureCapacity() {
        int newCapacity = (int) (elements.length * 1.5);
        if (newCapacity < DEFAULT_CAPACITY) {
            newCapacity = DEFAULT_CAPACITY;
        }

        Object[] oldElements = elements;
        elements = new Object[newCapacity];

        // Копируем старые элементы в новый массив
        System.arraycopy(oldElements, 0, elements, 0, size);
    }

    /**
     * Проверить корректность индекса
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
