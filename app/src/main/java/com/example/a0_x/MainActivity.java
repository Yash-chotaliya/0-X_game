package com.example.a0_x;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9;
    String s1,s2,s3,s4,s5,s6,s7,s8,s9,x,y;
    TextView name1,name2;
    int set=0;
    int count=0;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
        name1 = findViewById(R.id.name1);
        name2 = findViewById(R.id.name2);

        Intent past = getIntent();
        x = past.getStringExtra("player1");
        y = past.getStringExtra("player2");
        name1.setText(">>" + x + "<<");
        name2.setText(">>" + y + "<<");

    }

    public void Click(View view){
        Button current = (Button) view;
        if(current.getText().toString().equals("")) {
            count++;

            if (set % 2 == 0) {
                current.setText("0");
                set++;
            } else {
                current.setText("X");
                set++;
            }

            if (count > 4) {
                s1 = b1.getText().toString();
                s2 = b2.getText().toString();
                s3 = b3.getText().toString();
                s4 = b4.getText().toString();
                s5 = b5.getText().toString();
                s6 = b6.getText().toString();
                s7 = b7.getText().toString();
                s8 = b8.getText().toString();
                s9 = b9.getText().toString();

                if(s1.equals(s2) && s2.equals(s3) && !s1.isEmpty()){
                    Toast.makeText(this, "winner : " + s1, Toast.LENGTH_SHORT).show();
                    setNull();
                }
                else if(s4.equals(s5) && s5.equals(s6) && !s4.isEmpty()){
                    Toast.makeText(this, "winner : " + s4, Toast.LENGTH_SHORT).show();
                    setNull();
                }
                else if(s7.equals(s8) && s8.equals(s9) && !s7.isEmpty()){
                    Toast.makeText(this, "winner : " + s7, Toast.LENGTH_SHORT).show();
                    setNull();
                }
                else if(s1.equals(s4) && s4.equals(s7) && !s1.isEmpty()){
                    Toast.makeText(this, "winner : " + s1, Toast.LENGTH_SHORT).show();
                    setNull();
                }
                else if(s2.equals(s5) && s5.equals(s8) && !s2.isEmpty()){
                    Toast.makeText(this, "winner : " + s2, Toast.LENGTH_SHORT).show();
                    setNull();
                }
                else if(s3.equals(s6) && s6.equals(s9) && !s3.isEmpty()){
                    Toast.makeText(this, "winner : " + s3, Toast.LENGTH_SHORT).show();
                    setNull();
                }
                else if(s1.equals(s5) && s5.equals(s9) && !s1.isEmpty()){
                    Toast.makeText(this, "winner : " + s1, Toast.LENGTH_SHORT).show();
                    setNull();
                }
                else if(s3.equals(s5) && s5.equals(s7) && !s3.isEmpty()){
                    Toast.makeText(this, "winner : " + s3, Toast.LENGTH_SHORT).show();
                    setNull();
                }

                if(!s1.equals("") && !s2.equals("") && !s3.equals("") && !s4.equals("") && !s5.equals("") && !s6.equals("") && !s7.equals("") && !s8.equals("") && !s9.equals("")){
                    Toast.makeText(this,"Tie",Toast.LENGTH_SHORT).show();
                    setNull();
                }

            }

        }
    }

    private void setNull() {
        b1.setText("");
        b2.setText("");
        b3.setText("");
        b4.setText("");
        b5.setText("");
        b6.setText("");
        b7.setText("");
        b8.setText("");
        b9.setText("");
    }
}