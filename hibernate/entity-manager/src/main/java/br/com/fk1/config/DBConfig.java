package br.com.fk1.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

@Configuration
@PropertySources(value = { @PropertySource("classpath:db.properties"),
      @PropertySource("classpath:${db1.name}.properties"),
      @PropertySource("classpath:${db2.name}.properties") })
public class DBConfig {

   @Autowired
   private Environment env;

   @Bean("mysql")
   public DataSource getMySQLDataSource() {
      BasicDataSource dataSource = new BasicDataSource();
      dataSource.setDriverClassName(env.getProperty("db.driver"));
      dataSource.setUrl(env.getProperty("db.url"));
      dataSource.setUsername(env.getProperty("db.username"));
      dataSource.setPassword(env.getProperty("db.password"));
      return dataSource;
   }

   @Bean("postgresql")
   public DataSource getPostgreSQLDataSource() {
      BasicDataSource dataSource = new BasicDataSource();
      dataSource.setDriverClassName(env.getProperty("jdbc.driver"));
      dataSource.setUrl(env.getProperty("jdbc.url"));
      dataSource.setUsername(env.getProperty("jdbc.username"));
      dataSource.setPassword(env.getProperty("jdbc.password"));
      return dataSource;
   }
}
