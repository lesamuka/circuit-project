package de.fred4jupiter.spring.boot.jsf;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.stereotype.Component;

@Component
public class ConfigContainer implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

    @Autowired
    private ServerProperties serverProperties;

    @Override
    public void customize(ConfigurableServletWebServerFactory factory) {
        factory.setPort(8080);
        factory.setContextPath("/spring-boot-jsf");

        TomcatServletWebServerFactory tomcatServletWebServerFactory = ((TomcatServletWebServerFactory) factory);
        
        TomcatConnectorCustomizer tomcatConnectorCustomizer = new TomcatConnectorCustomizer() {
            @Override
            public void customize(Connector connector) {
                Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
                protocol.setMaxConnections(200);
                protocol.setMaxThreads(200);
                protocol.setSelectorTimeout(3000);
                protocol.setSessionTimeout(3000);
                protocol.setConnectionTimeout(3000);
            }
        };
        tomcatServletWebServerFactory.addConnectorCustomizers(tomcatConnectorCustomizer);

    }
}
