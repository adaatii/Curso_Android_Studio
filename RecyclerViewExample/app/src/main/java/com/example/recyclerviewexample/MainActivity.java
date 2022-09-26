package com.example.recyclerviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;

    private ArrayList<String> countryNameList = new ArrayList<>();
    private ArrayList<String> detailsList = new ArrayList<>();
    private ArrayList<Integer> imageList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        countryNameList.add("Brazil");
        countryNameList.add("Ireland");
        countryNameList.add("Belgium");

        detailsList.add("This is the Brazil flag");
        detailsList.add("This is the Ireland flag");
        detailsList.add("This is the Belgium flag");

        imageList.add(R.drawable.brazil);
        imageList.add(R.drawable.ireland);
        imageList.add(R.drawable.belgium);

        adapter = new RecyclerAdapter(countryNameList, detailsList, imageList, MainActivity.this);
        recyclerView.setAdapter(adapter);
    }
}