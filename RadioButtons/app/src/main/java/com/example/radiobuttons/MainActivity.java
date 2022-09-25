package com.example.radiobuttons;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    Button ok;
    Button toast;
    RadioGroup radio_group;
    RadioButton rbtn_green;
    RadioButton rbtn_red;
    RadioButton rbtn_yellow;
    LinearLayout layout;
    ImageView image;
    ToggleButton tbnt_Show;
    Spinner spinner;
    ArrayAdapter adapter;
    EditText et_text;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_text = findViewById(R.id.et_text);
        ok = findViewById(R.id.btn_ok);
        radio_group = findViewById(R.id.radio_group);
        rbtn_green = findViewById(R.id.rbtn_green);
        rbtn_red = findViewById(R.id.rbtn_red);
        rbtn_yellow=findViewById(R.id.rbtn_yellow);

        layout = findViewById(R.id.linear_lay);
        image = findViewById(R.id.image);
        tbnt_Show = findViewById(R.id.tbtn_Show);

        toast = findViewById(R.id.btn_toast);

        spinner = findViewById(R.id.spinner_contry);
        adapter = ArrayAdapter.createFromResource(this, R.array.countries
                , android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
               String country = adapterView.getItemAtPosition(position).toString();
               et_text.setText(country);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        tbnt_Show.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    image.setVisibility(View.INVISIBLE);
                }else{
                    image.setVisibility(View.VISIBLE);
                }
            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rbtn_green.isChecked()){
                    layout.setBackgroundColor(Color.GREEN);
                }
                else if (rbtn_red.isChecked()){
                    layout.setBackgroundColor(Color.RED);
                }
                else if (rbtn_yellow.isChecked()){
                    layout.setBackgroundColor(Color.YELLOW);
                }
            }
        });

        toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Essa é uma Toast message", Toast.LENGTH_LONG).show();
            }
        });
    }
}