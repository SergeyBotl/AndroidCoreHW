package com.example.sergey.lesson3.entity;

import android.text.Editable;

public class Text {

    private int id;
    private Editable text;
    private int countSame;

    public Text(Editable text) {
        this.text = text;
    }

    public Text(int id, Editable text, int countSame) {
        this.id = id;
        this.text = text;
        this.countSame = countSame;
    }

    public Editable getText() {
        return text;
    }

    public int getCountSame() {
        return countSame;
    }

    public void setCountSame(int countSame) {
        this.countSame = countSame;
    }



    @Override
    public String toString() {
        return "Text{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", countSame=" + countSame +
                '}';
    }
}
