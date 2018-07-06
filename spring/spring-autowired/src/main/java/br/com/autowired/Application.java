package br.com.autowired;

import java.util.Optional;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@Configuration
@ComponentScan(basePackages = {"br.com.autowired"})
public class Application implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext annotationConfigWebApplicationContext = (AnnotationConfigWebApplicationContext) WebApplicationContextUtils.findWebApplicationContext(servletContext);
        annotationConfigWebApplicationContext = Optional.ofNullable(annotationConfigWebApplicationContext).orElseGet(AnnotationConfigWebApplicationContext::new);
        annotationConfigWebApplicationContext.register(this.getClass());
        servletContext.setAttribute("contexto", annotationConfigWebApplicationContext);
    }
}
