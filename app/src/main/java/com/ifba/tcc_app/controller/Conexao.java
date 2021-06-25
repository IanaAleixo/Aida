package com.ifba.tcc_app.controller;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Conexao extends SQLiteOpenHelper {
    private static final String name = "banco.db";
    private static final int version = +1;

    public Conexao(@Nullable Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table usuario(id integer primary key autoincrement, " +
                "nome varchar(50), email varchar(50), senha varchar(10))");

        db.execSQL("create table configuracao(alerta boolean, qnt_alerta integer, watch_list boolean, contato_email_WL varchar(50)," +
                "contato_email boolean, qnt_dias_email integer, dicas boolean, id_usuario integer, foreign key (id_usuario) REFERENCES usuario(id))");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
