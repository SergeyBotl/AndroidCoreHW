package com.example.sergey.lesson4extra;

public class CurrentUser {
    DAOuser daOuser = new DAOuser();

    private static User userRegistry;


    public boolean logIn(User user) {
        if (daOuser.ifThereUser(user)) {
            userRegistry = user;
            return true;
        }
        return false;
    }

    public User getUserRegistry() {
        return userRegistry;
    }


}
