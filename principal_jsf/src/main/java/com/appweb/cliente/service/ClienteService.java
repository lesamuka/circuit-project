package com.appweb.cliente.service;

import com.appweb.cliente.dao.ClienteDao;
import com.appweb.cliente.model.Cliente;
import java.io.Serializable;
import java.util.List;

public class ClienteService implements Serializable{

    private static final long serialVersionUID = -2209720507806533979L;

    public static void salvar(Cliente cliente) {
        ClienteDao.salvar(cliente);
    }

    public static Cliente alterar(Cliente cliente) {
        return ClienteDao.alterar(cliente);
    }

    public static void excluir(Cliente cliente) {
       ClienteDao.excluir(cliente);
    }

    public static List<Cliente> listar() {
         return ClienteDao.listar();
    }
}
