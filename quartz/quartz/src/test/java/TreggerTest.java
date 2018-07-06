
import br.exemplo.quartz.Application;
import br.exemplo.quartz.job.Tarefa;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.quartz.impl.triggers.SimpleTriggerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@SpringApplicationConfiguration(classes = Application.class)
public class TreggerTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private Scheduler scheduler;

    public TreggerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    private Trigger createSingleshotTrigger(TriggerKey triggerKey) {
        SimpleTriggerImpl simpleTrigger = new SimpleTriggerImpl();
        simpleTrigger.setMisfireInstruction(SimpleTrigger.MISFIRE_INSTRUCTION_FIRE_NOW);
        simpleTrigger.setStartTime(new Date(System.currentTimeMillis()));
        simpleTrigger.setKey(triggerKey);
        simpleTrigger.setRepeatInterval(60000);
        simpleTrigger.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
        return simpleTrigger;
    }

    private JobDetail createJobDetail(JobKey jobKey) {
        JobDetail jobDetail = JobBuilder.newJob(Tarefa.class).withIdentity(jobKey).build();
        return jobDetail;
    }

    @Test
    public void hello() throws SchedulerException, InterruptedException {

//        Scheduler scheduler;
//
//        scheduler = StdSchedulerFactory.getDefaultScheduler();
//
//        scheduler.start();
        TriggerKey triggerKey = new TriggerKey("myTrigger", "group1");
        JobKey jobKey = new JobKey("myJob", "group1");

        Trigger trigger;
        JobDetail jobDetail;

//        {
//            jobDetail = createJobDetail(jobKey);
//            CronScheduleBuilder cronSchedule = CronScheduleBuilder.cronSchedule("0/20 * * * * ?");
//
//            trigger = TriggerBuilder.newTrigger().withIdentity(triggerKey).withSchedule(cronSchedule).build();
//
//            //add passing parameters to JobDataMap for second JobDetail 		
//            jobDetail.getJobDataMap().put("TEST", "RAHIM");
//            jobDetail.getJobDataMap().put("TESTE", 21);
//
//        }
        {
            jobDetail = createJobDetail(jobKey);
            jobDetail.getJobDataMap().put("TESTE", 21);
            jobDetail.getJobDataMap().put("TEST", "RAHIM");
            trigger = createSingleshotTrigger(triggerKey);
        }

        scheduler.scheduleJob(jobDetail, trigger);

        while (true) {
            if (true) {
                Thread.sleep(1000L);
                List<JobExecutionContext> currentlyExecutingJobs = scheduler.getCurrentlyExecutingJobs();
                if (currentlyExecutingJobs.size() > 0) {
                    JobExecutionContext get = currentlyExecutingJobs.get(0);
                }

                Trigger trigger1 = scheduler.getTrigger(triggerKey);
                Date nextFireTime = trigger1.getNextFireTime();
                System.out.println("[jobName] : " + trigger1.getDescription() + " [groupName] : " + "------" + " - " + new Date() + " - " + nextFireTime);

//                JobDetail jobDetail = scheduler.getJobDetail(jobKey);
//
//                String jobName = jobKey.getName();
//                String jobGroup = jobKey.getGroup();
//
//                List<Trigger> triggers = (List<Trigger>) scheduler.getTriggersOfJob(jobKey);
//                for (String jobName : ) {
//
//                    //get job's trigger
//                    Trigger[] triggers = scheduler.getTriggersOfJob(jobName, "group1");
//                    Date nextFireTime = triggers[0].getNextFireTime();
//
//
//                }
            }
        }
    }
}
