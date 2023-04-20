package com.example.zjazd_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity3 extends AppCompatActivity {

    private TextView myTextView;
    private Button myButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        // Get a reference to the TextView and Button
        myTextView = findViewById(R.id.text_przepis);
        myButton = findViewById(R.id.button_przepis_change);

        // Set a click listener on the Button
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Change the text of the TextView
                myTextView.setText(R.string.paragraph_2);
            }
        });
    }
}
