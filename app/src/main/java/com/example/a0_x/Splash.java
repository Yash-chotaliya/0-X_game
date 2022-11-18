package com.example.a0_x;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class Splash extends AppCompatActivity {
    TextView t1,t2,t3,t4,t5,t6;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        t2 = findViewById(R.id.t2);
        t1 = findViewById(R.id.t1);
        t3 = findViewById(R.id.t3);
        t5 = findViewById(R.id.t5);
        t4 = findViewById(R.id.t4);
        t6 = findViewById(R.id.t6);

        Animation animation = AnimationUtils.loadAnimation(this,R.anim.animat);
        Animation animation1 = AnimationUtils.loadAnimation(this,R.anim.animate1);

        t1.setAnimation(animation);
        t3.setAnimation(animation);
        t5.setAnimation(animation);
        t2.setAnimation(animation);
        t4.setAnimation(animation);
        t6.setAnimation(animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                t1.setAnimation(animation1);
                t3.setAnimation(animation1);
                t5.setAnimation(animation1);
            }
        },2000);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this,Name.class);
                startActivity(intent);
                finish();
            }
        },4500);
    }
}