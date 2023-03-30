package com.example.zjazd_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;


public class Activity1 extends AppCompatActivity {


    private double weight = 0.0;
    private double height = 0.15;

    private TextView heightTextView;
    private TextView weightTextView;
    private TextView totalTextView;

    private EditText weightEditText;
    private EditText heightEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        weightTextView = findViewById(R.id.weightTextView);
        heightTextView = findViewById(R.id.heightTextView);
        totalTextView = findViewById(R.id.totalTextView);
        totalTextView.setText("0");

        weightEditText = findViewById(R.id.weightEditText);
        weightEditText.addTextChangedListener(weightEditTextWatcher);

        heightEditText = findViewById(R.id.heightEditText);
        heightEditText.addTextChangedListener(heightEditTextWatcher);
    }

    private void calculate() {
        double total = weight / (height * height);
        totalTextView.setText(String.format("%.2f", total));
    }

    private final TextWatcher weightEditTextWatcher = new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try {
                weight = Double.parseDouble(s.toString()) / 100.0;
                weightTextView.setText(String.format("%.2f", weight));
            } catch (NumberFormatException e) {
                weightTextView.setText("");
                weight = 0.0;
            }
            calculate();
        }

        @Override
        public void afterTextChanged(Editable s) {
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }
    };

    private final TextWatcher heightEditTextWatcher = new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try {
                height = Double.parseDouble(s.toString()) / 100.0;
                heightTextView.setText(String.format("%.2f", height));
            } catch (NumberFormatException e) {
                heightTextView.setText("");
                height = 0.0;
            }
            calculate();
        }

        @Override
        public void afterTextChanged(Editable s) {
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }
    };

}