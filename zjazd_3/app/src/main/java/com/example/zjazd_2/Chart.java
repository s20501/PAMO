package com.example.zjazd_2;

import android.os.Bundle;
import android.view.View;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class Chart extends AppCompatActivity {




    ArrayList barArraylist;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chart);
        BarChart barChart = findViewById(R.id.barchart);
        getData();
        BarDataSet barDataSet = new BarDataSet(barArraylist,"BMI WYKRES");
        BarData barData = new BarData(barDataSet);
        barChart.setData(barData);
        //color bar data set
        barDataSet.setColors(ColorTemplate.LIBERTY_COLORS);
        //text color
        barDataSet.setValueTextColor(Color.BLACK);
        //settting text size
        barDataSet.setValueTextSize(16f);


    }

    private void getData()
    {
        barArraylist = new ArrayList();
        barArraylist.add(new BarEntry(1,24));
        barArraylist.add(new BarEntry(2,26));
        barArraylist.add(new BarEntry(3,30));
        barArraylist.add(new BarEntry(4,31));
        barArraylist.add(new BarEntry(5,32));

    }

}
