package com.config.principal.perfil.model;

import java.util.Date;

public class Perfil {
    
     private Date data = new Date();
     private String descricao;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
