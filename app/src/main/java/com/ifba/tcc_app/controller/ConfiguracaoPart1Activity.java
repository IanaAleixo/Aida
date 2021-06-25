package com.ifba.tcc_app.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.parser.IntegerParser;
import com.ifba.tcc_app.R;
import com.ifba.tcc_app.model.Configuracao;
import com.ifba.tcc_app.model.Usuario;

public class ConfiguracaoPart1Activity extends AppCompatActivity {
    public CheckBox simAlerta;
    public CheckBox naoAlerta;
    public EditText qntAlerta;
    public CheckBox simWL;
    public CheckBox naoWL;
    public EditText contatoWL;
    public boolean alerta;
    public boolean watchList;
    public ConfiguracaoDAO dao;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_configuracao_parte_1);

        simAlerta = findViewById(R.id.simAlertacheckBox);
        naoAlerta = findViewById(R.id.naoAlertacheckBox);
        qntAlerta = findViewById(R.id.qntAlertaCampo);
        simWL = findViewById(R.id.simWacthListheckBox);
        naoWL = findViewById(R.id.naoWatchListcheckBox);
        contatoWL = findViewById(R.id.cadastroWacthListCampo);

        dao = new ConfiguracaoDAO(this);

        simAlerta.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isChecked())
                {
                    boolean sim  = isChecked;
                    boolean nao = false;

                    simAlerta.setChecked(sim);
                    naoAlerta.setChecked(nao);
                    alerta = true;
                }
            }
        });

        naoAlerta.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isChecked())
                {
                    boolean sim  = isChecked;
                    boolean nao = false;

                    simAlerta.setChecked(nao);
                    naoAlerta.setChecked(sim);
                    alerta = false;
                }
            }
        });

        simWL.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isChecked())
                {
                    boolean sim  = isChecked;
                    boolean nao = false;

                    simWL.setChecked(sim);
                    naoWL.setChecked(nao);
                    watchList = true;
                }
            }
        });

        naoWL.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isChecked())
                {
                    boolean sim  = isChecked;
                    boolean nao = false;

                    simWL.setChecked(nao);
                    naoWL.setChecked(sim);
                    watchList = false;
                }
            }
        });
    }


    public void proximaTelaConfiguracao(View view){
        Usuario usuario = getIntent().getParcelableExtra("usuario");

        Configuracao configuracao = new Configuracao();

        if (alerta){
            configuracao.setAlerta(true);
            configuracao.setQtnAlerta(Integer.parseInt(qntAlerta.getText().toString()));
        }
        else configuracao.setAlerta(false);
        if (watchList){
            configuracao.setWatchList(true);
            configuracao.setContatoWatchList(contatoWL.getText().toString());
        }
        else configuracao.setWatchList(false);
        configuracao.setIdUsuario(usuario.getId());

        dao.inserir(configuracao);

        Intent intent = new Intent(this, ConfiguracaoPart2Activity.class);
        intent.putExtra("usuario", usuario);
        startActivity(intent);
    }
}
