package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class tela_sobre extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_sobre);
    }

    public void Voltar(View v){
        Intent it_telaMain = new Intent(this,MainActivity.class);
        startActivity(it_telaMain);
        //setContentView(R.layout.activity_main);
    }

}