package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class tela_sobre extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_sobre);

        Intent it = getIntent();
        String nome = it.getStringExtra("p_nome");
        double valor = it.getDoubleExtra("p_vtotal",0);
        TextView tv = findViewById(R.id.textView2);
        tv.setText(nome + " | " + valor);
    }

    public void Voltar(View v){
        this.finish();
        //Intent it_telaMain = new Intent(this,MainActivity.class);
        //startActivity(it_telaMain);
        //setContentView(R.layout.activity_main);
    }

}