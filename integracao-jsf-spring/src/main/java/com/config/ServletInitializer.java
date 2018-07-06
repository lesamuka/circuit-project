package com.config;

import javax.annotation.PostConstruct;
import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.ServletContextAware;

@Configuration
public class ServletInitializer extends SpringBootServletInitializer implements ServletContextAware {

    @Autowired
    private ServletContext servletContext;

    @PostConstruct
    private void init() {
        WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext, WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        System.out.print(ServletInitializer.class.getPackage());
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext, WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
    }

    @Bean
    public ServletRegistrationBean facesServlet() {
        FacesServlet servlet = new FacesServlet();
        ServletRegistrationBean registration = new ServletRegistrationBean(servlet, "*.xhtml");
        registration.setName("FacesServlet");
        registration.setLoadOnStartup(1);
        return registration;
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
//        servletContext.setInitParameter("javax.faces.PROJECT_STAGE", "Development");
//        servletContext.setInitParameter("javax.faces.DEFAULT_SUFFIX", ".xhtml");
//        servletContext.setInitParameter("primefaces.CLIENT_SIDE_VALIDATION", "true");
    }
}
