package br.core.util;

import br.com.autowired.Application;
import br.com.autowired.confiration.EventoAutomaticoProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class})
public class AutowiredTest {

    @Autowired
    private EventoAutomaticoProperties eventoAutomaticoProperties;
    @Autowired
    private Persistencia persistencia;

    @Test
    public void test() {
        String nome = eventoAutomaticoProperties.getNome();
        String nome1 = persistencia.getNome();
        System.out.println(nome);
    }
}
