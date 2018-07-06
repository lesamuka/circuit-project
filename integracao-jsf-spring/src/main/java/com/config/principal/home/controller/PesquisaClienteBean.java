package com.config.principal.home.controller;

import com.config.principal.home.model.Cliente;
import com.config.principal.home.service.ClienteService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@Scope("view")
public class PesquisaClienteBean {

    private List<Cliente> clientes = new ArrayList<>();

    @Autowired
    private ClienteService clienteService;

    @PostConstruct
    public void postConstruct() {
        clientes = clienteService.pesquisar();
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
}
