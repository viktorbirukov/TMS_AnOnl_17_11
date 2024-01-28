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

public class ArrayResult {
public static void main(String[] args) {
    CustomArrayList<String> customList = new CustomArrayList<>();
    customList.add("1");
    customList.add("2");
    customList.add("3");

    System.out.println("Размер: " + customList.size());
    System.out.println("Пусто: " + customList.isEmpty());
    System.out.println("Содержит '2': " + customList.contains("2"));

    System.out.println("Элемент с индексом 1: " + customList.get(0));

    customList.remove(0);
    System.out.println("После удаления элемента с индексом 0: " + customList);

    customList.clear();
    System.out.println("После очистки списка: " + customList);
}
}



