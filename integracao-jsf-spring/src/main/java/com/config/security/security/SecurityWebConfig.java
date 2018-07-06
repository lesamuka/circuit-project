package com.config.security.security;

import com.config.security.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityWebConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private Authorization authorization;

    @Autowired
    private LoginSuccess loginSuccess;

    @Autowired
    private LogoutSuccess logoutSuccess;

    @Autowired
    private LoginService ssUserDetailsService;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf()
                .disable()
            .authorizeRequests()
                .antMatchers("/javax.faces.resource/**")
                .permitAll()
                //.antMatchers("/**").permitAll()
                //              .antMatchers("/dashboard").hasRole("DASHBOARD")
                //              .antMatchers("/usuario").hasRole("USUARIO")
                .antMatchers("/resources/**", "/webjars/**").permitAll()
                //              .antMatchers("/vendas/relatorios/equipe").hasRole("VISUALIZAR_RELATORIO_EQUIPE")
                //              .antMatchers("/vendas/relatorios/custos").hasRole("VISUALIZAR_RELATORIO_CUSTOS")
                //              .antMatchers("/pages/**").access("hasRole('ADMIN') and hasIpAddress('123.123.123.123')") // pass SPEL using access method
                .anyRequest().authenticated()
            .and()
                .exceptionHandling().accessDeniedPage("/publuc/401/access.xhtml")
            .and()
                .formLogin()
                .defaultSuccessUrl("/index.xhtml")
                .successHandler(loginSuccess)
                .loginPage("/public/login/login.xhtml")
                .usernameParameter("username")
                .passwordParameter("password")
                .failureUrl("/login.xhtml?error=1")
                .permitAll()
            .and()
                .rememberMe()
            .and()
                .logout()
                .logoutUrl("/logout.xhtml")
                .logoutSuccessUrl("/logout.xhtml?logout")
                .invalidateHttpSession(true)
            .permitAll()
                .logoutSuccessHandler(logoutSuccess);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.authenticationProvider(authorization);
        builder.userDetailsService(ssUserDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder(16);
    }

}
