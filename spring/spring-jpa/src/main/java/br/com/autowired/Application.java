//package br.com.autowired;
//
//import javax.annotation.PostConstruct;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@SpringBootApplication
//@ComponentScan(basePackages = {"br"})
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
//public class Application {
//    
//    @PostConstruct
//    private void init(){
//        
//    }
//
//    public static void main(String[] args) {
//        SpringApplication app = new SpringApplication(Application.class);
//        ConfigurableApplicationContext run = app.run(args);
//    }
//}
