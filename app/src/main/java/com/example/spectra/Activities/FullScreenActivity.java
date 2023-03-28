package com.example.spectra.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import com.example.spectra.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class FullScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen);
        getSupportActionBar().hide();
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
                
        BarChart barChart = findViewById(R.id.barchart);
        ArrayList<BarEntry> vistiors  = new ArrayList<>();
        vistiors.add(new BarEntry(2020,10000));
        vistiors.add(new BarEntry(2021,1000));
        vistiors.add(new BarEntry(2022,10000));
        vistiors.add(new BarEntry(2023,9658));

        BarDataSet barDataSet = new BarDataSet(vistiors,"Profit");
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.WHITE);
        barDataSet.setValueTextColor((int) 16f);

        BarData barData = new BarData(barDataSet);
        barChart.setFitBars(true);
        barChart.setData(barData);
        barChart.getDescription().setText("Profit");
        barChart.animateY(2000);


        @SuppressLint({"MissingInflatedId", "LocalSuppress"})

        PieChart pieChart = findViewById(R.id.piechart);
        ArrayList<PieEntry> pieentries  = new ArrayList<>();
        pieentries.add(new PieEntry(45,"2020"));
        pieentries.add(new PieEntry(50,"2021"));
        pieentries.add(new PieEntry(47,"2022"));
        pieentries.add(new PieEntry(49,"2023"));

        PieDataSet pieDataSet = new PieDataSet(pieentries,"Grosss Margin");
        pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        pieDataSet.setValueTextColor(Color.BLACK);
        pieDataSet.setValueTextSize(16f);
         PieData pieData = new PieData(pieDataSet);
         pieChart.setData(pieData);
         pieChart.getDescription().setEnabled(false);
         pieChart.setCenterText("Gross Margin");
         pieChart.animate();



    }
}