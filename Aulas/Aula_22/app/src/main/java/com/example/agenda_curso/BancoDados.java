package com.example.agenda_curso;
import static android.content.Context.MODE_PRIVATE;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase; // Banco de Dados
import android.database.Cursor; // Navegar entre os registros
import android.content.ContextWrapper;
import android.view.View;


public class BancoDados {

    static SQLiteDatabase db=null;

    public static void abriDB(Activity act){
        try {
            ContextWrapper cw = new ContextWrapper(act);
            db=cw.openOrCreateDatabase("bancoAgenda", MODE_PRIVATE, null);
        }catch (Exception ex){
            CxMsg.mostrar("Erro ao abrir ou criar Banco de Dados",act);
        }

    }
    public static void fecharDB(){
        db.close();
    }

    public static void abrirTabela(Activity act){
        try {
            db.execSQL("CREATE TABLE IF NOT EXISTS contatos (id INTEGER PRIMARY KEY, nome TEXT, fone TEXT);");
        }catch (Exception ex){
            CxMsg.mostrar("Erro ao cria tabela",act);
        }
    }

    public static void inserirRegistro(String nome, String fone,Activity act){
        abriDB(act);
        try {
            db.execSQL("INSERT INTO contatos (nome,fone) VALUES ('" + nome + "','" + fone + "')");
        }catch (Exception ex){
            CxMsg.mostrar("Erro ao inserir registro",act);
        }finally {
            CxMsg.mostrar("Registro inserido com sucesso",act);
        }
        fecharDB();
    }
}
