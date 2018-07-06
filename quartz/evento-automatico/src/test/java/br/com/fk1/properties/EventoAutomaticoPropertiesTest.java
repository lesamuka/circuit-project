package br.com.fk1.properties;

import br.com.fk1.Application;
import br.com.fk1.authorization.EventoAutomaticoProperties;
import br.com.fk1.authorization.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@SpringApplicationConfiguration(classes = Application.class)
public class EventoAutomaticoPropertiesTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private EventoAutomaticoProperties eventoAutomaticoProperties;

    @Test
    public void consumoWebService() {
        try {
            Principal propertiesSalute = eventoAutomaticoProperties.propertiesSalute();
            System.out.println(propertiesSalute);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}