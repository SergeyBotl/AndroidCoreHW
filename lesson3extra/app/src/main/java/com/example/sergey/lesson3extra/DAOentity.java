package com.example.sergey.lesson3extra;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.example.sergey.lesson3extra.Currency.*;

public class DAOentity {

    private static List<Entity> list = new ArrayList<>();
    private List<Entity> arrayList;
    private Iterator iterator;

    public DAOentity() {
        add(new Entity(1, "Peter", USD));
        add(new Entity(2, "Ann", UAH));


    }

    Currency getCurrency(int id) {
        for (Entity e : list) {
            if (e.getId() == id)
                return e.getCurrency();
        }

        return null;
    }

    void add(Object e) {                      //– добавляет элемент в конец списка
        list.add((Entity) e);
    }

    void add(int index, Object element) {      //– добавляет элемент в указанное место списка
        list.add(index, (Entity) element);
    }


    void set(int index, Object element) {        // – изменяет значение элемента
        list.set(index, (Entity) element);
    }


    void addAll(Object[] c) {                  //- добавляет массив элементов в конец списка

        arrayList = new ArrayList<>();
        arrayList.toArray(c);
        list.addAll(arrayList);
    }

    void addAll(int index, Object[] c) {    //- добавляет массив элементов в указанное место списка
        arrayList = new ArrayList<>();
        arrayList.toArray(c);
        list.addAll(index, arrayList);
    }

    Object get(int index) {          //– возвращает элемент по индексу
        return list.get(index);
    }

    int indexOf(Object o) {         //- поиск индекса по значению элемента
        return list.indexOf(o);
    }

    Object remove(Object e) {        //- удаляет элемент по элементу с использованием итератора
        iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(e)) iterator.remove();
        }
        return list;
    }

    Object remove(int index) {        //- удаляет элемент по индексу
        return list.remove(index);
    }

    int size() {           //- размер списка
        return list.size();
    }

    Object[] toArray() {     //- преобразует список в массив объектов
        return list.toArray();
    }

    public List<Entity> getList() {
        return list;
    }
}
