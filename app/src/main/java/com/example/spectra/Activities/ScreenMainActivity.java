package com.example.spectra.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.spectra.R;
import com.shashank.sony.fancytoastlib.FancyToast;

public class ScreenMainActivity extends AppCompatActivity {
    CardView cardView;
    Button btninvest;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_main);
        getSupportActionBar().hide();
        cardView=findViewById(R.id.cardView);
        btninvest=findViewById(R.id.btninvest);
        btninvest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ScreenMainActivity.this,InvestingActivity.class));
                Toast.makeText(ScreenMainActivity.this, "Added to invest", Toast.LENGTH_SHORT).show();
            }
        });
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ScreenMainActivity.this,StartupDetails.class));
            }
        });
    }
}