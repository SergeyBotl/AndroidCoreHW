package com.example.sergey.lesson5;

public class UserDAO {
    private static UserDAO userDAO;

    public static UserDAO getUserDAO() {
        if (userDAO == null) {
            userDAO = new UserDAO();
        }
        return userDAO;
    }

    private User user;

    void save(User u) {
        user = u;
    }

    boolean isLogin(User u) {
        if (user != null && user.equals(u)) {
            return true;
        }
        return false;

    }
}
