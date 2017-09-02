package com.teste.rodrigo.e_deploy.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by not on 01/09/2017.
 */

public class State {
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @SerializedName("Nome")
    private String nome;

    @SerializedName("Estado")
    private String estado;


}
