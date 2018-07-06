package br.com.fk1.quartz.job;

import br.com.fk1.quartz.webservice.pojo.EventoAutomaticoPojo;
import br.com.fk1.salute.service.SaluteService;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Classe que dispara o evento para ser executado no salute.
 *
 * @author Alci Barros
 * @since 1.5.84.00 do salute
 */
public class EventoAutomaticoJob implements Job {
    
    @Autowired
    private SaluteService saluteService;

    /**
     * Método execute(JobExecutionContext jobExecutionContext). Responsável por
     * passar os parâmentros de execução de evento
     *
     * @author Alci Barros
     * @param jobExecutionContext
     * @since 1.5.84.00 do salute
     */
    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        try {
            JobDetail jobDetail = jobExecutionContext.getJobDetail();
            JobDataMap jobDataMap = jobDetail.getJobDataMap();
                        
            String eventoId = jobDataMap.getString("eventoAutomaticoId"); 
            String tipoEventoAutomatico = jobDataMap.getString("TIPO_EVENTO_AUTOMATICO");
            Date proximaExecucaoDataHora = jobExecutionContext.getNextFireTime();

            EventoAutomaticoPojo eventoAutomaticoPojo = new EventoAutomaticoPojo();
            eventoAutomaticoPojo.setId(Integer.valueOf(eventoId));
            eventoAutomaticoPojo.setTipoEventoAutomatico(tipoEventoAutomatico);
            eventoAutomaticoPojo.setProximaExecucaoDateHora(proximaExecucaoDataHora);
            
            saluteService.executar(eventoAutomaticoPojo);
        } catch (Exception ex) {
            Logger.getLogger(EventoAutomaticoJob.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
