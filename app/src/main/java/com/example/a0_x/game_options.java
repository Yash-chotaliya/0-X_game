package com.example.a0_x;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class game_options extends AppCompatActivity {
    private Button play,contactus,logout,allusers;
    @Override
    public void onBackPressed() {

        AlertDialog.Builder exit  = new AlertDialog.Builder(this);
        exit.setCancelable(false);

        exit.setIcon(R.drawable.ic_baseline_exit_to_app_24);
        exit.setTitle("EXIT");
        exit.setMessage("are you sure about your decision ?");

        exit.setPositiveButton("exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                game_options.super.onBackPressed();
            }
        });

        exit.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        exit.show();
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_options);

        play = findViewById(R.id.play);
        contactus = findViewById(R.id.contactus);
        logout = findViewById(R.id.logout);
        allusers = findViewById(R.id.allusers);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(game_options.this,Name.class);
                startActivity(intent);
            }
        });

        contactus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(game_options.this,contactus_page.class);
                startActivity(intent);
            }
        });

        allusers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(game_options.this,allusers.class));
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(game_options.this,login_page.class));
                finish();
            }
        });
    }
}