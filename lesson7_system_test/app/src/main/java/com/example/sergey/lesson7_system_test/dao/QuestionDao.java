package com.example.sergey.lesson7_system_test.dao;

import com.example.sergey.lesson7_system_test.entity.Question;
import com.example.sergey.lesson7_system_test.entity.QuestionBody;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class QuestionDao implements DAO<Question> {

    static Set<Question> sets = new HashSet<>();
    static List<Question> list;
    static List<QuestionBody> questionBodyList = new ArrayList<>();

    {

        save(new Question("Test1"));
        save(new Question("Test2"));
        list = new ArrayList<>(sets);
    }

    public void saveBodyQuestion(String s, Set<QuestionBody> qb) {
        for (Question q : getAll()) {
            if (q.getNameTestQuestion().equals(s)) {
                q.setBody(qb);
            }
        }
    }

   public Set<QuestionBody> findBodyByNameTest(String s) {
        for (Question q : sets) {
            if (q.getNameTestQuestion().equals(s)) {
                if (q.getBody()!=null)
                return new HashSet<>(q.getBody());
            }
        }
        return new HashSet<>();
    }

    @Override
    public boolean save(Question question) {
        question.setId(sets.size() + 1);
        return sets.add(question);
    }

    @Override
    public Question findById() {
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        return list = new ArrayList<>(sets);
    }

    public Question getTestByName(String s) {
        for (Question q : list) {
            if (q.getNameTestQuestion().equals(s)) {
                return q;
            }
        }
        return null;
    }

    public Question findQuestion(String s) {
        for (Question q : sets) {
            if (q.getNameTestQuestion().equals(s)) {
                return q;
            }
        }
        return null;
    }
}
