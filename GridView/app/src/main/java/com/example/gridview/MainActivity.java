package com.example.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    ArrayList<String> text = new ArrayList<>();
    ArrayList<Integer> image = new ArrayList<>();


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);
        fillArray();
        GridAdapter adapter = new GridAdapter(this, text, image);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),"Você selecionou "+ text.get(i), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void fillArray(){
        text.add("Brazil");
        text.add("Belgium");
        text.add("Ireland");
        text.add("Hungary");

        image.add(R.drawable.brazil);
        image.add(R.drawable.belgium);
        image.add(R.drawable.ireland);
        image.add(R.drawable.hungary);
    }

}