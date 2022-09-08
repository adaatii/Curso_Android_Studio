package com.example.agenda_curso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et_nome, et_telefone;
    Button btn_gravar, btn_consultar, btn_fechar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_nome=(EditText)findViewById(R.id.et_nome);
        et_telefone=(EditText)findViewById(R.id.et_telefone);
        btn_gravar=findViewById(R.id.btn_gravar);
        btn_consultar=findViewById(R.id.btn_consultar);
        btn_fechar=findViewById(R.id.btn_fechar);



    }
}