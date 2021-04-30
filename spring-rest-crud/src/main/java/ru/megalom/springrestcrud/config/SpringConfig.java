package ru.megalom.springrestcrud.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("ru.megalom.springrestcrud")
@PropertySource({"classpath:persistence.properties"})
public class SpringConfig {
    @Autowired
    private Environment env;
    private Logger logger = Logger.getLogger(getClass().getName());

    @Bean
    DataSource myDataSource(){
        ComboPooledDataSource myDataSource = new ComboPooledDataSource();
        try{
            myDataSource.setDriverClass(env.getProperty("jdbc.driver"));
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        myDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
        myDataSource.setUser(env.getProperty("jdbc.user"));
        myDataSource.setPassword(env.getProperty("jdbc.password"));
        //set connection pool props
        myDataSource.setInitialPoolSize(
                Integer.parseInt(env.getProperty("connection.pool.initialPoolSize")));
        myDataSource.setMinPoolSize(
                Integer.parseInt(env.getProperty("connection.pool.minPoolSize")));
        myDataSource.setMaxPoolSize(
                Integer.parseInt(env.getProperty("connection.pool.maxPoolSize")));
        myDataSource.setMaxIdleTime(
                Integer.parseInt(env.getProperty("connection.pool.maxIdleTime")));
        return myDataSource;
    }

    private Properties getHibernateProperties(){
        Properties properties=new Properties();
        properties.setProperty("hibernate.dialect",env.getProperty("hibernate.dialect"));
        properties.setProperty("hibernate.show_sql",env.getProperty("hibernate.showSql"));
        return properties;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
        sessionFactory.setDataSource(myDataSource());
        sessionFactory.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
        sessionFactory.setHibernateProperties(getHibernateProperties());
        return sessionFactory;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory){
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);
        return txManager;
    }
}
