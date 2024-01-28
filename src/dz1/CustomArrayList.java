package dz1;

// Домашка №11
// Бирюков Виктор
// Представим, что в Java нет коллекции типа ArrayList.
//Создать свой класс, симулирующий работу класса динамической
//коллекции - т.е. создать свою кастомную коллекцию.
//В основе коллекции будет массив.
//Кастомная коллекция должна хранить элементы разных классов(т.е. это
//generic).
//Предусмотреть операции добавления элемента, удаления элемента,
//получение элемента по индексу, проверка есть ли элемент в коллекции,
//метод очистки все коллекции.
//Предусмотреть конструктор без параметров - создает массив размером
//по умолчанию.
//Предусмотреть конструктор с задаваемым размером внутреннего
//массива.
//Предусмотреть возможность автоматического расширения коллекции
//при добавлении элемента в том случае, когда коллекция уже заполнена

import java.util.Arrays;

public class CustomArrayList<T> {
    private static final int DEFAULT_CAPACITY = 10; // Размер массива по умолчанию
    private Object[] elements; // Внутренний массив для хранения элементов
    private int size; // Текущий размер коллекции

    // Конструктор без параметров
    public CustomArrayList() {
        elements = new Object[DEFAULT_CAPACITY]; // Инициализация внутреннего массива
    }

    // Конструктор с задаваемым начальным размером массива
    public CustomArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Емкость массива не может быть отрицательной");
        }
        elements = new Object[initialCapacity];
    }

    // Метод для получения текущего размера коллекции
    public int size() {
        return size;
    }

    // Метод для проверки, пуста ли коллекция
    public boolean isEmpty() {
        return size == 0;
    }

    // Метод для добавления элемента в коллекцию
    public void add(T element) {
        ensureCapacity(); // Проверка и, при необходимости, расширение массива
        elements[size++] = element; // Добавление элемента и увеличение размера коллекции
    }

    // Метод для получения элемента по индексу
    public T get(int index) {
        checkIndex(index); // Проверка валидности индекса
        return (T) elements[index]; // Приведение типа и возврат элемента
    }

    // Метод для проверки наличия элемента в коллекции
    public boolean contains(T element) {
        return indexOf(element) >= 0;
    }

    // Метод для получения индекса элемента в коллекции (или -1, если элемент не найден)
    public int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            if (element == null ? elements[i] == null : element.equals(elements[i])) {
                return i;
            }
        }
        return -1; // Элемент не найден
    }

    // Метод для удаления элемента по индексу
    public void remove(int index) {
        checkIndex(index); // Проверка валидности индекса
        int numMoved = size - index - 1; // Количество элементов, которые нужно переместить
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved); // Сдвиг элементов
        }
        elements[--size] = null; // Очистка последнего элемента и уменьшение размера коллекции
    }

    // Метод для очистки коллекции
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null; // Очистка элементов
        }
        size = 0; // Установка размера коллекции в 0
    }

    // Внутренний метод для проверки и, при необходимости, расширения массива
    private void ensureCapacity() {
        if (size == elements.length) { // Если коллекция заполнена
            int newCapacity = elements.length * 2; // Увеличиваем размер внутреннего массива
            elements = Arrays.copyOf(elements, newCapacity); // Копируем элементы в новый массив
        }
    }

    // Внутренний метод для проверки валидности индекса
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс выходит за пределы: " + index);
        }
    }
}
