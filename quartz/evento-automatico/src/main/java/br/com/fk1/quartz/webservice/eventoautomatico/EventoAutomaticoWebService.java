package br.com.fk1.quartz.webservice.eventoautomatico;

import br.com.fk1.quartz.webservice.pojo.EventoAutomaticoPojo;
import br.com.fk1.quartz.service.EventoAutomaticoService;
import java.util.List;
import javax.annotation.PostConstruct;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Classe de ligação entre o salute e o projeto Evento Automatico. Web Service
 * de comunicação/troca de mensagens
 *
 * @author Alci Barros
 * @since 1.5.84.00 do salute
 */
@Component
@Path("/eventoautomatico")
public class EventoAutomaticoWebService {

    @Autowired
    private ApplicationContext applicationContext;

    private static EventoAutomaticoService eventoAutomaticoService;

    @PostConstruct
    private void init() {
        if (eventoAutomaticoService == null) {
            eventoAutomaticoService = applicationContext.getAutowireCapableBeanFactory().getBean(EventoAutomaticoService.class);
        }
    }

    @POST
    @Path("/post")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post() {
        return Response.ok().build();
    }

    /**
     * Método eventoAutomatico(). Quando o método é chamado responde com os
     * eventos agendados no formato Json.
     *
     * @return String
     * @author Alci Barros
     * @since 1.5.84.00 do salute
     */
    @GET
    @Path("/get")
    @Produces({MediaType.APPLICATION_JSON})
    public List<String> get() {
        return eventoAutomaticoService.listar();
    }

    /**
     * Método inserir(). Usado para inserir novos eventos no Scheduler.
     *
     * @author Alci Barros
     * @param eventoAutomaticoPojo
     * @since 1.5.84.00 do salute
     * @return
     */
    @POST
    @Path("/inserir")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserir(EventoAutomaticoPojo eventoAutomaticoPojo) {
        eventoAutomaticoPojo = eventoAutomaticoService.inserir(eventoAutomaticoPojo);
        return Response.ok().type(MediaType.APPLICATION_JSON).entity(eventoAutomaticoPojo.toJson()).build();
    }

    /**
     * Método agendarEventoAutomatico(). Usado para agendar eventos no Scheduler Quartz.
     *
     * @author Alci Barros
     * @param eventoAutomaticoPojo
     * @return
     * @since 1.5.84.00 do salute
     */
    @POST
    @Path("/agendarEventoAutomatico")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response agendarEventoAutomatico(EventoAutomaticoPojo eventoAutomaticoPojo) {
        eventoAutomaticoPojo = eventoAutomaticoService.agendarEventoAutomatico(eventoAutomaticoPojo);
        return Response.ok().type(MediaType.APPLICATION_JSON).entity(eventoAutomaticoPojo.toJson()).build();
    }

    /**
     * Método excluir(). Usado para excluir eventos no Scheduler.
     *
     * @author Alci Barros
     * @since 1.5.84.00 do salute
     * @param eventoAutomaticoPojo
     * @return
     */
    @POST
    @Path("/excluir")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response excluir(EventoAutomaticoPojo eventoAutomaticoPojo) {
        eventoAutomaticoPojo = eventoAutomaticoService.excluir(eventoAutomaticoPojo);
        return Response.ok().type(MediaType.APPLICATION_JSON).entity(eventoAutomaticoPojo.toJson()).build();
    }
}
