package com.example.a0_x;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Name extends AppCompatActivity {
    EditText p1,p2;
    Button button;

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
                Name.super.onBackPressed();
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
        setContentView(R.layout.activity_name);

        p1 = findViewById(R.id.p1);
        p2 = findViewById(R.id.p2);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String player1 = p1.getText().toString();
                String player2 = p2.getText().toString();

                Intent intent = new Intent(Name.this, MainActivity.class);
                intent.putExtra("player1",player1);
                intent.putExtra("player2",player2);
                startActivity(intent);
            }
        });

    }
}