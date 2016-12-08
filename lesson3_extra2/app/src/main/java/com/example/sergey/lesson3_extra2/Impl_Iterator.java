package com.example.sergey.lesson3_extra2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Impl_Iterator {

    List<Object> list = new ArrayList<>();
    // – добавляет элемент в конец списка

    void add(Object e) {
        list.add(e);
    }

    //– добавляет элемент в указанное место списка
    void add(int index, Object element) {
        list.add(index, element);
    }

    //– изменяет значение элемента
    void set(int index, Object element) {
        list.set(index, element);
    }

    //- добавляет массив элементов в конец списка
    void addAll(Object[] c) {
        list.addAll(new ArrayList<Object>(Arrays.asList(c)));
    }

    //- добавляет массив элементов в указанное место списка
    void addAll(int index, Object[] c) {
        list.addAll(index, new ArrayList<Object>(Arrays.asList(c)));
    }

    // – возвращает элемент по индексу
    Object get(int index) {
        list.get(index);
        return null;
    }


    //- поиск индекса по значению элемента
    int indexOf(Object o) {
        list.indexOf(o);
        return 0;
    }

    //- удаляет элемент по индексу
    Object remove(int index) {
        return list.remove(index);
    }


    //- размер списка
    int size() {
        return list.size();
    }

    //- преобразует список в массив объектов
    Object[] toArray() {
        return list.toArray();
    }

    void removeInIterator(Object o) {
        Iterator<Object> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(o)) {
                iterator.remove();
            }
        }
    }
}
