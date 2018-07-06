package br.com.fk1.quartz.service;

import br.com.fk1.authorization.EventoAutomaticoProperties;
import br.com.fk1.quartz.webservice.pojo.EventoAutomaticoPojo;
import br.com.fk1.quartz.job.EventoAutomaticoJob;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import java.util.logging.Level;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import static org.quartz.impl.matchers.GroupMatcher.groupEquals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventoAutomaticoService {

    private static final Logger LOG = LoggerFactory.getLogger(EventoAutomaticoService.class);

    @Autowired
    private Scheduler scheduler;
    @Autowired
    private EventoAutomaticoProperties eventoAutomaticoProperties;
    
    //private static final String TIME_ZONE = "America/Sao_Paulo";

    public List<String> listar() {
        List<String> stringList = new ArrayList<>();
        try {
            List<String> jobGroupNames = scheduler.getJobGroupNames();
            for (String jobGroupName : jobGroupNames) {
                Set<TriggerKey> triggerKeys = scheduler.getTriggerKeys(groupEquals(jobGroupName));
                for (TriggerKey triggerKey : triggerKeys) {
                    Trigger trigger = scheduler.getTrigger(triggerKey);
                    JobDetail jobDetail = scheduler.getJobDetail(trigger.getJobKey());
                    JobDataMap jobDataMap = jobDetail.getJobDataMap();
                    String eventoId = (jobDataMap.getString("eventoAutomaticoId") != null) ? jobDataMap.getString("eventoAutomaticoId") : "";
                    String tipoEventoAutomatico = (jobDataMap.getString("TIPO_EVENTO_AUTOMATICO") != null) ? jobDataMap.getString("TIPO_EVENTO_AUTOMATICO") : "";
                    String nextFireTime = (trigger.getNextFireTime() != null) ? new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(trigger.getNextFireTime()) : "";
                    String string = "|".concat(eventoId).concat("|").concat(tipoEventoAutomatico).concat("|").concat(nextFireTime);
                    stringList.add(string);
                }
            }
        } catch (SchedulerException ex) {
            java.util.logging.Logger.getLogger(EventoAutomaticoService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stringList;
    }

    public EventoAutomaticoPojo inserir(EventoAutomaticoPojo eventoAutomaticoPojo) {
        try {
            String timeZone = eventoAutomaticoProperties.propertiesSalute().getTimeZone();            
            JobKey jobKey = new JobKey(eventoAutomaticoPojo.getId().toString());
            JobDetail jobDetail = JobBuilder.newJob(EventoAutomaticoJob.class).withIdentity(jobKey).build();
            jobDetail.getJobDataMap().put("TIPO_EVENTO_AUTOMATICO", eventoAutomaticoPojo.getTipoEventoAutomatico());
            jobDetail.getJobDataMap().put("eventoAutomaticoId", eventoAutomaticoPojo.getId().toString());
            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(eventoAutomaticoPojo.getCronBuilder());
            cronScheduleBuilder.inTimeZone(TimeZone.getTimeZone(timeZone));
            Trigger trigger = TriggerBuilder.newTrigger().withSchedule(cronScheduleBuilder).build();
            Date dateHoraProximaExecucao = scheduler.scheduleJob(jobDetail, trigger);
            eventoAutomaticoPojo.setProximaExecucaoDateHora(dateHoraProximaExecucao);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            return eventoAutomaticoPojo;
        }
    }

    public EventoAutomaticoPojo agendarEventoAutomatico(EventoAutomaticoPojo eventoAutomaticoPojo) {
        try {
            eventoAutomaticoPojo = excluir(eventoAutomaticoPojo);
            eventoAutomaticoPojo = inserir(eventoAutomaticoPojo);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            return eventoAutomaticoPojo;
        }
    }

    public EventoAutomaticoPojo alterar(EventoAutomaticoPojo eventoAutomaticoPojo) {
        try {
            excluir(eventoAutomaticoPojo);
            eventoAutomaticoPojo = inserir(eventoAutomaticoPojo);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            return eventoAutomaticoPojo;
        }
    }

    public EventoAutomaticoPojo excluir(EventoAutomaticoPojo eventoAutomaticoPojo) {
        try {
            JobKey jobKey = new JobKey(eventoAutomaticoPojo.getId().toString());
            boolean deleteJob = scheduler.deleteJob(jobKey);
            eventoAutomaticoPojo.setExcluido(deleteJob);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            return eventoAutomaticoPojo;
        }
    }
}
