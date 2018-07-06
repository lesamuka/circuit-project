package br.com.fk1.authorization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class Authorization extends WebSecurityConfigurerAdapter {

    private static final long serialVersionUID = -6849451730127629238L;

    @Autowired
    private EventoAutomaticoProperties eventoAutomaticoProperties;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        // Para qualquer requisição (anyRequest) é preciso estar 
        // autenticado (authenticated).
        http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
    }

    @Override
    public void configure(AuthenticationManagerBuilder builder) throws Exception {
        Principal principal = eventoAutomaticoProperties.propertiesHost();
        String login = principal.getLogin();
        String password = principal.getPassword();
        builder.inMemoryAuthentication().withUser(login).password(password).roles("ADMIN");
    }

}
