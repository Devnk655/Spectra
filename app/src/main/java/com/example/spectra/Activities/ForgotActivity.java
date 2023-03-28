package com.example.spectra.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.spectra.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.shashank.sony.fancytoastlib.FancyToast;

public class ForgotActivity extends AppCompatActivity {
    Button btnforgot;
    EditText edtemail;
    private String email;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);
        auth=FirebaseAuth.getInstance();
        btnforgot=findViewById(R.id.btnforgot);
        edtemail=findViewById(R.id.edtemail);
        btnforgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validatedata();
            }
        });
    }
    public void validatedata(){
        email=edtemail.getText().toString();
        if(email.isEmpty()){
            edtemail.setError("Required");
        }
        else{
            forgotpassword();
        }
    }
    //Password change using email
    private void forgotpassword() {
        auth.sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            FancyToast.makeText(ForgotActivity.this,"Check your email",FancyToast.LENGTH_SHORT,FancyToast.INFO,true).show();
                            startActivity(new Intent(ForgotActivity.this, LoginActivity.class));
                            finish();
                        }
                        else{
                            FancyToast.makeText(ForgotActivity.this, " Error "+task.getException(), FancyToast.LENGTH_SHORT,FancyToast.ERROR,true).show();
                        }
                    }
                });
    }
}