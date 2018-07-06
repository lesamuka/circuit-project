package com.appweb.cliente.controller;

import com.appweb.cliente.model.Cliente;
import com.appweb.cliente.model.ContatoRealizado;
import com.appweb.cliente.service.ClienteService;
import com.appweb.core.ModoTela;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ClienteMb implements Serializable {

    private static final long serialVersionUID = -2753121484297994226L;
    private ModoTela modoTela = ModoTela.LOCALIZACAO;

    private List<Cliente> clienteList = new ArrayList<>();

    private ContatoRealizado contatoRealizado = new ContatoRealizado();
    private Cliente cliente = new Cliente();

    @PostConstruct
    private void init() {

    }

    public void inserir() {
        modoTela = ModoTela.INSERCAO;
    }

    public void salvar() {

        modoTela = ModoTela.VISUALIZACAO;
    }

    public void alterar() {

        modoTela = ModoTela.ALTERACAO;
    }

    public void visualizar() {
        modoTela = ModoTela.VISUALIZACAO;
    }

    public void excluir() {
        cliente = new Cliente();
        contatoRealizado = new ContatoRealizado();
        clienteList = ClienteService.listar();
        modoTela = ModoTela.LOCALIZACAO;
    }

    public void cancelar() {
        cliente = new Cliente();
        contatoRealizado = new ContatoRealizado();

        modoTela = ModoTela.LOCALIZACAO;
    }

    public void adicionar() {
        cliente.adicionar(contatoRealizado);
        contatoRealizado = new ContatoRealizado();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public ContatoRealizado getContatoRealizado() {
        return contatoRealizado;
    }

    public void setContatoRealizado(ContatoRealizado contatoRealizado) {
        this.contatoRealizado = contatoRealizado;
    }

    public ModoTela getModoTela() {
        return modoTela;
    }
}