package com.example.agenda_curso;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import android.widget.*;

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

        BancoDados.abriDB(this);
        BancoDados.abrirTabela(this);
        BancoDados.fecharDB();

    }

    public void inserirRegistro(View v){
        String st_nome, st_fone;
        st_nome=et_nome.getText().toString();
        st_fone=et_telefone.getText().toString();
        if (st_nome == "" || st_fone == ""){
            CxMsg.mostrar("Campos não podem estar vazios",this);
            return;
        }

        BancoDados.inserirRegistro(st_nome,st_fone,this);

        et_nome.setText(null);
        et_telefone.setText(null);
    }

    public void abrir_tela_consulta(View v){
        Intent it_tela_consulta=new Intent(this,Tela_Consulta.class);
        startActivity(it_tela_consulta);
    }

    public void fechar_tela(View v){
        this.finish();
    }

}