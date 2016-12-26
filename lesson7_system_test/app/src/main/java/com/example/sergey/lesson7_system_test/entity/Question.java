package com.example.sergey.lesson7_system_test.entity;

import java.util.ArrayList;

import java.util.Set;


public class Question {

    private long id;
    private String nameTestQuestion;
    private ArrayList<QuestionBody> body;

    public Question(String nameTestQuestion) {
        this.nameTestQuestion = nameTestQuestion;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getNameTestQuestion() {
        return nameTestQuestion;
    }

    public ArrayList<QuestionBody> getBody() {
        return body;
    }

    public void setBody(Set<QuestionBody> body) {
        this.body = new ArrayList<>(body);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        return nameTestQuestion != null ? nameTestQuestion.equals(question.nameTestQuestion) : question.nameTestQuestion == null;
    }

    @Override
    public int hashCode() {
        return nameTestQuestion != null ? nameTestQuestion.hashCode() : 0;
    }

    @Override
    public String toString() {
        return  nameTestQuestion ;
    }
}
