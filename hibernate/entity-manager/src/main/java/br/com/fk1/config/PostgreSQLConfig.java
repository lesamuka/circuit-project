package br.com.fk1.config;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:postgresql.properties")
public class PostgreSQLConfig {

   @Value("${jdbc.driver}")
   private String jdbcDriver;

   @Value("${jdbc.url}")
   private String jdbcUrl;

   @Value("${jdbc.username}")
   private String username;

   @Value("${jdbc.password}")
   private String password;

   @Bean
   public DataSource getPostgreSQLDataSource() {
      BasicDataSource dataSource = new BasicDataSource();
      dataSource.setDriverClassName(jdbcDriver);
      dataSource.setUrl(jdbcUrl);
      dataSource.setUsername(username);
      dataSource.setPassword(password);
      return dataSource;
   }

}
