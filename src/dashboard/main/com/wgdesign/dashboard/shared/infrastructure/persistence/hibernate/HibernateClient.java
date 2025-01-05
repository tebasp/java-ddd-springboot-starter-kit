package com.wgdesign.dashboard.shared.infrastructure.persistence.hibernate;

import com.wgdesign.dashboard.users.domain.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;

public class HibernateClient {
    public static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        return new Configuration()
                .addAnnotatedClass(User.class)
                // Correct JDBC URL format for PostgreSQL
                .setProperty(AvailableSettings.JAKARTA_JDBC_URL,
                        "jdbc:postgresql://localhost:5432/java_test")
                .setProperty(AvailableSettings.JAKARTA_JDBC_USER, "root")
                .setProperty(AvailableSettings.JAKARTA_JDBC_PASSWORD, "root")
                // Add PostgreSQL driver class
                .setProperty(AvailableSettings.JAKARTA_JDBC_DRIVER,
                        "org.postgresql.Driver")
                .buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}


