package com.example.sergey.lesson4extra;

import java.util.ArrayList;
import java.util.List;

public class DAOuser {

    static List<User> list = new ArrayList<>();

    void save(User u) {
        u.setId(list.size()+1);
        list.add(u);
    }

    public List<User> getList() {
        return list;
    }

    boolean ifThereUser(User user) {
        for (User u : list) {
            if (u.equals(user)) {
                return true;
            }
        }
        return false;
    }

   boolean userRegistration(User user){

       return false;
   }

}
