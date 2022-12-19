package com.example.a0_x;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login_page extends AppCompatActivity {
    private Button login,register;
    private EditText user,password;
    private FirebaseAuth auth;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        login = findViewById(R.id.login);
        register = findViewById(R.id.register);
        user = findViewById(R.id.user);
        password = findViewById(R.id.password);
        auth = FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String u = user.getText().toString();
                String p = password.getText().toString();

                if(u.isEmpty() || p.isEmpty() ){
                    Toast.makeText(login_page.this, "enter correct user/password", Toast.LENGTH_SHORT).show();
                }
                else{
                    loginuser(u,p);
                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(login_page.this,register_page.class));
                finish();
            }
        });
    }

    private void loginuser(String u, String p) {
        auth.signInWithEmailAndPassword(u,p).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(login_page.this, "login successfull", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(login_page.this,game_options.class));
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(login_page.this, "user not available", Toast.LENGTH_SHORT).show();
            }
        });
    }
}