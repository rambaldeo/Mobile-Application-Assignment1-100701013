package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1 = findViewById(R.id.homepage);;
        b1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent ToNewNote = new Intent(MainActivity.this,calculateepage.class);
                        startActivity(ToNewNote);
                    }
                }
        );//SetOnClickListener function
    }
}