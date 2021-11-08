package com.zplus.companycrud.configuration;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    SessionFactory sessionFactory(HibernateEntityManagerFactory hibernateEntityManagerFactory)
    {

        return  hibernateEntityManagerFactory.getSessionFactory();
    }
}
