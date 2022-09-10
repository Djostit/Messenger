package com.example.messenger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        toast = Toast.makeText(this, "There's nothing in here.",Toast.LENGTH_SHORT);
    }

    public void SendMessage(View view) {
        Intent intent = new Intent(this, SecondActivity.class);

        String message = editText.getText().toString();
        if (message.isEmpty()){
            toast.show();
            return;
        }

        intent.putExtra("Message", message);
        startActivity(intent);
    }

    public void ExportMessage(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");

        String message = editText.getText().toString();
        if (message.isEmpty()){
            toast.show();
            return;
        }

        intent.putExtra(Intent.EXTRA_TEXT, message);
        startActivity(Intent.createChooser(intent, "Share"));
    }
}