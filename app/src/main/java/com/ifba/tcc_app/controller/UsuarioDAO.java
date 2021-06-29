package com.ifba.tcc_app.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ifba.tcc_app.model.Usuario;

public class UsuarioDAO {
    private Conexao conexao;
    private SQLiteDatabase db;

    public UsuarioDAO(Context context){
        conexao = new Conexao(context);
        db = conexao.getWritableDatabase();
    }

    public long insert(Usuario usuario){
        ContentValues values = new ContentValues();
        values.put("nome", usuario.getNome());
        values.put("email", usuario.getEmail());
        values.put("senha", usuario.getSenha());
        return db.insert("usuario", null, values);

    }

    public Usuario select(int id){

        Cursor cursor = db.query("usuario", new String[] { "id",
                        "nome", "email"}, "id" + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();


        Usuario usuario = new Usuario(cursor.getInt(0), cursor.getString(1),
                cursor.getString(2));

        return usuario;
    }

    public Usuario buscaEmail(String email){

        Cursor cursor = db.query("usuario", new String[] { "id",
                        "nome", "email"}, "email" + "=?",
                new String[] { String.valueOf(email) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();


        Usuario usuario = new Usuario(cursor.getInt(0), cursor.getString(1),
                cursor.getString(2));

        return usuario;
    }

    public int update(Usuario usuario) {
        ContentValues values = new ContentValues();
        values.put("nome", usuario.getNome());
        values.put("email", usuario.getEmail());
        values.put("senha", usuario.getSenha());

        // updating row
        return db.update("usuario", values, "id" + " = ?",
                new String[] { String.valueOf(usuario.getId()) });
    }

    public void delete(Usuario usuario) {
        db.delete("usuario", "id" + " = ?",
                new String[] { String.valueOf(usuario.getId()) });
        db.close();
    }

    public boolean validarLogin (Usuario usuario){
        String sql_busca = "SELECT * from usuario WHERE email = " + "'" + usuario.getEmail() + "'";
        Cursor c = db.rawQuery(sql_busca, null);
        while(c.moveToNext()){
            if(usuario.getEmail().equals(c.getString(c.getColumnIndex("email")))){
                if(usuario.getSenha().equals(c.getString(c.getColumnIndex("senha")))){
                    return true;
                }
                else return false;
            }
            else return false;
        }
        return false;
    }
}
