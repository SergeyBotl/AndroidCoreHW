package com.example.sergey.lesson7_system_test.entity;

public class QuestionBody {
    private long id;
    private int image;
    private String textQuestion;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

    public QuestionBody() {
    }

    public QuestionBody(long id, int image, String textQuestion, String option1, String option2, String option3, String option4) {
        this.id = id;
        this.image = image;
        this.textQuestion = textQuestion;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
    }

    public QuestionBody(int image, String textQuestion, String option1, String option2, String option3, String option4) {

        this.image = image;
        this.textQuestion = textQuestion;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
    }

    public QuestionBody(int image, String option1, String option2) {
        this.image = image;
        this.option1 = option1;
        this.option2 = option2;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public int getImage() {
        return image;
    }

    public String getTextQuestion() {
        return textQuestion;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }

    @Override
    public String toString() {
        return "QuestionBody{" +
                "id=" + id +
                ", image=" + image +
                ", textQuestion='" + textQuestion + '\'' +
                ", option1='" + option1 + '\'' +
                ", option2='" + option2 + '\'' +
                ", option3='" + option3 + '\'' +
                ", option4='" + option4 + '\'' +
                '}';
    }
}
