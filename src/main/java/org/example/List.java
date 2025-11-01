package org.example;

import java.util.Objects;

/**
 * Класс списка для хранения
 * произвольного числа элементов
 * @param <T> тип данных элементов списка
 * @author ablakanovamin0-svg
 * @version 1.0
 */
public class List<T> {
    /**
     * Вложенный класс узла списка
     * @param <T> тип данных элемента узла
     */
    private static class Node<T> {
        T elem;
        Node<T> nextElem;

        /**
         * Конструктор объектов класса узла списка
         * @param data данные, которые нужно внести в узел
         */
        Node(T data) {
            elem = data;
            nextElem = null;
        }
    }
    private Node<T> head;
    private Node<T> end;
    private int length;

    /**
     * Конструктор объектов класса списка
     */
    public List() {
        head = null;
        end = null;
        length = 0;
    }

    /**
     * Получение элемента по индексу
     * @param index индекс получаемого элемента
     * @return
     */
    public T getElem(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> node = head;
        for (int i = 0; i < index; i++) {
            node = node.nextElem;
        }
        return node.elem;
    }

    /**
     * Получение элемента с конца списка
     * @return последнийтвэлемента списка
     * @throws IllegalStateException, если список пуст
     */
    public T getLast() {
        if (end == null) {
            throw new IllegalStateException();
        }
        return end.elem;
    }

}
