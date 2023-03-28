package com.example.spectra.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.spectra.R;

public class EnterDetailsActivity extends AppCompatActivity {
    Button btnahead;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_details);
        getSupportActionBar().hide();
        btnahead=findViewById(R.id.btnahead);
        btnahead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EnterDetailsActivity.this,FullScreenActivity.class));
            }
        });
    }
}