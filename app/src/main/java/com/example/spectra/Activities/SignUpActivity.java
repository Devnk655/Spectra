package com.example.spectra.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.spectra.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.shashank.sony.fancytoastlib.FancyToast;

public class SignUpActivity extends AppCompatActivity {
    EditText edtname,edtemail,edtpassword;
    private FirebaseAuth firebaseAuth;
    SharedPreferences sharedPreferences;
    TextView txtlogin;
    Button btnlogin;
    ProgressBar progressbar;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().hide();
        firebaseAuth=FirebaseAuth.getInstance();
        edtname=findViewById(R.id.edtname);
        edtemail=findViewById(R.id.edtemail);
        edtpassword=findViewById(R.id.edtpassword);
        btnlogin=findViewById(R.id.btnlogin);
        txtlogin = findViewById(R.id.txtlogin);
        progressbar=findViewById(R.id.progressBar3);
        progressbar.setVisibility(View.GONE);
        btnlogin=findViewById(R.id.btnlogin);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName=edtname.getText().toString();
                String userEmail=edtemail.getText().toString();
                String userPassword=edtpassword.getText().toString();
                if(TextUtils.isEmpty(userName)){
                    FancyToast.makeText(SignUpActivity.this,"Enter the name",FancyToast.LENGTH_LONG,FancyToast.INFO,true).show();
                    return;
                }
                if(TextUtils.isEmpty(userEmail)){
                    FancyToast.makeText(SignUpActivity.this,"Enter the mail",FancyToast.LENGTH_LONG,FancyToast.INFO,true).show();
                    return;
                }
                if(userPassword.length()<6){
                    FancyToast.makeText(SignUpActivity.this,"Enter the password", FancyToast.LENGTH_LONG,FancyToast.INFO,true).show();
                    return;
                }
                progressbar.setVisibility(View.VISIBLE);
                firebaseAuth.createUserWithEmailAndPassword(userEmail,userPassword)
                        .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    FancyToast.makeText(SignUpActivity.this,"Successfully Registered",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show();
                                    startActivity(new Intent(SignUpActivity.this, SelectCategory.class));
                                    progressbar.setVisibility(View.GONE);
                                }else{
                                    progressbar.setVisibility(View.GONE);
                                    FancyToast.makeText(SignUpActivity.this,"Registered Failed !",FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();
                                }
                            }
                        });
            }
        });
        txtlogin = findViewById(R.id.txtlogin);
        txtlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpActivity.this,LoginActivity.class));
            }
        });
    }
}