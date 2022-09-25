package com.example.agenda_curso;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Tela_Consulta extends AppCompatActivity {

    EditText et_nome_consulta, et_telefone_consulta;
    Button btn_anterior_consulta, btn_proximo_consulta, btn_voltar_consulta;
    SQLiteDatabase db=null;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_consulta);

        et_nome_consulta=(EditText)findViewById(R.id.et_nome_consulta);
        et_telefone_consulta=(EditText)findViewById(R.id.et_telefone_consulta);
        btn_anterior_consulta=findViewById(R.id.btn_anterior_consulta);
        btn_proximo_consulta=findViewById(R.id.btn_proximo_consulta);
        btn_voltar_consulta=findViewById(R.id.btn_voltar_consulta);

        buscarDados();
    }

    public void buscarDados(){
        BancoDados.abriDB(this);
        cursor=db.query("contatos",
                new String[]{"nome","fone"},
                null,
                null,
                null,
                null,
                null,
                null
        );
        if (cursor.getCount()!=0){
            cursor.moveToFirst();
            mostrarDados();

        }else{
            CxMsg.mostrar("Nenhum registro encontrado",this);

        }
    }

    public void proximoRegistro(View v){
       try {
           cursor.moveToNext();
           mostrarDados();
       }catch (Exception ex){
           if (cursor.isAfterLast()){
               CxMsg.mostrar("Não existem mais registros",this);
           }else {
               CxMsg.mostrar("Erro ao navegar pelos registros",this);
           }

       }
    }

    public void registroAnterior(View v){
        try {
            cursor.moveToPrevious();
            mostrarDados();
        }catch (Exception ex){
            if (cursor.isBeforeFirst()){
                CxMsg.mostrar("Não existem mais registros",this);
            }else {
                CxMsg.mostrar("Erro ao navegar pelos registros",this);
            }

        }
    }

    @SuppressLint("Range")
    public void mostrarDados(){
       et_nome_consulta.setText(cursor.getString(cursor.getColumnIndex("nome")));
       et_telefone_consulta.setText(cursor.getString(cursor.getColumnIndex("fone")));
    }

    public void fechar_tela_consulta(View v){
        this.finish();
    }


}