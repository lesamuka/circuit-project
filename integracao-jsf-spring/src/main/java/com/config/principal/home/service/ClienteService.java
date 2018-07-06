package com.config.principal.home.service;

import com.config.principal.home.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ClienteService {

    private static final Map<Integer, Cliente> BANCO_DE_DADOS = new HashMap<>();

    private final Random random = new Random();

    public Cliente salvar(Cliente cliente) {
        if (cliente.getId() == null) {
            cliente.setId(Math.abs(random.nextInt()));
        }
        return BANCO_DE_DADOS.put(cliente.getId(), Cliente.copiar(cliente));
    }

    public Cliente buscar(Integer id) {
        return BANCO_DE_DADOS.get(id);
    }

    public List<Cliente> pesquisar() {
        Collection<Cliente> values = BANCO_DE_DADOS.values();
        return new ArrayList(values);
    }
}
