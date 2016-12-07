package com.example.sergey.lesson3extra;

public class Entity {
    private int id;
    private String text;
    private Currency currency;

    public Entity(int id, String text, Currency currency) {
        this.id = id;
        this.text = text;
        this.currency = currency;
    }

    public int getId() {
        return id;
    }

    public Currency getCurrency() {
        return currency;
    }
}
