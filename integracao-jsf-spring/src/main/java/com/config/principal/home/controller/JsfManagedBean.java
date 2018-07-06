package com.config.principal.home.controller;

//import br.com.autowired.confiration.EventoAutomaticoProperties;
import com.config.principal.home.model.Cliente;
import com.config.principal.home.service.ClienteService;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("view")
public class JsfManagedBean {
//
//    @Autowired
//    private EventoAutomaticoProperties eventoAutomaticoProperties;

    @Autowired
    private ClienteService clienteService;

    private String titulo = "O managed bean desta página está anotado com @Controller, ou seja, podemos ter beans JSF e Spring em um mesmo projeto!";

    private Cliente cliente = new Cliente();

    @PostConstruct
    private void init() {
        System.out.print(JsfManagedBean.class.getPackage());
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ClienteService getClienteService() {
        return clienteService;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
