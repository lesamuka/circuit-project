package br.com.fk1.salute.service;

import br.com.fk1.authorization.EventoAutomaticoProperties;
import br.com.fk1.authorization.Principal;
import br.com.fk1.quartz.webservice.pojo.EventoAutomaticoPojo;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.core.util.Base64;
import javax.annotation.PostConstruct;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaluteService {

    @Autowired
    private EventoAutomaticoProperties eventoAutomaticoProperties;

    protected static final String CHARSET = "UTF-8";
    protected static final String BASIC = "Basic ";

    private Client client;

    @PostConstruct
    public void init() {
        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        clientConfig.getProperties().put(ClientConfig.PROPERTY_CONNECT_TIMEOUT, 5000);// 5 seconds read timeout
        clientConfig.getProperties().put(ClientConfig.PROPERTY_READ_TIMEOUT, 5000);// 5 seconds read timeout
        client = Client.create(clientConfig);
    }

    public void executar(EventoAutomaticoPojo eventoAutomaticoPojo) {
        try {            
            Principal principal = eventoAutomaticoProperties.propertiesSalute();
            String login = principal.getLogin();
            String password = principal.getPassword();
            WebResource webResource = client.resource(principal.getHost().concat("/executar"));
            ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).header(HttpHeaders.AUTHORIZATION, "Basic ".concat(new String(Base64.encode(login.concat(":").concat(password))))).post(ClientResponse.class, eventoAutomaticoPojo);
            System.out.println(response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
