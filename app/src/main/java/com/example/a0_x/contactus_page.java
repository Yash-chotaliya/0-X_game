package com.example.a0_x;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class contactus_page extends AppCompatActivity {
    private EditText msg;
    private Button send;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus_page);
        msg = findViewById(R.id.msg);
        send = findViewById(R.id.send);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"yashchotaliya187@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT,"0_X game related");
                intent.putExtra(Intent.EXTRA_TEXT,msg.getText().toString());
                startActivity(Intent.createChooser(intent,"Email via"));
            }
        });
    }
}