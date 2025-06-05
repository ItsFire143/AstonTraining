package org.example;

public class FactorialOfNumber {
    public long calculateFactorial(int number) throws IllegalAccessException {
        if (number < 0) {
            throw new IllegalAccessException("Нельзя использовать отрицательное число");
        }
        long res = 1;
        for (int i = 2; i <= number; i++) {
            res *= i;
        }
        return res;
    }
}
