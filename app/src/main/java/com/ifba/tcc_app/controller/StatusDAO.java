package com.ifba.tcc_app.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ifba.tcc_app.model.Categoria;
import com.ifba.tcc_app.model.Status;

import java.util.ArrayList;
import java.util.List;

public class StatusDAO {
    private Conexao conexao;
    private SQLiteDatabase db;

    public StatusDAO(Context context){
        conexao = new Conexao(context);
        db = conexao.getWritableDatabase();
    }

    public long insert(Status status){
        ContentValues values = new ContentValues();
        values.put("sentimento", status.getSentimento());
        values.put("data", status.getData());
        values.put("categoria", status.getCategoria().getId());
        return db.insert("status", null, values);

    }

    public Status select(int id){

        Cursor cursor = db.query("status", new String[] { "id",
                        "sentimento", "data", "categoria"}, "id" + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Categoria categoria = new Categoria(cursor.getInt(3));
        Status status = new Status(cursor.getInt(0), cursor.getString(1),
                cursor.getString(2), categoria);

        return status;
    }

    public List<Status> getAllStatus() {
        List<Status> statusList = new ArrayList<Status>();
        // Select All Query
        String selectQuery = "SELECT  * FROM status";

        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Status status = new Status();
                status.setId(Integer.parseInt(cursor.getString(0)));
                status.setSentimento(cursor.getString(1));
                status.setData(cursor.getString(2));
                Categoria categoria = new Categoria(Integer.parseInt(cursor.getString(3)));
                status.setCategoria(categoria);
                // Adding country to list
                statusList.add(status);
            } while (cursor.moveToNext());
        }

        // return country list
        return statusList;
    }


    public int update(Status status) {
        ContentValues values = new ContentValues();
        values.put("sentimento", status.getSentimento());
        values.put("data", status.getData());
        values.put("categoria", status.getCategoria().getId());

        // updating row
        return db.update("status", values, "id" + " = ?",
                new String[] { String.valueOf(status.getId()) });
    }

    public void delete(Status status) {
        db.delete("status", "id" + " = ?",
                new String[] { String.valueOf(status.getId()) });
        db.close();
    }

}
