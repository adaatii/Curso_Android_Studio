package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText name;
    Button btn_activity;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.et_activity);
        btn_activity = findViewById(R.id.btn_activity);

    }
    public void openActivity(View v){

        String userName = name.getText().toString();
        Intent it = new Intent(this, SecondActivity.class);
        it.putExtra("keyword", userName);
        startActivity(it);
    }
}