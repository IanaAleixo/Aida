package com.ifba.tcc_app.model;

public class Status {
    private int id;
    private String sentimento;
    private String data;
    private Categoria categoria;

    public Status() {
    }

    public Status(String sentimento, String data, Categoria categoria) {
        this.sentimento = sentimento;
        this.data = data;
        this.categoria = categoria;
    }

    public Status(int id, String sentimento, String data, Categoria categoria) {
        this.id = id;
        this.sentimento = sentimento;
        this.data = data;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSentimento() {
        return sentimento;
    }

    public void setSentimento(String sentimento) {
        this.sentimento = sentimento;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
