package com.ifba.tcc_app.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ifba.tcc_app.R;
import com.ifba.tcc_app.model.Usuario;

public class CadastroActivity extends AppCompatActivity {

    public EditText nome;
    public EditText email;
    private EditText senha;
    private UsuarioDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        nome = findViewById(R.id.nomeCadastroCampo);
        email = findViewById(R.id.emailCadastroCampo);
        senha = findViewById(R.id.senhaCadastroCampo);
        dao = new UsuarioDAO(this);
    }

    public void efetuarCadastro(View view){
        Usuario usuario = new Usuario();

        usuario.setNome(nome.getText().toString());
        usuario.setEmail(email.getText().toString());
        usuario.setSenha(senha.getText().toString());

        dao.inserir(usuario);

        Intent intent = new Intent(this, ConfiguracaoPart1Activity.class);
        intent.putExtra("usuario", usuario);
        startActivity(intent);
    }

    public void fazerLogin(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
