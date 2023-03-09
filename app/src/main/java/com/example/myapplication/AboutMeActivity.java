package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class AboutMeActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);

        MaterialButton addBoton = findViewById(R.id.addBoton);
        MaterialButton notesBoton = findViewById(R.id.notesBoton);

        addBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AboutMeActivity.this,AddNoteActivity.class));
            }
        });

        notesBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AboutMeActivity.this,MainActivity.class));
            }
        });
    }
}

