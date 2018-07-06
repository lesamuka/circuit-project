package br.com.fk1;

import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

@SpringApplicationConfiguration(classes = Application.class)
public class ApplicationTest extends AbstractTransactionalTestNGSpringContextTests {

//    @Autowired
//    private SchedulerFactoryBean schedulerFactoryBean;

    @Test
    public void test() throws Exception {

//        Scheduler scheduler = schedulerFactoryBean.getScheduler();
//
//        JobDetail jobDetail = JobBuilder.newJob(SampleJob.class)
//                .build();
//
//        Trigger trigger = TriggerBuilder.newTrigger()
//                .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
//                .build();
//
//        Date scheduleJob = scheduler.scheduleJob(jobDetail, trigger);
//        scheduler.start();
//        System.out.println(scheduleJob);

//        while (true) {
//            List<String> calendarNames = scheduler.getCalendarNames();
//            List<String> jobGroupNames = scheduler.getJobGroupNames();
//            ListenerManager listenerManager = scheduler.getListenerManager();
//            String schedulerInstanceId = scheduler.getSchedulerInstanceId();
//            String schedulerName = scheduler.getSchedulerName();
//            List<String> triggerGroupNames = scheduler.getTriggerGroupNames();
//            if (false) {
//                System.out.println("");
//            }
//        }
    }
}
