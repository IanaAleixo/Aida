package com.ifba.tcc_app.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.ifba.tcc_app.model.Categoria;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CategoriaDAO {
    private Conexao conexao;
    private SQLiteDatabase db;

    public CategoriaDAO(Context context){
        conexao = new Conexao(context);
        db = conexao.getWritableDatabase();
    }

    public long insert(Categoria categoria){
        ContentValues values = new ContentValues();
        values.put("tipo", categoria.getTipo());
        values.put("qnt_click", categoria.getQntClick());
        return db.insert("categoria", null, values);

    }

    public Categoria select(int id){

        Cursor cursor = db.query("categoria", new String[] { "id",
                        "tipo", "qnt_click"}, "id" + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Categoria categoria = new Categoria(cursor.getInt(0), cursor.getString(1),
                cursor.getInt(3));

        return categoria;
    }


    public int update(Categoria categoria) {
        ContentValues values = new ContentValues();
        values.put("tipo", categoria.getTipo());
        values.put("qnt_click", categoria.getQntClick());

        // updating row
        return db.update("categoria", values, "id" + " = ?",
                new String[] { String.valueOf(categoria.getId()) });
    }

    public void delete(Categoria categoria) {
        db.delete("categoria", "id" + " = ?",
                new String[] { String.valueOf(categoria.getId()) });
        db.close();
    }

}
