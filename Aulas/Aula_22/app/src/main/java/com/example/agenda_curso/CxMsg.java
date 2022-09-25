package com.example.agenda_curso;

import android.app.Activity;

import androidx.appcompat.app.AlertDialog;

public class CxMsg {

    Activity act;

    public static void mostrar(String txt, Activity act){
        AlertDialog.Builder adb=new AlertDialog.Builder(act);
        adb.setMessage(txt);
        adb.setNeutralButton("OK",null);
        adb.show();
    }

}
