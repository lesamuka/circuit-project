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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@SpringApplicationConfiguration(classes = Application.class)
public class EventoAutomaticoWebServiceTest extends AbstractTestNGSpringContextTests {

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
        Principal principal = eventoAutomaticoProperties.propertiesHost();
        LOGIN = principal.getLogin();
        PASSWORD = principal.getPassword();

        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        clientConfig.getProperties().put(ClientConfig.PROPERTY_CONNECT_TIMEOUT, 5000);//5 seconds read timeout
        clientConfig.getProperties().put(ClientConfig.PROPERTY_READ_TIMEOUT, 5000);//5 seconds read timeout
        client = Client.create(clientConfig);
    }

//    @Test(enabled = false)
//    public void excluir() throws Exception {
//        try {
//            WebResource webResource = client.resource("http://localhost:8080/evento-automatico/webservice/eventoautomatico/excluir");
//            MultivaluedMap queryParams = new MultivaluedMapImpl();
//            queryParams.add("eventoAutomaticoId", 1);
//            ClientResponse post = webResource.queryParams(queryParams).accept(MediaType.APPLICATION_JSON).post(ClientResponse.class);
//            ClientResponse.Status clientResponseStatus = post.getClientResponseStatus();
//            MultivaluedMap<String, String> headers = post.getHeaders();
//            System.out.println(post);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
//    @Test(enabled = false)
//    public void saluteWebService() throws Exception {
//        try {
//            String chamadaGet = saluteService.eventoList(WebServiceEnum.EVENTO_AUTOMATICO, "getEventoAutomaticaJson", "MDk4MzMzMDg2Nzg6ZXdxMzIx");
//            System.out.println(chamadaGet);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }

    @Test(enabled = false)
    public void eventoAutomatico() throws Exception {
        try {
            WebResource webResource = client.resource("http://localhost:8080/evento-automatico/webservice/eventoautomatico/get");
            ClientResponse response = webResource.header(HttpHeaders.AUTHORIZATION, "Basic ".concat(new String(Base64.encode(LOGIN.concat(":").concat(PASSWORD))))).get(ClientResponse.class);
            String output = response.getEntity(String.class);
            System.out.println(output);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test(enabled = false)
    public void inserir() throws Exception {
        try {
            EventoAutomaticoPojo eventoAutomaticoPojo = new EventoAutomaticoPojo();
            eventoAutomaticoPojo.setId(1);
            eventoAutomaticoPojo.setTipoEventoAutomatico("BPA");
            eventoAutomaticoPojo.setCronBuilder("0/30 * * * * ?");
            WebResource webResource = client.resource("http://localhost:8080/evento-automatico/webservice/eventoautomatico/inserir");
            ClientResponse response = webResource.type("application/json").header(HttpHeaders.AUTHORIZATION, "Basic ".concat(new String(Base64.encode(LOGIN.concat(":").concat(PASSWORD))))).post(ClientResponse.class, eventoAutomaticoPojo);
            System.out.println("Output from Server .... \n");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test(enabled = false)
    public void alterar() throws Exception {
        try {
            EventoAutomaticoPojo eventoAutomaticoPojo = new EventoAutomaticoPojo();
            eventoAutomaticoPojo.setId(1);
            eventoAutomaticoPojo.setTipoEventoAutomatico("BPA");
            eventoAutomaticoPojo.setCronBuilder("0/30 * * * * ?");
            WebResource webResource = client.resource("http://localhost:8080/evento-automatico/webservice/eventoautomatico/alterar");
            ClientResponse response = webResource.type("application/json").header(HttpHeaders.AUTHORIZATION, "Basic ".concat(new String(Base64.encode(LOGIN.concat(":").concat(PASSWORD))))).post(ClientResponse.class, eventoAutomaticoPojo);
            System.out.println("Output from Server .... \n");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test(enabled = false)
    public void excluir() throws Exception {
        try {
            EventoAutomaticoPojo eventoAutomaticoPojo = new EventoAutomaticoPojo();
            eventoAutomaticoPojo.setId(1);
            eventoAutomaticoPojo.setTipoEventoAutomatico("BPA");
            eventoAutomaticoPojo.setCronBuilder("0/30 * * * * ?");
            WebResource webResource = client.resource("http://localhost:8080/evento-automatico/webservice/eventoautomatico/excluir");
            ClientResponse response = webResource.type("application/json").header(HttpHeaders.AUTHORIZATION, "Basic ".concat(new String(Base64.encode(LOGIN.concat(":").concat(PASSWORD))))).post(ClientResponse.class, eventoAutomaticoPojo);
            System.out.println("Output from Server .... \n");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
