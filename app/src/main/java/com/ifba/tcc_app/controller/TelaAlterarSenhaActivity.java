package com.ifba.tcc_app.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ifba.tcc_app.R;
import com.ifba.tcc_app.model.Usuario;

public class TelaAlterarSenhaActivity extends AppCompatActivity {
    private Button btnAlterar;
    private ImageButton btnVoltar;
    private EditText senhaAtualCampo;
    private EditText novaSenhaCampo;
    private EditText confirmarSenhaCampo;
    private UsuarioDAO daoUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_alterar_senha);

        daoUsuario = new UsuarioDAO(this);

        senhaAtualCampo = findViewById(R.id.senhaAtualCampo);
        novaSenhaCampo = findViewById(R.id.novaSenhaCampo);
        confirmarSenhaCampo = findViewById(R.id.confirmarSenhaCampo);

        btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaAlterarSenhaActivity.this, EditarPerfilActivity.class);
                Usuario usuario = getIntent().getParcelableExtra("usuario");
                intent.putExtra("usuario", usuario);
                startActivity(intent);
            }
        });

        btnAlterar = findViewById(R.id.btnAlterar);
        btnAlterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario usuario = getIntent().getParcelableExtra("usuario");
                Usuario user = daoUsuario.select(usuario.getId());
                if (senhaAtualCampo.getText().toString().equals(user.getSenha())){
                    if (novaSenhaCampo.getText().toString().equals(confirmarSenhaCampo.getText().toString())){
                        user.setSenha(novaSenhaCampo.getText().toString());
                        daoUsuario.updateSenha(user);
                        Toast.makeText(getApplicationContext(), "Senha alterada com sucesso!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(TelaAlterarSenhaActivity.this, TelaPerfilActivity.class);
                        intent.putExtra("usuario", usuario);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "As senhas não conferem!", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), "Senha atual incorreta!", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    public void alterarSenha(View view){
        Intent intent = new Intent(this, TelaPerfilActivity.class);
        startActivity(intent);
    }
}
