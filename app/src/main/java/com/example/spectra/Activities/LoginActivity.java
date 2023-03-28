package com.example.spectra.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.spectra.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.shashank.sony.fancytoastlib.FancyToast;

public class LoginActivity extends AppCompatActivity {
    EditText edtemail, edtpassword;
    Button btnlogin;
    ProgressBar progressBar3;
    private FirebaseAuth firebaseAuth;
    TextView txtsignup, txtforgotpassword;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        firebaseAuth = FirebaseAuth.getInstance();
        edtemail = findViewById(R.id.edtemail);
        edtpassword = findViewById(R.id.edtpassword);
        btnlogin = findViewById(R.id.btnlogin);
        progressBar3 = findViewById(R.id.progressBar3);
        progressBar3.setVisibility(View.GONE);
        txtsignup = findViewById(R.id.txtsignup);
        txtforgotpassword=findViewById(R.id.txtforgotpassword);
        txtsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
        txtforgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, ForgotActivity.class));
            }
        });
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userEmail = edtemail.getText().toString();
                String userPassword = edtpassword.getText().toString();
                if (TextUtils.isEmpty(userEmail)) {
                    FancyToast.makeText(LoginActivity.this, "Enter the name",FancyToast.LENGTH_SHORT,FancyToast.WARNING,true).show();
                    return;
                }
                if (userPassword.length() < 6) {
                    FancyToast.makeText(LoginActivity.this, "Password too short password should be of atleast 6 characters", FancyToast.LENGTH_SHORT,FancyToast.WARNING,true ).show();
                    return;
                }
                progressBar3.setVisibility(View.VISIBLE);
                //firebaseauthenication that is for checking that it will help for loging in.
                firebaseAuth.signInWithEmailAndPassword(userEmail, userPassword)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    FancyToast.makeText(LoginActivity.this, "Successfully Login", FancyToast.LENGTH_SHORT,FancyToast.SUCCESS,true).show();
                                    startActivity(new Intent(LoginActivity.this, SelectCategory.class));
                                    progressBar3.setVisibility(View.GONE);
                                } else {
                                    FancyToast.makeText(LoginActivity.this, "Error!" + task.getException(), FancyToast.LENGTH_SHORT,FancyToast.ERROR,true).show();
                                    progressBar3.setVisibility(View.GONE);
                                }

                            }
                        });
            }
        });
    }
}