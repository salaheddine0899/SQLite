package com.example.tpsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addCli(View view) {
        Intent i=new Intent(MainActivity.this,MainActivity3.class);
        startActivity(i);
    }

    public void displayClis(View view) {
        Intent i=new Intent(MainActivity.this,MainActivity2.class);
        startActivity(i);
    }
}