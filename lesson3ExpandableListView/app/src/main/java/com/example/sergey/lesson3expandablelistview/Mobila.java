package com.example.sergey.lesson3expandablelistview;

import android.text.Editable;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class Mobila   {

    private long id;
    private String mark;
    private List<Model> model;
    private int count;

    public Mobila(long id, String mark, List<Model> model) {
        this.id = id;
        this.mark = mark;
        this.model = model;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public List<Model> getModel() {
        return model;
    }

    public void setModel(List<Model> model) {
        this.model = model;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mobila mobila = (Mobila) o;

        if (mark != null ? !mark.equals(mobila.mark) : mobila.mark != null) return false;
        return model != null ? model.equals(mobila.model) : mobila.model == null;

    }

    @Override
    public int hashCode() {
        int result = mark != null ? mark.hashCode() : 0;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                ", mark=" + mark +
                ", model=" + model +
                '}';
    }
}
