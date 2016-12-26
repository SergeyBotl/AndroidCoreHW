package com.example.sergey.lesson7_system_test.dao;

import com.example.sergey.lesson7_system_test.entity.User;

import java.util.Collection;

public class UserDao implements DAO<User> {


    @Override
    public boolean save(User user) {
        return false;
    }

    @Override
    public User findById() {
        return null;
    }

    @Override
    public Collection<User> getAll() {
        return null;
    }
}
