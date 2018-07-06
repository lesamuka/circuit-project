package br.com.fk1.quartz.conf;

import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Classe de configuração do Quartz
 *
 * @author Alci Barros
 * @since 1.5.84.00 do salute
 */
@Configuration
public class SchedulerBean {

    @Bean
    public AutowiringSpringBeanJobFactory jobFactory(ApplicationContext applicationContext) {
        AutowiringSpringBeanJobFactory jobFactory = new AutowiringSpringBeanJobFactory();
        jobFactory.setApplicationContext(applicationContext);
        return jobFactory;
    }   
    
    @Bean
    public Scheduler schedulerFactoryBean(ApplicationContext applicationContext, AutowiringSpringBeanJobFactory autowiringSpringBeanJobFactory) throws Exception {
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.setJobFactory(autowiringSpringBeanJobFactory);
        scheduler.start();
        return scheduler;
    }
}
