package com.example.aula01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    double num1, num2, res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button btn_somar=(Button)findViewById(R.id.btnSomar);
        Button btn_subtrair=(Button)findViewById(R.id.btnSubtrair);
        Button btn_multiplicar=(Button)findViewById(R.id.btnMultiplicar);
        Button btn_dividir=(Button)findViewById(R.id.btnDividir);

        TextView tv_resultado=(TextView)findViewById(R.id.tv_resultado);
        EditText et_valor1=(EditText) findViewById(R.id.et_valor1);
        EditText et_valor2=(EditText) findViewById(R.id.et_valor2);

        btn_somar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                num1=Double.parseDouble((et_valor1.getText().toString()));
                num2=Double.parseDouble((et_valor2.getText().toString()));
                res = num1 + num2;
                tv_resultado.setText(String.valueOf(res));
            }
        });
        btn_subtrair.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                num1=Double.parseDouble((et_valor1.getText().toString()));
                num2=Double.parseDouble((et_valor2.getText().toString()));
                res = num1 - num2;
                tv_resultado.setText(String.valueOf(res));
            }
        });
        btn_multiplicar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                num1=Double.parseDouble((et_valor1.getText().toString()));
                num2=Double.parseDouble((et_valor2.getText().toString()));
                res = num1 * num2;
                tv_resultado.setText(String.valueOf(res));
            }
        });
        btn_dividir.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                num1=Double.parseDouble((et_valor1.getText().toString()));
                num2=Double.parseDouble((et_valor2.getText().toString()));
                res = num1 / num2;
                tv_resultado.setText(String.valueOf(res));
            }
        });




    }


}