package com.openchowski.library.config;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.openchowski.library")
@PropertySource("classpath:application.properties")
public class AppConfig{

    private Environment environment;

    @Autowired
    public AppConfig(Environment environment){
        this.environment = environment;
    }

    @Bean
    public DataSource securityDataSource(){

        ComboPooledDataSource securityDataSource = new ComboPooledDataSource();

        try{
            securityDataSource.setDriverClass(environment.getProperty("jbdc.driver"));
        }catch(PropertyVetoException e){
            throw new RuntimeException(e);
        }

        securityDataSource.setJdbcUrl(environment.getProperty("spring.datasource.url"));
        securityDataSource.setUser(environment.getProperty("spring.datasource.username"));
        securityDataSource.setPassword(environment.getProperty("spring.datasource.password"));


        securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
        securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
        securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
        securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));


        return securityDataSource;
    }

    @Bean
    public ResourceBundleMessageSource resourceBundleMessageSource(){

        var source = new ResourceBundleMessageSource();
        source.setBasename("classpath:message.properties");
        source.setUseCodeAsDefaultMessage(true);
        return source;
    }




    private int getIntProperty(String propName) {
        String propVal = environment.getProperty(propName);
        int intPropVal = Integer.parseInt(propVal);
        return intPropVal;
    }


}
