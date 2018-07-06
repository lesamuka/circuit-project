package com.security.config;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@Configuration
public class ServletInitializer extends SpringBootServletInitializer {

    @Autowired
    private ServletContext servletContext;

    @PostConstruct
    private void init() {
        WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext, WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        System.out.print(ServletInitializer.class.getPackage());
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WebApplication.class);
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext, WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        System.out.print(ServletInitializer.class.getPackage());
    }
}
