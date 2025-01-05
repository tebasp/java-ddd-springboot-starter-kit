package com.wgdesign.dashboard.shared.infrastructure.persistence.hibernate;

import com.wgdesign.dashboard.users.domain.entity.User;
import com.wgdesign.shared.infrastructure.config.Parameter;
import com.wgdesign.shared.infrastructure.config.ParameterNotExists;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

@Service
public class HibernateClient {
    public SessionFactory sessionFactory;
    private final Parameter config;

    public HibernateClient(Parameter config) throws ParameterNotExists {
        this.config = config;
        this.sessionFactory = buildSessionFactory();
    }

    private SessionFactory buildSessionFactory() throws ParameterNotExists {
        return new Configuration()
                .addAnnotatedClass(User.class)
                // Correct JDBC URL format for PostgreSQL
                .setProperty(AvailableSettings.JAKARTA_JDBC_URL,
                        config.get("DB_URL") + "/" + config.get("DB_NAME"))
                .setProperty(AvailableSettings.JAKARTA_JDBC_USER, config.get("DB_USER"))
                .setProperty(AvailableSettings.JAKARTA_JDBC_PASSWORD, config.get("DB_PASSWORD"))
                // Add PostgreSQL driver class
                .setProperty(AvailableSettings.JAKARTA_JDBC_DRIVER,
                        config.get("DB_DRIVER"))
                .buildSessionFactory();
    }

    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }
}


