package com.ifba.tcc_app.model;

public class Imagem {
    private String nome;
    private byte[] imagem;

    public Imagem() {
    }

    public Imagem(String nome, byte[] imagem) {
        this.nome = nome;
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }
}
