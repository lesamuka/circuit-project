package br.exemplo.quartz.conf;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

/**
 * Classe responsável pela injeção de dependência do Spring.
 *
 * @author Alci Barros
 * @since 1.5.84.00 do salute
 */
public final class AutowiringSpringBeanJobFactory extends SpringBeanJobFactory implements ApplicationContextAware {

    private ApplicationContext aplApplicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.aplApplicationContext = applicationContext;
    }

    @Override
    protected Object createJobInstance(TriggerFiredBundle triggerFiredBundle) throws Exception {
        Object jobInstance = super.createJobInstance(triggerFiredBundle);
        aplApplicationContext.getAutowireCapableBeanFactory().autowireBean(jobInstance);
        return jobInstance;
    }
}