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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class register_page extends AppCompatActivity {
    private Button register,login;
    private EditText email,password,cpassword,username;
    private FirebaseAuth auth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        register = findViewById(R.id.register);
        username = findViewById(R.id.username);
        login = findViewById(R.id.login);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        cpassword = findViewById(R.id.cpassword);
        auth = FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(register_page.this,login_page.class));
                finish();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String e = email.getText().toString();
                String p = password.getText().toString();
                String cp = cpassword.getText().toString();
                String user = username.getText().toString();
                HashMap<Object,String> map = new HashMap<>();

                if(!e.isEmpty() && !p.isEmpty() && cp.equals(p) && !user.isEmpty()){
                    map.put("Username",user);
                    map.put("Email",e);
                    map.put("Password",p);
                    FirebaseDatabase.getInstance().getReference().child("users").push().setValue(map);
                    registeruser(e,p);
                }
                else{
                    Toast.makeText(register_page.this, "fill all details correctly", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void registeruser(String u, String p) {
        auth.createUserWithEmailAndPassword(u,p).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(register_page.this, "register successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(register_page.this,entry_activity.class));
                    finish();
                }
            }
        });
    }
}