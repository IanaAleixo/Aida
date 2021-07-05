package com.ifba.tcc_app.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import com.ifba.tcc_app.model.Imagem;
import com.ifba.tcc_app.model.Usuario;

public class ImagemDAO {
    private Conexao conexao;
    private SQLiteDatabase db;

    public ImagemDAO(Context context){
        conexao = new Conexao(context);
        db = conexao.getWritableDatabase();
    }

    public long insert(String name, byte[] image) throws SQLiteException {
        ContentValues values = new  ContentValues();
        values.put("nome",    name);
        values.put("imagem",   image);
        return db.insert( "imagem_perfil", null, values );
    }

    //CÓDIGO TAMBÉM TESTADO
    /* public boolean insert(String x,String name) throws SQLiteException {
        try{
            FileInputStream fs = new FileInputStream(x);
            byte[] imgbyte = new byte[fs.available()];
            fs.read(imgbyte);
            ContentValues values = new ContentValues();
            values.put("nome",name);
            values.put("imagem", imgbyte);
            db.insert("imagem_perfil", null, values);
            fs.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }*/

    public Imagem select(String nome) throws SQLiteException{

        Cursor cursor = db.query("imagem_perfil", new String[] {
                        "nome", "imagem"}, "nome" + "=?",
                new String[] { String.valueOf(nome) }, null, null, null, null);
        if (cursor != null){
            cursor.moveToFirst();
            byte[] image = cursor.getBlob(1);


            Imagem imagem = new Imagem(cursor.getString(0), image);

            return imagem;
        }


        return null;
    }

    public int update(Imagem imagem) {
        ContentValues values = new  ContentValues();
        values.put("nome", imagem.getNome());
        values.put("imagem", imagem.getImagem());

        // updating row
        return db.update("imagem_perfil", values, "nome" + " = ?",
                new String[] { String.valueOf(imagem.getNome()) });
    }

    public void delete(Imagem imagem) {
        db.delete("imagem_perfil", "id" + " = ?",
                new String[] { String.valueOf(imagem.getNome()) });
        db.close();
    }
}
