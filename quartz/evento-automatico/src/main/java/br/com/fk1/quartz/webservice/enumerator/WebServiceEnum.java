package br.com.fk1.quartz.webservice.enumerator;

public enum WebServiceEnum {

    EVENTO_AUTOMATICO("/eventoautomatico");

    private final String path;

    private WebServiceEnum(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
