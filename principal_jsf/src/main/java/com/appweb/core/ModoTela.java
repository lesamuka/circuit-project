package com.appweb.core;

public enum ModoTela {
    
    LOCALIZACAO(0), VISUALIZACAO(1), INSERCAO(2), ALTERACAO(3);
    
    private final int id;

    private ModoTela(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
   
}
