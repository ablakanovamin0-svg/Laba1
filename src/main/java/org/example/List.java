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
     * @return элемент списка на позиции, соответвующей введённому индексу
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

    /**
     * Получение количества элементов списка
     * @return количество элементов текущего объекта
     */
    public int getLength() {
         return length;
    }

    /**
     * Проверка списка на пустоту
     * @return true, если список пуст, иначе возвращает false
     */
    public boolean empty() {
        return length == 0;
    }

    /**
     * Добавление элемента в конец списка
     * @param data добавляемый элемент
     */
    public void insert(T data) {
        Node<T> node = new Node<>(data);
        if (head == null){
            head = node;
            end = node;
        }
        else {
            end.nextElem = node;
            end = node;
        }
        ++length;
    }

    /**
     * Добавление элемента в начало списка
     * @param data добавляемый элемент
     */
    public void insertFirst(T data) {
        Node<T> node = new Node<>(data);
        if (head == null) {
            head = node;
            end = node;
        }
        else {
            node.nextElem = head;
            head = node;
        }
        ++length;
    }

    /**
     * Удаление элемента по индексу из списка
     * @param index индекс удаляемого элемента
     */
    public void deleteElem(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            head = head.nextElem;
            if (head == null) {
                end = null;
            }
        }
        else {
            Node<T> node = head;
            for (int i = 0; i < index - 1; i++) {
                node = node.nextElem;
            }
            if (node.nextElem == end) {
                end = node;
            }
            node.nextElem = node.nextElem.nextElem;
        }
        --length;
    }

    /**
     * Очистка списка
     */
    public void clearList() {
        head = null;
        end = null;
        length = 0;
    }

    /**
     * Поиск элемента по индексу в списке
     * @param data искомый элемент в списке
     * @return true, если элемент найден в списке, иначе возвращает falseо
     */
    public boolean searchForElem(T data) {
        Node<T> node = head;
        while (node != null) {
            if (Objects.equals(node.elem, data)) {
                return true;
            }
            node = node.nextElem;
        }
        return false;
    }

    /**
     * Преобразования списка в строковый формат для вывода
     * @return строку из элементов списка
     */
    @Override
    public String toString() {
        String result = "";
        Node<T> node = head;
        while (node != null) {
            result += node.elem;
            if (node.nextElem != null) {
                result += " ";
            }
            node = node.nextElem;
        }
        return result;
    }
}
