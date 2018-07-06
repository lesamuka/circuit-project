package br.com.fk1.quartz.conf;

import br.com.fk1.quartz.webservice.pojo.EventoAutomaticoPojo;
import br.com.fk1.quartz.service.EventoAutomaticoService;
import br.com.fk1.salute.service.SaluteService;
import br.com.fk1.quartz.webservice.enumerator.WebServiceEnum;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Classe de configuração do projeto Evento Automático
 *
 * @author Alci Barros
 * @since 1.5.84.00 do salute
 */
@Configuration
@Import({SchedulerBean.class})
public class SchedulerService {

    @Autowired
    private SaluteService saluteService;
    @Autowired
    private EventoAutomaticoService eventoAutomaticoService;

    /**
     * Método Init(). Acesso o webservice eventoautomatico recuperando os
     * eventos agendados
     *
     * @author Alci Barros
     * @since 1.5.84.00 do salute
     */
    @PostConstruct
    public void init() {
//        try {
//            String chamadaPostJson = saluteService.eventoList(WebServiceEnum.EVENTO_AUTOMATICO, "getEventoAutomaticaJson", "MDk4MzMzMDg2Nzg6ZXdxMzIx");
//            Gson gSon = new GsonBuilder().setDateFormat("HH:mm:ss").create();
//            EventoAutomaticoPojo[] eventoAutomaticoPojoArray = gSon.fromJson(chamadaPostJson, EventoAutomaticoPojo[].class);
//            if (eventoAutomaticoPojoArray != null) {
//                for (EventoAutomaticoPojo eventoAutomaticoPojo : eventoAutomaticoPojoArray) {
//                    eventoAutomaticoService.inserir(eventoAutomaticoPojo);
//                }
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(SchedulerService.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}
