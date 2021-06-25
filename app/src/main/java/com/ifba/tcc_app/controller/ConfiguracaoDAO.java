package com.ifba.tcc_app.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ifba.tcc_app.model.Configuracao;
import com.ifba.tcc_app.model.Usuario;

public class ConfiguracaoDAO {
    private Conexao conexao;
    private SQLiteDatabase db;

    public ConfiguracaoDAO(Context context){
        conexao = new Conexao(context);
        db = conexao.getWritableDatabase();
    }

    public long inserir(Configuracao configuracao){
        ContentValues values = new ContentValues();
        values.put("alerta", configuracao.isAlerta());
        values.put("qnt_alerta", configuracao.getQtnAlerta());
        values.put("watch_list", configuracao.isWatchList());
        values.put("contato_email_WL", configuracao.getContatoWatchList());
        values.put("contato_email", configuracao.isReceberEmail());
        values.put("qnt_dias_email", configuracao.getQtnDiasEmail());
        values.put("dicas", configuracao.isDicas());
        values.put("id_usuario", configuracao.getIdUsuario());
        return db.insert("configuracao", null, values);

    }

    public Configuracao select(int idUsuario){

        Cursor cursor = db.query("configuracao", new String[] { "alerta",
                        "qnt_alerta", "watch_list", "contato_email_WL", "contato_email",
                        "qnt_dias_email", "dicas", "id_usuario" }, "id_usuario" + "=?",
                new String[] { String.valueOf(idUsuario) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();


        Configuracao configuracao = new Configuracao(Boolean.parseBoolean(cursor.getString(0)),
                cursor.getInt(1), Boolean.parseBoolean(cursor.getString(2)),
                cursor.getString(3), Boolean.parseBoolean(cursor.getString(4)),
                cursor.getInt(5), Boolean.parseBoolean(cursor.getString(6)),
                cursor.getInt(7));

        return configuracao;
    }

    public int update(Configuracao configuracao) {
        ContentValues values = new ContentValues();

        values.put("contato_email", configuracao.isReceberEmail());
        values.put("qnt_dias_email", configuracao.getQtnDiasEmail());
        values.put("dicas", configuracao.isDicas());
        values.put("id_usuario", configuracao.getIdUsuario());

        // updating row
        return db.update("configuracao", values, "id_usuario" + " = ?",
                new String[] { String.valueOf(configuracao.getIdUsuario()) });
    }

    public void delete(Configuracao configuracao) {
        db.delete("configuracao", "id_usuario" + " = ?",
                new String[] { String.valueOf(configuracao.getIdUsuario()) });
        db.close();
    }
}
