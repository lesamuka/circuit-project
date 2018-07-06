package br.com.fk1.config;

import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) throws SQLException {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MySQLConfig.class);

        @SuppressWarnings("unused")
        DataSource mysql = context.getBean("mysql", DataSource.class);

        @SuppressWarnings("unused")
        DataSource postgresql = context.getBean("postgresql", DataSource.class);
        context.close();
    }
}
