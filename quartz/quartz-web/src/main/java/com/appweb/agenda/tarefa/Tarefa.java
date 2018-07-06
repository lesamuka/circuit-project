package com.appweb.agenda.tarefa;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;

public class Tarefa implements Job {

    public static Scheduler sched;

    @Override
    public void execute(JobExecutionContext jec) throws JobExecutionException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dataHora = format.format(new Date());
        System.out.println(dataHora);
    }
}
