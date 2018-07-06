package br.core.util;

import javax.annotation.PostConstruct;
import org.springframework.stereotype.Controller;

@Controller
public class Persistencia {

    private String nome = "TESTE";

    @PostConstruct
    private void init() {

    }

    public String getNome() {
        return nome;
    }
}
