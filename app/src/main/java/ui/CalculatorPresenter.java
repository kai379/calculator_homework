package ui;

import com.kai.calculator_homework.Calculator;
import com.kai.calculator_homework.Operation;

public class CalculatorPresenter {

    private CalculatorView view;
    private Calculator calculator;
    private Double argOne = 0.0;
    private Double argTwo = null;
    private Operation previousOperation = null;


    public CalculatorPresenter(CalculatorView view, Calculator calculator) {
        this.view = view;
        this.calculator = calculator;
    }


    // TODO: логика работы
    public void onDotPressed() {
    }


    public void onDigitPressed(int digit) {

        if (previousOperation != null) {
            argTwo = argTwo * 10 + digit;
            view.showResult(String.valueOf(argTwo));
        } else {
            argOne = argOne * 10 + digit;
            view.showResult(String.valueOf(argOne));
        }
    }


    public void onOperandPressed(Operation operation) {

        if (argTwo != null) {
            double result = calculator.performOperation(argOne, argTwo, previousOperation);
            view.showResult(String.valueOf(result));

            argOne = result;
            argTwo = null;
        } else {
            argTwo = 0.0;
            previousOperation = operation;
        }

    }


    //СБРОС
    public void onClearPressed() {

        argOne = 0.0;
        argTwo = null;
        previousOperation = null;
        view.showResult(String.valueOf(argOne));
    }


    //РАВНО
    // TODO: убрать деление и умножение на ноль при нажатии после нажатия на кнопку оператора
    public void onFinalValuePressed() {

        if (argTwo != null) {
            double result = calculator.performOperation(argOne, argTwo, previousOperation);
            view.showResult(String.valueOf(result));
            argOne = result;
            argTwo = null;
            previousOperation = null;
        } else {
            view.showResult(String.valueOf(argOne));
            argTwo = null;
            previousOperation = null;
        }


    }


    //УДАЛИТЬ ПОСЛЕДНИЙ ЗНАК (заморожено до лучших времён)
    public void onDeleteLastFigurePressed() {
        // TODO: логика удаления знака
    }
}
