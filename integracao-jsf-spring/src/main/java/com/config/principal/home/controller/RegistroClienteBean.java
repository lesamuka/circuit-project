package com.config.principal.home.controller;

import com.config.principal.home.model.Cliente;
import com.config.principal.home.service.ClienteService;
import com.config.view.ScopeName;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;

@Component
@Scope(ScopeName.VIEW)
public class RegistroClienteBean implements Serializable {

    private static final long serialVersionUID = -1962638964583329203L;

    @Autowired
    private ClienteService clienteService;

    private Cliente cliente = new Cliente();

    @PostConstruct
    private void init() {
        System.out.println("com.spring.principal.controller.RegistroClienteBean.init()");
    }

    public void salvar() {
        cliente = clienteService.salvar(cliente);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente salvo!"));
    }

    public void buscar() {
        cliente = clienteService.buscar(cliente.getId());
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
