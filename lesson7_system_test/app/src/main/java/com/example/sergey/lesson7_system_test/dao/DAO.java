package com.example.sergey.lesson7_system_test.dao;

import java.util.Collection;

public interface DAO<T> {
    boolean save(T t);

    T findById();

    Collection<T> getAll();

}
