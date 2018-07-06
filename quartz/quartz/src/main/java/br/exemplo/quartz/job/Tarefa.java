package br.exemplo.quartz.job;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;

public class Tarefa implements Job {

    @Override
    public void execute(JobExecutionContext context) {

        JobDetail d = context.getJobDetail();
        JobDataMap m = d.getJobDataMap();
        String name = m.getString("bean");
        Method meth = (Method) m.get("method");
        m.put("TESTE", "RAM");  


        context.setResult("TESTE RESULT");

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dataHora = format.format(new Date());
        System.out.println(dataHora);
    }
}
