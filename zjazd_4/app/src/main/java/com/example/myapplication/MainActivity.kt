package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

import android.widget.Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val button:Button = findViewById(R.id.button)
        val weight: TextView = findViewById(R.id.Weight)
        val height: TextView = findViewById(R.id.Height)
        val text: TextView = findViewById(R.id.textView);



        button.setOnClickListener{
            val weight_value = weight.text.toString().toFloat()
            val height_value = height.text.toString().toFloat()

            val result =  (weight_value/(height_value*2))*100;
            text.setText(result.toString())

        }
    }
}