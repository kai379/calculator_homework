package com.kai.calculator_homework;

public class CalculatorImpl implements Calculator {
    @Override
    public double performOperation(double argOne, double argTwo, Operation operation) {
        switch (operation) {
            case ADDITION:
                return argOne + argTwo;
            case SUBTRACTION:
                return argOne - argTwo;
            case MULTIPLICATION:
                return argOne * argTwo;
            case DIVISION:
                return argOne / argTwo;
        }
        return 0;
    }
}
