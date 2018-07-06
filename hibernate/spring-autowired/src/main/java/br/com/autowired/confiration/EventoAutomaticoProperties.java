package br.com.autowired.confiration;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;


@Component
public class EventoAutomaticoProperties {

    private String nome = "TESTE";

    @PostConstruct
    private void init() {
        try {

        } catch (Exception ex) {
            Logger.getLogger(EventoAutomaticoProperties.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getNome() {
        return nome;
    }

}
