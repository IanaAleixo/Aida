package com.ifba.tcc_app.model;

import com.ifba.tcc_app.GiphyHttpConexao;

public class Gif {
    public String tipo;
    public String id;
    public String slug;
    public String url;
    public String source;
    public ImagemGif imagem = new ImagemGif();

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public ImagemGif getImagem() {
        return imagem;
    }

    public void setImagem(ImagemGif imagem) {
        this.imagem = imagem;
    }
}
