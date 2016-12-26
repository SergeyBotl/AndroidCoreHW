package com.example.sergey.lesson7_system_test.entity;

import java.util.List;

public class Test {

    private long id;
    private User user;
    private Question nameTest;
    private List<Answers> answers;

    public Test() {

    }

    public Test(long id, Question nameTest, List<Answers> answers) {
        this.id = id;
        this.nameTest = nameTest;
        this.answers = answers;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Question getNameTest() {
        return nameTest;
    }

    public void setNameTest(Question nameTest) {
        this.nameTest = nameTest;
    }

    public List<Answers> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answers> answers) {
        this.answers = answers;
    }
}
