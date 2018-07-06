package br.com.fk1.authorization;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventoAutomaticoProperties {

    private Properties properties = new Properties();

    @PostConstruct
    private void init() {
        try {
            InputStream inputStream = this.getClass().getResourceAsStream("/eventoautomatico.properties");
            properties.load(inputStream);
        } catch (Exception ex) {
            Logger.getLogger(EventoAutomaticoProperties.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void propertiesCriate() {

    }

    private Map<String, Principal> propertiesReader() {
        Map<String, Principal> principalList = new HashMap();
        {
            String login = properties.getProperty(TIPO.EVENTOAUTOMATICO_LOGIN.getValue());
            String password = properties.getProperty(TIPO.EVENTOAUTOMATICO_PASSWORD.getValue());
            principalList.put("HOST", new Principal(null, null, null, null, null, login, password, null));
        }
        {
            String protocolo = properties.getProperty(TIPO.EVENTOAUTOMATICO_SALUTE_WEBSERVICE_PROTOCOLO.getValue());
            String dominio = properties.getProperty(TIPO.EVENTOAUTOMATICO_SALUTE_WEBSERVICE_DOMINIO.getValue());
            String porta = properties.getProperty(TIPO.EVENTOAUTOMATICO_SALUTE_WEBSERVICE_PORT.getValue());
            String recurso = properties.getProperty(TIPO.EVENTOAUTOMATICO_SALUTE_WEBSERVICE_RECURSO.getValue());
            String service = properties.getProperty(TIPO.EVENTOAUTOMATICO_SALUTE_WEBSERVICE_RECURSO_SERVICO.getValue());
            String login = properties.getProperty(TIPO.EVENTOAUTOMATICO_SALUTE_WEBSERVICE_LOGIN.getValue());
            String password = properties.getProperty(TIPO.EVENTOAUTOMATICO_SALUTE_WEBSERVICE_PASSWORD.getValue());
            String timeZone = properties.getProperty(TIPO.EVENTOAUTOMATICO_SALUTE_TIMEZONE.getValue());
            principalList.put("SALUTE", new Principal(protocolo, dominio, porta, recurso, service, login, password, timeZone));
        }
        return principalList;
    }

    public Principal propertiesHost() {
        return propertiesReader().get("HOST");
    }

    public Principal propertiesSalute() {
        return propertiesReader().get("SALUTE");
    }

    private enum TIPO {

        EVENTOAUTOMATICO_LOGIN("eventoautomatico.login"),
        EVENTOAUTOMATICO_PASSWORD("eventoautomatico.password"),
        EVENTOAUTOMATICO_SALUTE_WEBSERVICE_PROTOCOLO("eventoautomatico.salute.webservice.protocolo"),
        EVENTOAUTOMATICO_SALUTE_WEBSERVICE_DOMINIO("eventoautomatico.salute.webservice.dominio"),
        EVENTOAUTOMATICO_SALUTE_WEBSERVICE_PORT("eventoautomatico.salute.webservice.port"),
        EVENTOAUTOMATICO_SALUTE_WEBSERVICE_RECURSO("eventoautomatico.salute.webservice.recurso"),
        EVENTOAUTOMATICO_SALUTE_WEBSERVICE_RECURSO_SERVICO("eventoautomatico.salute.webservice.recurso.servico"),
        EVENTOAUTOMATICO_SALUTE_WEBSERVICE_LOGIN("eventoautomatico.salute.webservice.login"),
        EVENTOAUTOMATICO_SALUTE_WEBSERVICE_PASSWORD("eventoautomatico.salute.webservice.password"),
        EVENTOAUTOMATICO_SALUTE_TIMEZONE("eventoautomatico.salute.timezone");

        private final String value;

        private TIPO(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
