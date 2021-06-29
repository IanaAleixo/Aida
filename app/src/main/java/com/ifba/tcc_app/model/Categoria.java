package com.ifba.tcc_app.model;

import java.util.Date;

public class Categoria {
    private int id;
    private String tipo;
    private int qntClick;

    public Categoria() {
    }

    public Categoria(int id) {
        this.id = id;
    }

    public Categoria(int id, String tipo, int qntClick) {
        this.id = id;
        this.tipo = tipo;
        this.qntClick = qntClick;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getQntClick() {
        return qntClick;
    }

    public void setQntClick(int qntClick) {
        this.qntClick = qntClick;
    }
}
