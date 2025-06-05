package org.example;

public class ArithmeticOps {
    public int add(int a, int b){
        return a + b;
    }

    public int substract (int a, int b) {
        return a - b;
    }

    public int multiply (int a, int b) {
        return a * b;
    }

    public Double divide(int a, int b) {
        if (b == 0) return null;
        return (double) a/b;
    }
}
