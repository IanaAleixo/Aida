package com.ifba.tcc_app.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.ifba.tcc_app.R;
import com.ifba.tcc_app.model.Configuracao;
import com.ifba.tcc_app.model.Usuario;

public class ConfiguracaoPart2Activity extends AppCompatActivity {
    public CheckBox simContatoEmail;
    public CheckBox naoContatoEmail;
    public EditText qntDiasContato;
    public CheckBox simDicas;
    public CheckBox naoDicas;
    public ConfiguracaoDAO dao;
    public boolean contatoEmail;
    public boolean dicas;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_configuracao_parte_2);

        simContatoEmail = findViewById(R.id.simEmailcheckBox);
        naoContatoEmail = findViewById(R.id.naoEmailcheckBox);
        qntDiasContato = findViewById(R.id.qntDiasEmailCampo);
        simDicas= findViewById(R.id.simDicasCheckBox);
        naoDicas = findViewById(R.id.naoDicasCheckBox);

        dao = new ConfiguracaoDAO(this);

        naoContatoEmail.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isChecked())
                {
                    boolean sim  = isChecked;
                    boolean nao = false;

                    simContatoEmail.setChecked(nao);
                    naoContatoEmail.setChecked(sim);
                    contatoEmail = false;
                }
            }
        });

        simContatoEmail.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isChecked())
                {
                    boolean sim  = isChecked;
                    boolean nao = false;

                    simContatoEmail.setChecked(sim);
                    naoContatoEmail.setChecked(nao);
                    contatoEmail = true;
                }
            }
        });

        simDicas.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isChecked())
                {
                    boolean sim  = isChecked;
                    boolean nao = false;

                    simDicas.setChecked(sim);
                    naoDicas.setChecked(nao);
                    dicas = true;
                }
            }
        });

        naoDicas.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isChecked())
                {
                    boolean sim  = isChecked;
                    boolean nao = false;

                    simDicas.setChecked(nao);
                    naoDicas.setChecked(sim);
                    dicas = true;
                }
            }
        });
    }

    public void salvarConf(View view){
        Usuario usuario = getIntent().getParcelableExtra("usuario");

        Configuracao configuracao = new Configuracao();

        if (contatoEmail){
            configuracao.setReceberEmail(true);
            configuracao.setQtnAlerta(Integer.parseInt(qntDiasContato.getText().toString()));
        }
        else configuracao.setReceberEmail(false);
        if (dicas){
            configuracao.setDicas(true);
        }
        else configuracao.setDicas(false);
        configuracao.setIdUsuario(usuario.getId());

        dao.update(configuracao);

        Intent intent = new Intent(this, TelaPrincipalActivity.class);
        intent.putExtra("usuario", usuario);
        startActivity(intent);
    }
}
