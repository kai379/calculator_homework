package ui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.kai.calculator_homework.CalculatorImpl;
import com.kai.calculator_homework.Operation;
import com.kai.calculator_homework.R;

import java.util.HashMap;

public class CalculatorActivity extends AppCompatActivity implements CalculatorView {

    private TextView txtResult;

    private CalculatorPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new CalculatorPresenter(this, new CalculatorImpl());

        txtResult = findViewById(R.id.result_window);

        //ТОЧКА
        findViewById(R.id.num_dot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onDotPressed();
            }
        });

        //КНОПКА: СБРОС ЗНАЧЕНИЙ
        findViewById(R.id.clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClearPressed();
            }
        });

        //КНОПКА: РАВНО
        findViewById(R.id.num_final_value).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onFinalValuePressed();
            }
        });

        //КНОПКА: УДАЛИТЬ ПОСЛЕДНИЙ ЗНАК
        findViewById(R.id.delete_last_figure).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onDeleteLastFigurePressed();
            }
        });

        HashMap<Integer, Integer> digits = new HashMap<>();
        digits.put(R.id.num_0, 0);
        digits.put(R.id.num_1, 1);
        digits.put(R.id.num_2, 2);
        digits.put(R.id.num_3, 3);
        digits.put(R.id.num_4, 4);
        digits.put(R.id.num_5, 5);
        digits.put(R.id.num_6, 6);
        digits.put(R.id.num_7, 7);
        digits.put(R.id.num_8, 8);
        digits.put(R.id.num_9, 9);


        View.OnClickListener digitClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onDigitPressed(digits.get(v.getId()));
            }
        };

        findViewById(R.id.num_0).setOnClickListener(digitClickListener);
        findViewById(R.id.num_1).setOnClickListener(digitClickListener);
        findViewById(R.id.num_2).setOnClickListener(digitClickListener);
        findViewById(R.id.num_3).setOnClickListener(digitClickListener);
        findViewById(R.id.num_4).setOnClickListener(digitClickListener);
        findViewById(R.id.num_5).setOnClickListener(digitClickListener);
        findViewById(R.id.num_6).setOnClickListener(digitClickListener);
        findViewById(R.id.num_7).setOnClickListener(digitClickListener);
        findViewById(R.id.num_8).setOnClickListener(digitClickListener);
        findViewById(R.id.num_9).setOnClickListener(digitClickListener);

        HashMap<Integer, Operation> operands = new HashMap<>();
        operands.put(R.id.num_plus, Operation.ADDITION);
        operands.put(R.id.num_minus, Operation.SUBTRACTION);
        operands.put(R.id.num_multiplication, Operation.MULTIPLICATION);
        operands.put(R.id.num_division, Operation.DIVISION);

        View.OnClickListener operandClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onOperandPressed(operands.get(v.getId()));
            }
        };

        findViewById(R.id.num_plus).setOnClickListener(operandClickListener);
        findViewById(R.id.num_minus).setOnClickListener(operandClickListener);
        findViewById(R.id.num_multiplication).setOnClickListener(operandClickListener);
        findViewById(R.id.num_division).setOnClickListener(operandClickListener);

    }

    @Override
    public void showResult(String value) {
        txtResult.setText(value);
    }
}
