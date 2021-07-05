package com.ifba.tcc_app.controller;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ifba.tcc_app.R;
import com.ifba.tcc_app.model.Usuario;


import org.billthefarmer.view.CalendarListener;
import org.billthefarmer.view.CustomCalendarView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;

public class TelaRelatorioCalendarioActivity extends AppCompatActivity {
    private ImageButton btnVoltar;
    private LinearLayout header;
    private Button btnToday;
    private ImageView btnPrev;
    private ImageView btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_relatorio_calendario);

        CalendarView simpleCalendarView = (CalendarView) findViewById(R.id.calendarView); // get the reference of CalendarView
        long selectedDate = simpleCalendarView.getDate(); // get selected date in milliseconds

        // perform setOnDateChangeListener event on CalendarView
        simpleCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                // display the selected date by using a toast
                Toast.makeText(getApplicationContext(), dayOfMonth + "/" + month + "/" + year, Toast.LENGTH_LONG).show();
            }
        });

        btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaRelatorioCalendarioActivity.this, TelaAcessoRelatorioActivity.class);
                Usuario usuario = getIntent().getParcelableExtra("usuario");
                intent.putExtra("usuario", usuario);
                startActivity(intent);
            }
        });
    }
}
