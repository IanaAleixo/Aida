package com.ifba.tcc_app.model;

public class Configuracao {
    public boolean alerta;
    private int qtnAlerta;
    public boolean watchList;
    private String contatoWatchList;
    private boolean receberEmail;
    private int qtnDiasEmail;
    private boolean dicas;
    public int idUsuario;

    public Configuracao() {
    }

    public Configuracao(boolean alerta, int qtnAlerta, boolean watchList, String contatoWatchList,
                        boolean receberEmail, int qtnDiasEmail, boolean dicas, int idUsuario) {
        this.alerta = alerta;
        this.qtnAlerta = qtnAlerta;
        this.watchList = watchList;
        this.contatoWatchList = contatoWatchList;
        this.receberEmail = receberEmail;
        this.qtnDiasEmail = qtnDiasEmail;
        this.dicas = dicas;
        this.idUsuario = idUsuario;
    }

    public boolean isAlerta() {
        return alerta;
    }

    public void setAlerta(boolean alerta) {
        this.alerta = alerta;
    }

    public int getQtnAlerta() {
        return qtnAlerta;
    }

    public void setQtnAlerta(int qtnAlerta) {
        this.qtnAlerta = qtnAlerta;
    }

    public boolean isWatchList() {
        return watchList;
    }

    public void setWatchList(boolean watchList) {
        this.watchList = watchList;
    }

    public String getContatoWatchList() {
        return contatoWatchList;
    }

    public void setContatoWatchList(String contatoWatchList) {
        this.contatoWatchList = contatoWatchList;
    }

    public boolean isReceberEmail() {
        return receberEmail;
    }

    public void setReceberEmail(boolean receberEmail) {
        this.receberEmail = receberEmail;
    }

    public int getQtnDiasEmail() {
        return qtnDiasEmail;
    }

    public void setQtnDiasEmail(int qtnDiasEmail) {
        this.qtnDiasEmail = qtnDiasEmail;
    }

    public boolean isDicas() {
        return dicas;
    }

    public void setDicas(boolean dicas) {
        this.dicas = dicas;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
