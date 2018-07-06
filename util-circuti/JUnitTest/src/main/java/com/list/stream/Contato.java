package com.list.stream;

public class Contato {
    
    private String tipoContato;
    private String info;

    public Contato(String tipoContato, String info) {
        this.tipoContato = tipoContato;
        this.info = info;
    }

    public String getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(String tipoContato) {
        this.tipoContato = tipoContato;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    
    
}
