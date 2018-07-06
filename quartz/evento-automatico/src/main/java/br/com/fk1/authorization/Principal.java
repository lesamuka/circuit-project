package br.com.fk1.authorization;

public class Principal {

    private final String protocolo;
    private final String dominio;
    private final String port;
    private final String recurso;
    private final String service;
    private final String login;
    private final String password;
    private final String timeZone;

    public Principal(String protocolo, String dominio, String port, String recurso, String service, String login, String password, String timeZone) {
        this.protocolo = protocolo;
        this.dominio = dominio;
        this.port = port;
        this.recurso = recurso;
        this.service = service;
        this.login = login;
        this.password = password;
        this.timeZone = timeZone;
    }

    public String getHost() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(protocolo).append("://");
        stringBuilder.append(dominio).append(":");
        stringBuilder.append(port).append("/");
        stringBuilder.append(recurso).append("/");
        stringBuilder.append(service);
        return stringBuilder.toString();
    }

    public String getProtocolo() {
        return protocolo;
    }

    public String getDominio() {
        return dominio;
    }

    public String getPort() {
        return port;
    }

    public String getRecurso() {
        return recurso;
    }

    public String getService() {
        return service;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getTimeZone() {
        return timeZone;
    }
}
