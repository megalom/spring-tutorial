package ru.megalom.spingsecurity.demo.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.logging.Logger;

@Configuration
@EnableWebMvc
@ComponentScan("ru.megalom.spingsecurity.demo")
@PropertySource("classpath:persistence-postgres.properties")
public class DemoAppConfig {
    //env- holds properties from file
    @Autowired
    private Environment env;
    private Logger logger= Logger.getLogger(getClass().getName());

    @Bean
    public DataSource securityDataSource(){
        ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
        try {

            //set database connection props
            logger.info("=====>Setting jdbc driver"+env.getProperty("jdbc.driver"));
            securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
            logger.info("=====>Setting jdbc url"+env.getProperty("jdbc.url"));
            securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
            logger.info("=====>Setting jdbc user"+env.getProperty("jdbc.user"));
            securityDataSource.setUser(env.getProperty("jdbc.user"));
            logger.info("=====>Setting jdbc password"+env.getProperty("jdbc.password"));
            securityDataSource.setPassword(env.getProperty("jdbc.password"));

            //set connection pool props
            securityDataSource.setInitialPoolSize(
                    Integer.parseInt(env.getProperty("connection.pool.initialPoolSize")));
            securityDataSource.setMinPoolSize(
                    Integer.parseInt(env.getProperty("connection.pool.minPoolSize")));
            securityDataSource.setMaxPoolSize(
                    Integer.parseInt(env.getProperty("connection.pool.maxPoolSize")));
            securityDataSource.setMaxIdleTime(
                    Integer.parseInt(env.getProperty("connection.pool.maxIdleTime")));

        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return securityDataSource;
    }
    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    // define a bean for view resolver
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
