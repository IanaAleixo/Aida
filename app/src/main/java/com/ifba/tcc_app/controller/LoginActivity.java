package com.ifba.tcc_app.controller;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ifba.tcc_app.R;
import com.ifba.tcc_app.model.Usuario;

public class LoginActivity extends AppCompatActivity {
    public EditText email;
    public EditText senha;
    private UsuarioDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);

        email = findViewById(R.id.emailLoginCampo);
        senha = findViewById(R.id.senhaLoginCampo);

        dao = new UsuarioDAO(this);
    }



    public void efetuarLogin(View view){
        Usuario usuario = new Usuario(email.getText().toString(), senha.getText().toString());
        boolean validar = dao.validarLogin(usuario);
        if(validar){
            Usuario user = dao.buscaEmail(usuario.getEmail());
            Intent intent = new Intent(this, TelaPrincipalActivity.class);
            intent.putExtra("usuario", user);
            startActivity(intent);
        }
        else {
            Toast.makeText(getApplicationContext(), "Email ou senha incorretos, por favor, tente novamente", Toast.LENGTH_LONG).show();
        }

    }

    public void esqueceuSenha(View view){
        Intent intent = new Intent(this, TelaEsqueceuSenhaActivity.class);
        startActivity(intent);
    }

}
