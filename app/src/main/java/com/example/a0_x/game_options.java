package com.example.a0_x;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class game_options extends AppCompatActivity {
    Button play,contactus;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_options);

        play = findViewById(R.id.play);
        contactus = findViewById(R.id.contactus);

        play.setOnClickListener(view -> {
            Sounds.clicked(view.getContext());
            Intent intent = new Intent(game_options.this,Name.class);
            startActivity(intent);
        });

        contactus.setOnClickListener(view -> {
            Sounds.clicked(view.getContext());
            Intent intent = new Intent(game_options.this,contactus_page.class);
            startActivity(intent);
        });
    }
}