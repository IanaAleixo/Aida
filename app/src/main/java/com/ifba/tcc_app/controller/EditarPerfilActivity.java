package com.ifba.tcc_app.controller;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.ifba.tcc_app.R;
import com.ifba.tcc_app.model.Imagem;
import com.ifba.tcc_app.model.Usuario;

import java.io.ByteArrayOutputStream;

public class EditarPerfilActivity extends AppCompatActivity {
    private ImageView fotoUsuario;
    private Button btnEditarImagemPerfil;
    private Button btnAlterarSenha;
    private Button btnSalvarPerfil;
    private ImageButton btnVoltar;
    private static final int RESULT_LOAD_IMAGE= 1;
    private static final int PICK_IMAGE= 100;
    private ImagemDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_editar_perfil);

        Usuario usuario = getIntent().getParcelableExtra("usuario");


        fotoUsuario = findViewById(R.id.fotoUsuario);
        dao = new ImagemDAO(this);

        Imagem imagem = dao.select(usuario.getNome());

        if (imagem == null) {
            Uri imgUri = Uri.parse("android.resource://my.package.name/" + R.drawable.icone_perfil);
            fotoUsuario.setImageURI(imgUri);


        } else {
            Bitmap bitmap = getImage(imagem.getImagem());
            fotoUsuario.setImageBitmap(bitmap);

        }


        btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditarPerfilActivity.this, TelaPerfilActivity.class);
                Usuario usuario = getIntent().getParcelableExtra("usuario");
                intent.putExtra("usuario", usuario);
                startActivity(intent);
            }
        });

        btnEditarImagemPerfil = findViewById(R.id.btnEditarFotoPerfil);
        btnEditarImagemPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(EditarPerfilActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(EditarPerfilActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1);
                    return;
                }
                Intent intent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, RESULT_LOAD_IMAGE);

                //CÓDIGO TAMBÉM TESTADO
                /*Intent intent = new Intent(Intent.ACTION_PICK, Uri.parse(
                        "content://media/internal/images/media"));
                startActivityForResult(intent, PICK_IMAGE);*/

            }
        });

        btnAlterarSenha = findViewById(R.id.btnAlterarSenha);
        btnAlterarSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditarPerfilActivity.this, TelaAlterarSenhaActivity.class);
                Usuario usuario = getIntent().getParcelableExtra("usuario");
                intent.putExtra("usuario", usuario);
                startActivity(intent);

            }
        });

        btnSalvarPerfil = findViewById(R.id.btnSalvarPerfil);
        btnSalvarPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditarPerfilActivity.this, TelaPerfilActivity.class);
                Usuario usuario = getIntent().getParcelableExtra("usuario");
                intent.putExtra("usuario", usuario);
                startActivity(intent);
            }
        });

    }

    // convert from bitmap to byte array
    public static byte[] getBytes(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, stream);
        return stream.toByteArray();
    }

    // convert from byte array to bitmap
    public static Bitmap getImage(byte[] image) {
        return BitmapFactory.decodeByteArray(image, 0, image.length);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null !=data){
            Uri selectedImageUri = data.getData();
            fotoUsuario.setImageURI(selectedImageUri);
            Drawable drawable = fotoUsuario.getDrawable();
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            byte[] image = getBytes(bitmap);
            Usuario usuario = getIntent().getParcelableExtra("usuario");
            Imagem imagem = new Imagem();
            imagem.setNome(usuario.getNome());
            imagem.setImagem(image);
            dao.insert(usuario.getNome(),image);

            // O CÓDIGO ABAIXO É PARA O ONCREATE
            /*Imagem imagem = dao.select(usuario.getNome());

            if (imagem == null){
                Uri imgUri=Uri.parse("android.resource://my.package.name/"+R.drawable.icone_perfil);
                fotoUsuario.setImageURI(imgUri);
                Toast.makeText(getApplicationContext(), "é null", Toast.LENGTH_SHORT).show();


            }else{
                Bitmap bitmap = getImage(imagem.getImagem());
                fotoUsuario.setImageBitmap(bitmap);
                Toast.makeText(getApplicationContext(), "inseriu", Toast.LENGTH_SHORT).show();

            }*/
        }

        //CÓDIGO TAMBÉM TESTADO

        /* if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && null !=data){
            Uri uri = data.getData();
            String x = getPath(uri);
            Usuario usuario = getIntent().getParcelableExtra("usuario");
            String nome = usuario.getNome();
            if(dao.insert(x,nome)){
                Toast.makeText(getApplicationContext(),"Successfull",Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(getApplicationContext(),"NOT Successfull",Toast.LENGTH_SHORT).show();

            } */


        }

    public String getPath(Uri uri){
        if(uri == null) return null;
        String[] projection = {MediaStore.Images.Media.DATA};
        Cursor cursor = managedQuery(uri, projection,null,null, null);
        if (cursor != null){
            int column_index = cursor
                    .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        }
        return uri.getPath();
    }

}
