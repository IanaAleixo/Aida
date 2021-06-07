package com.ifba.tcc_app.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.ifba.tcc_app.R;

public class BemVindoActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_bem_vindo);

        ImageButton botaoProximo = (ImageButton) findViewById(R.id.btnProximo);

    }
    public void onItemClick(View view){
        Intent intent = new Intent(this, BemVindoPart2Activity.class);
        startActivity(intent);
    }


}
