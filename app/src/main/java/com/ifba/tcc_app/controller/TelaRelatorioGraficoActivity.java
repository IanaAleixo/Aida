package com.ifba.tcc_app.controller;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.facebook.drawee.view.SimpleDraweeView;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.ifba.tcc_app.R;
import com.ifba.tcc_app.model.ImagemGif;
import com.ifba.tcc_app.model.Status;
import com.ifba.tcc_app.model.Usuario;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TelaRelatorioGraficoActivity extends AppCompatActivity {
    private  BarChart barChart;
    private ImageButton btnCompartilhar;
    private ImageButton btnVoltar;
    private StatusDAO statusDAO;
    private List<Status> status;
    private ArrayList<CategoriaDAO> categorias;
    ArrayList<BarEntry> entradasBarChart;
    ArrayList<String> statusBarChart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_relatorio_grafico);

        statusDAO = new StatusDAO(this);
        status = new ArrayList<>();
        categorias = new ArrayList<>();

        barChart = (BarChart) findViewById(R.id.barChart);

        entradasBarChart = new ArrayList<>();
        statusBarChart = new ArrayList<>();

        status = statusDAO.getAllStatus();

        int contFelicidade = 0;
        int contAlegria = 0;
        int contAmor = 0;
        int contEsperanca = 0;
        int contTristeza = 0;
        int contMedo = 0;
        int contSolidao = 0;
        int contSono = 0;
        int contRaiva = 0;


        for (int i = 0; i < status.size(); i++){
            if (status.get(i).getSentimento().equals("felicidade")){
                contFelicidade = contFelicidade +1;
            }
            if (status.get(i).getSentimento().equals("alegria")){
                contAlegria = contAlegria +1;
            }
            if (status.get(i).getSentimento().equals("amor")){
                contAmor = contAmor +1;
            }
            if (status.get(i).getSentimento().equals("esperança")){
                contEsperanca = contEsperanca +1;
            }
            if (status.get(i).getSentimento().equals("tristeza")){
                contTristeza = contTristeza +1;
            }
            if (status.get(i).getSentimento().equals("medo")){
                contMedo = contMedo +1;
            }
            if (status.get(i).getSentimento().equals("solidão")){
                contSolidao = contSolidao +1;
            }
            if (status.get(i).getSentimento().equals("sonolencia")){
                contSono = contSono +1;
            }
            if (status.get(i).getSentimento().equals("raiva")){
                contRaiva = contRaiva +1;
            }

        }

        statusBarChart.add(0,"Felicidade");
        statusBarChart.add(1,"Alegria");
        statusBarChart.add(2,"Amor");
        statusBarChart.add(3,"Esperança");
        statusBarChart.add(4,"Tristeza");
        statusBarChart.add(5,"Medo");
        statusBarChart.add(6,"Solidão");
        statusBarChart.add(7,"Sonolência");
        statusBarChart.add(8,"Raiva");


        for (int i = 0; i < statusBarChart.size(); i++){
            if (statusBarChart.get(i).equals("Felicidade")){
                entradasBarChart.add(new BarEntry(i, contFelicidade));
            }
            if (statusBarChart.get(i).equals("Alegria")){
                entradasBarChart.add(new BarEntry(i, contAlegria));
            }
            if (statusBarChart.get(i).equals("Amor")){
                entradasBarChart.add(new BarEntry(i, contAmor));
            }
            if (statusBarChart.get(i).equals("Esperança")){
                entradasBarChart.add(new BarEntry(i, contEsperanca));
            }
            if (statusBarChart.get(i).equals("Tristeza")){
                entradasBarChart.add(new BarEntry(i, contTristeza));
            }
            if (statusBarChart.get(i).equals("Medo")){
                entradasBarChart.add(new BarEntry(i, contMedo));
            }
            if (statusBarChart.get(i).equals("Solidão")){
                entradasBarChart.add(new BarEntry(i, contSolidao));
            }
            if (statusBarChart.get(i).equals("Sonolência")){
                entradasBarChart.add(new BarEntry(i, contSono));
            }
            if (statusBarChart.get(i).equals("Raiva")){
                entradasBarChart.add(new BarEntry(i, contRaiva));
            }
        }

        BarDataSet barDataSet = new BarDataSet(entradasBarChart, "Status");
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);

        BarData barData = new BarData(barDataSet);

        barChart.setFitBars(true);
        barChart.setData(barData);
        barChart.getDescription().setText("Status");
        barChart.animateY(2000);
        barChart.invalidate();

        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(statusBarChart));

        xAxis.setPosition(XAxis.XAxisPosition.TOP);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(false);
        xAxis.setGranularity(1f);
        xAxis.setLabelCount(statusBarChart.size());
        xAxis.setLabelRotationAngle(270);

        btnCompartilhar = findViewById(R.id.btnCompartilhar);
        btnCompartilhar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap icon = barChart.getChartBitmap();
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("image/jpeg");
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                icon.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                if (ActivityCompat.checkSelfPermission(TelaRelatorioGraficoActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(TelaRelatorioGraficoActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
                    return;
                }
                String path = MediaStore.Images.Media.insertImage(getContentResolver(), icon, "Relatório Gráfico", null);
                Uri imageUri =  Uri.parse(path);
                share.putExtra(Intent.EXTRA_STREAM, imageUri);
                startActivity(Intent.createChooser(share, "Compartilhar imagem"));

            }
        });

        btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaRelatorioGraficoActivity.this, TelaAcessoRelatorioActivity.class);
                Usuario usuario = getIntent().getParcelableExtra("usuario");
                intent.putExtra("usuario", usuario);
                startActivity(intent);
            }
        });

    }

}
