//package br.exemplo.quartz.listener;
//
//import static jxl.biff.BaseCellFeatures.logger;
//import org.quartz.JobExecutionContext;
//import org.quartz.JobExecutionException;
//import org.quartz.JobListener;
//
//public class QuartzJobListner implements JobListener {
//    
//    private String name;
//
//    public QuartzJobListner() {
//    }
//    
//    public QuartzJobListner(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public String getName() {
//        logger.info("QuartzJobListner.getName()....................");
//        return "NOME";
//    }
//
//    @Override
//    public void jobToBeExecuted(JobExecutionContext context) {
//        logger.info("QuartzJobListner.jobToBeExecuted()....................");
//    }
//
//    @Override
//    public void jobExecutionVetoed(JobExecutionContext context) {
//        logger.info("QuartzJobListner.jobExecutionVetoed()....................");
//    }
//
//    @Override
//    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
//        logger.info("QuartzJobListner.jobWasExecuted()....................");
//    }
//}
