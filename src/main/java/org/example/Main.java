package org.example;

/**
 * Класс для показа функционала объектов созданного контейнера List
 */
public class Main {
    /**
     * Показ функционала методов класса List
     */
    static void main() {
        List<Integer> intList = new List<>();
        System.out.println("Вывод списка: " + intList);
        System.out.println("Размер списка: " + intList.getLength());
        System.out.println("Проверка списка на пустоту: " + intList.empty());
        intList.insert(3);
        System.out.println("Добавление элемента 3 в конец пустого списка: " + intList);
        intList.insertFirst(4);
        System.out.println("Добавление элемента 4 в начало списка: " + intList);
        System.out.println("Размер списка: " + intList.getLength());
        intList.insert(5);
        System.out.println("Добавление элемента 5 в конец списка: " + intList);
        System.out.println("Размер списка: " + intList.getLength());
        System.out.println("Проверка списка на пустоту: " + intList.empty());
        System.out.println("Элемент под индексом 2: " + intList);
        intList.deleteElem(1);
        System.out.println("Удаление элемента под индексом 1: " + intList);
        System.out.println("Размер списка: " + intList.getLength());
        System.out.println("Поиск элемента 4: " + intList.searchForElem(4));
        System.out.println("Поиск элемента 2: " + intList.searchForElem(2));
        intList.clearList();
        System.out.println("Список после очистки: " + intList);
    }
}
