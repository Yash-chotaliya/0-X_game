package com.example.a0_x;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Name extends AppCompatActivity {
    EditText p1,p2,target;
    Button button;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        p1 = findViewById(R.id.p1);
        p2 = findViewById(R.id.p2);
        button = findViewById(R.id.button);
        target = findViewById(R.id.target);

        button.setOnClickListener(view -> {
            String player1 = p1.getText().toString();
            String player2 = p2.getText().toString();
            String tar = target.getText().toString();

            if(player1.isEmpty() || player2.isEmpty() || tar.isEmpty()){
                Toast.makeText(Name.this, "Enter Name Correctly", Toast.LENGTH_SHORT).show();
            }
            else{
                Sounds.clicked(view.getContext());
                Intent intent = new Intent(Name.this, MainActivity.class);
                intent.putExtra("player1",player1);
                intent.putExtra("player2",player2);
                intent.putExtra("tar",tar);
                startActivity(intent);
                finish();
            }
        });

    }
}