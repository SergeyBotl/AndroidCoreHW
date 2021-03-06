package com.example.sergey.lesson6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class UserDAO {
    private static UserDAO userDAO;
    private static List<User>list=new ArrayList<>();

    public static UserDAO getUserDAO() {
        if (userDAO==null){
            userDAO=new UserDAO();
        }
        return userDAO;
    }

    void save(User user){
        user.setId(list.size()+1);
        list.add(user);
    }

    List<User> getUser(){
        return list;
    }


    public UserDAO() {
        save(new User("Abramson","Marshman",67567,31,(new Date()),(new ArrayList<>(Arrays.asList("foto1 ","foto2 ")))));
        save(new User("Bradberry","Mercer",45345,32,(new Date()),(new ArrayList<>(Arrays.asList("foto1 ","foto2 ")))));
        save(new User("Berrington","Murphy",87989,26,(new Date()),(new ArrayList<>(Arrays.asList("foto1 ","foto2 ")))));
        save(new User("Finch","Miller",434535,22,(new Date()),(new ArrayList<>(Arrays.asList("foto1 ","foto2 ")))));
        save(new User("Ellington","Ogden",675677,36,(new Date()),(new ArrayList<>(Arrays.asList("foto1 ","foto2 ")))));
        save(new User("Gimson","Otis",876767,42,(new Date()),(new ArrayList<>(Arrays.asList("foto1 ","foto2 ")))));
        save(new User("Gimson","Philips",33455,34,(new Date()),(new ArrayList<>(Arrays.asList("foto1 ","foto2 ")))));
        save(new User("Hardman","Ralphs",4667674,52,(new Date()),(new ArrayList<>(Arrays.asList("foto1 ","foto2 ")))));
        save(new User("Fulton","Roger",2234,74,(new Date()),(new ArrayList<>(Arrays.asList("foto1 ","foto2 ")))));
        save(new User("Ford","Taylor",646777,25,(new Date()),(new ArrayList<>(Arrays.asList("foto1 ","foto2 ")))));
    }


}
