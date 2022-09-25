package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CalendarioAdapter.OnItemListener {

    private TextView mesAnoText;
    private RecyclerView calendarioRecyclerView;
    private LocalDate dataSelecionada;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidgets();
        dataSelecionada = LocalDate.now();
        setMesView();
    }

    private void setMesView() {
        mesAnoText.setText(mesAnofromDate(dataSelecionada));
        ArrayList<String> diasNoMes = diasNoMesArray(dataSelecionada);
        CalendarioAdapter calendarioAdapter = new CalendarioAdapter(diasNoMes, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 7);
        calendarioRecyclerView.setLayoutManager(layoutManager);
        calendarioRecyclerView.setAdapter(calendarioAdapter);

    }

    private ArrayList<String> diasNoMesArray(LocalDate data) {
        ArrayList<String> diasNoMesArray = new ArrayList<>();
        YearMonth yearMonth = YearMonth.from(data);

        int diasNoMes = yearMonth.lengthOfMonth();

        LocalDate primeiroDiaDoMes = dataSelecionada.withDayOfMonth(1);
        int diaDaSemana = primeiroDiaDoMes.getDayOfWeek().getValue();

        for(int i = 1; i <= 42; i++){
            if(i <= diaDaSemana || i > diasNoMes + diaDaSemana){
                diasNoMesArray.add("");
            }else {
                diasNoMesArray.add(String.valueOf(i - diaDaSemana));
            }
        }
        return diasNoMesArray;
    }

    private String mesAnofromDate(LocalDate data)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM yyyy");
        return data.format(formatter);
    }

    private void initWidgets() {
        calendarioRecyclerView = findViewById(R.id.calendarioRecyclerView);
        mesAnoText = findViewById(R.id.tv_mesAno);
    }

    public void mesAnteriorAction(View v){
        dataSelecionada = dataSelecionada.minusMonths(1);
        setMesView();
    }
    public void mesSeguinteAction(View v){
        dataSelecionada = dataSelecionada.plusMonths(1);
        setMesView();
    }


    @Override
    public void onItemClick(int position, String diaText) {
        if(diaText.equals("")){
            String msg = "Data selecionada" + diaText + "  " + mesAnofromDate(dataSelecionada);
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        }
    }
}