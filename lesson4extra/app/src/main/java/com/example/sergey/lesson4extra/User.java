package com.example.sergey.lesson4extra;

public class User {

    private long id;
    private String logIn;
    private String passward;

    public User(long id, String logIn, String passward) {
        this.id = id;
        this.logIn = logIn;
        this.passward = passward;
    }

    public User(String logIn, String passward) {
        this.logIn = logIn;
        this.passward = passward;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogIn() {
        return logIn;
    }

    public void setLogIn(String logIn) {
        this.logIn = logIn;
    }

    public String getPassward() {
        return passward;
    }

    public void setPassward(String passward) {
        this.passward = passward;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (logIn != null ? !logIn.equals(user.logIn) : user.logIn != null) return false;
        return passward != null ? passward.equals(user.passward) : user.passward == null;

    }

    @Override
    public int hashCode() {
        int result = logIn != null ? logIn.hashCode() : 0;
        result = 31 * result + (passward != null ? passward.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", logIn='" + logIn + '\'' +
                ", passward=" + passward +
                '}';
    }
}
