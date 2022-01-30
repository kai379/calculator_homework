package ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.kai.calculator_homework.R;

public class MainActivity extends AppCompatActivity {

    private TextView resultWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultWindow = findViewById(R.id.result_window);


    }
}