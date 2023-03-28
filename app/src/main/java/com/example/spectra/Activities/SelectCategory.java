package com.example.spectra.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.spectra.R;

public class SelectCategory extends AppCompatActivity {
    Button btngo;
    RadioButton investor,founder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_category);
        getSupportActionBar().hide();
        btngo=findViewById(R.id.btn_go);
        investor=findViewById(R.id.investor);
        founder=findViewById(R.id.Founder);
        btngo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = "Select Your Category: ";
                result += (investor.isChecked()) ? "Investor" : (founder.isChecked()) ? "Founder" : "";
            }
        });

    }
    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        String str="";
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.investor:
                if(checked)
                    str = "Investor is Selected";
                startActivity(new Intent(SelectCategory.this,ScreenMainActivity.class));
                break;
            case R.id.Founder:
                if(checked)
                    str = "Founder is Selected";
                startActivity(new Intent(SelectCategory.this,EnterDetailsActivity.class));
        }
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
     }
}
