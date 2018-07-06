package br.com.fk1.webservice;

import br.com.fk1.Application;
import br.com.fk1.authorization.EventoAutomaticoProperties;
import br.com.fk1.authorization.Principal;
import br.com.fk1.salute.service.SaluteService;
import br.com.fk1.quartz.webservice.pojo.EventoAutomaticoPojo;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.core.util.Base64;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@SpringApplicationConfiguration(classes = Application.class)
public class SaluteWebServiceTest extends AbstractTestNGSpringContextTests {

    protected static final String CHARSET = "UTF-8";

    @Autowired
    private SaluteService saluteService;
    @Autowired
    private EventoAutomaticoProperties eventoAutomaticoProperties;

    private Client client;
    protected static final String BASIC = "Basic ";
    private String LOGIN;
    private String PASSWORD;

    @BeforeClass
    public void init() {
        Principal principal = eventoAutomaticoProperties.propertiesSalute();
        LOGIN = principal.getLogin();
        PASSWORD = principal.getPassword();
        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        clientConfig.getProperties().put(ClientConfig.PROPERTY_CONNECT_TIMEOUT, 5000);//5 seconds read timeout
        clientConfig.getProperties().put(ClientConfig.PROPERTY_READ_TIMEOUT, 5000);//5 seconds read timeout
        client = Client.create(clientConfig);
    }

    @Test
    public void execution() throws Exception {
        try {
            EventoAutomaticoPojo eventoAutomaticoPojo = new EventoAutomaticoPojo();
            eventoAutomaticoPojo.setId(2);
            eventoAutomaticoPojo.setTipoEventoAutomatico("BPA");
            eventoAutomaticoPojo.setCronBuilder("0/30 * * * * ?");
            WebResource webResource = client.resource("http://localhost:8080/salute/webservice/eventoautomatico/postExecution");
            ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).header(HttpHeaders.AUTHORIZATION, "Basic ".concat(new String(Base64.encode(LOGIN.concat(":").concat(PASSWORD))))).post(ClientResponse.class, eventoAutomaticoPojo);
            String entity = response.getEntity(String.class);
            System.out.println(response);
            System.out.println(entity);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
