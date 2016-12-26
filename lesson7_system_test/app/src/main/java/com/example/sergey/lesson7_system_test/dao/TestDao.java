package com.example.sergey.lesson7_system_test.dao;


import com.example.sergey.lesson7_system_test.entity.Answers;
import com.example.sergey.lesson7_system_test.entity.Question;
import com.example.sergey.lesson7_system_test.entity.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TestDao implements DAO<Test> {
    QuestionDao questionDao = new QuestionDao();
    Test test;
    static List<Test> testList = new ArrayList<>();


    @Override
    public boolean save(Test test) {
        test.setId(testList.size() + 1);
        return testList.add(test);
    }

    @Override
    public Test findById() {
        return null;
    }

    @Override
    public Collection<Test> getAll() {
        return testList;
    }

    public Test findTest(String s) {
        Test test = getTestByQuestion(s);
        if (test == null) {
            Question q = questionDao.findQuestion(s);
            return saveNameTest(q);
        }
        return test;
    }

    public Test getTestByQuestion(String q) {
        for (Test t : testList) {
            if (t.getNameTest().getNameTestQuestion().equals(q)) {
                return t;
            }
        }
        return null;
    }

    public Test saveNameTest(Question q) {
        test = new Test();
        test.setNameTest(q);
        save(test);
        return test;
    }

    public List<Answers> getAnswearByQuestion(String nameTest) {
        for (Test t : testList) {
            if (t.getNameTest().equals(nameTest)) {
                return t.getAnswers();
            }
        }
        return new ArrayList<>();
    }
}
