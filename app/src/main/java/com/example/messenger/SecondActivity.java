package com.example.messenger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView textViewMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textViewMessage = findViewById(R.id.textViewMessage);

        Bundle arguments = getIntent().getExtras();
        String message = arguments.get("Message").toString();

        textViewMessage.setText(message);
    }
}