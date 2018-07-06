package br.com.fk1.config;

import br.com.fk1.config.MySQLConfig;
import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import javax.transaction.TransactionManager;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;

import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.persistenceunit.DefaultPersistenceUnitManager;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitManager;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

//@ComponentScan(basePackageClasses = ga.PackageInfo.class)
//@EnableTransactionManagement
//@PropertySource({"classpath:/META-INF/database.properties"})
@Import(value = {
    MySQLConfig.class
})
@Configuration
public class ConfiguraSpring {

    @Bean
    public JpaTransactionManager txManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory);
        return txManager;
    }
    
    @Bean
    public HibernateJpaVendorAdapter getHibernateJpaVendorAdapter(Database database){
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setDatabase(database);
        hibernateJpaVendorAdapter.setShowSql(true);
        return hibernateJpaVendorAdapter;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory(DataSource dataSource, PersistenceUnitManager persistenceUnitManager) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setPersistenceUnitManager(persistenceUnitManager);
        em.setPersistenceUnitName("SalutePU");
        em.afterPropertiesSet();
        return em.getObject();
    }

    @Bean
    public DefaultPersistenceUnitManager persistenceUnitManager(DataSource dataSource) {
        DefaultPersistenceUnitManager persistenceUnitManager = new DefaultPersistenceUnitManager();
        persistenceUnitManager.setDefaultDataSource(dataSource);
        persistenceUnitManager.setPersistenceXmlLocation("classpath*:META-INF/persistence.xml");
        return persistenceUnitManager;
    }

//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
//        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//        em.setPersistenceXmlLocation("classpath:META-INF/persistence.xml");
//        em.setPersistenceUnitName("SalutePU");
//        em.setDataSource(dataSource);
//
//        HibernateJpaVendorAdapter vendor = new HibernateJpaVendorAdapter();
//        vendor.setShowSql(false);
//        em.setJpaVendorAdapter(vendor);
//        return em;
//    }

    @Bean
    public TransactionTemplate transactionTemplate(JpaTransactionManager jpaTransactionManager) {
        TransactionTemplate transactionTemplate = new TransactionTemplate();
        transactionTemplate.setTransactionManager(jpaTransactionManager);
        return transactionTemplate;
    }

//    @Autowired
//    Environment env;
//    
//    
//    @Autowired
//    private DataSource dataSource;
//
//    //${jdbc.driverClassName}
//    @Value("${jdbc.driverClassName}")
//    private String driverClassName;
//
//    @Value("${jdbc.url}")
//    private String url;
//
//    @Value("${jdbc.username}")
//    private String username;
//
//    @Value("${database.password}")
//    private String password;
//
//    @Value("${hibernate.dialect}")
//    private String hibernateDialect;
//
//    @Value("${hibernate.show_sql}")
//    private String hibernateShowSql;
//    
//
//    @Bean()
//    public DataSource getDataSource(Properties connectionProperties) {
//        Properties properties = new Properties();
//        properties.put("hibernate.dialect", "br.com.fk1.salute.service.dialect.MyCustomDialect");
//        properties.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
//        properties.put("javax.persistence.jdbc.url", "jdbc:mysql://localhost:3306/salute_prod");
//        properties.put("hibernate.show_sql", "true");
//
//        properties.put("javax.persistence.jdbc.user", "root");
//        properties.put("javax.persistence.jdbc.password", "root");
//
//
//        DriverManagerDataSource ds = new DriverManagerDataSource();
////        ds.setDriverClassName(com.mysql.jdbc.Driver.class.getName());
////        ds.setUrl("jdbc:mysql://localhost:3306/salute_prod");
////        ds.setUsername("root");
////        ds.setPassword("root");
//        ds.setConnectionProperties(properties);
//        return ds;
//    }
//
//
//    @Bean
//    @Autowired
//    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
//        HibernateTransactionManager htm = new HibernateTransactionManager();
//        htm.setSessionFactory(sessionFactory);
//        return htm;
//    }
//    
//    @Bean
//    @Autowired
//    public HibernateTemplate getHibernateTemplate(SessionFactory sessionFactory) {
//        HibernateTemplate hibernateTemplate = new HibernateTemplate(sessionFactory);
//        return hibernateTemplate;
//    }
//    
//    @Bean
//    public AnnotationSessionFactoryBean getSessionFactory(DataSource dataSource, Properties properties) {
//        AnnotationSessionFactoryBean asfb = new AnnotationSessionFactoryBean();
//        asfb.setDataSource(dataSource);
//        asfb.setHibernateProperties(properties);
//        asfb.setPackagesToScan(new String[]{"br.com.fk1"});
//        return asfb;
//    }
//    
//    @Bean
//    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
//        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
//        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory());
//        return jpaTransactionManager;
//    }
//    
//    @Bean
//    public TransactionTemplate transactionTemplate(HibernateTransactionManager hibernateTransactionManager) {
//        TransactionTemplate transactionTemplate = new TransactionTemplate();
//        transactionTemplate.setTransactionManager(hibernateTransactionManager);
//        transactionTemplate.setReadOnly(true);
//        return transactionTemplate;
//    }
//    
//    
//    @Bean
//    public JpaVendorAdapter jpaVendorAdaper() {
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        vendorAdapter.setDatabase(env.getProperty("jpa.database", Database.class));
//        vendorAdapter.setShowSql(env.getProperty("jpa.showSql", Boolean.class));
//        vendorAdapter.setGenerateDdl(env.getProperty("jpa.generateDdl", Boolean.class));
//        return vendorAdapter;
//    }
//    private Map<String, Object> additionalProperties() {
//        Map<String, Object> properties = new HashMap<String, Object>();
//        properties.put("hibernate.validator.apply_to_ddl", "false");
//        properties.put("hibernate.validator.autoregister_listeners", "false");
//        properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
//        properties.put("hibernate.generate_statistics", env.getProperty("hibernate.generate_statistics"));
//        // Second level cache configuration and so on.
//        return properties;
//    }
//    
//    @Bean
//    public Properties getHibernateProperties(Properties properties) {
//        properties.put("hibernate.dialect", "br.com.fk1.salute.service.dialect.MyCustomDialect");
//        properties.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");    
//        properties.put("javax.persistence.jdbc.url", "jdbc:mysql://localhost:3306/salute_prod");
//        properties.put("hibernate.show_sql", "true");
////        properties.put("hibernate.hbm2ddl.auto", "none");
//        properties.put("hibernate.show_sql", "true");
//        
//        properties.put("javax.persistence.jdbc.user", "root");
//        properties.put("javax.persistence.jdbc.password", "root");
//        return properties;
//    }
}
