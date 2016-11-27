package com.example.sergey.samos;

public class Value {
    private float numerator;
    private float denominator;
    private double value;
    private String operation;



    public Value(float numerator, float denominator, double value, String operation) {
        this.numerator = numerator;
        this.denominator = denominator;
        this.value = value;
        this.operation = operation;
    }

      @Override
    public String toString() {
        return
                numerator + operation
                        + denominator +
                        " = " + value +
                        "\n";
    }
}