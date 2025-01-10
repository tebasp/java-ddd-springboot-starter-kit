package com.wgdesign.dashboard.users.infrastructure.persistence;

import com.wgdesign.dashboard.shared.infrastructure.persistence.hibernate.HibernateClient;
import com.wgdesign.dashboard.users.domain.entity.User;
import com.wgdesign.dashboard.users.domain.exception.UsersException;
import com.wgdesign.dashboard.users.domain.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Repository
public class JpaUserRepository implements UserRepository {
    private final Session session;

    public JpaUserRepository(HibernateClient hibernateClient) {
        session = hibernateClient.getSession();
    }

    @Override
    public Optional<User> getById(int id) {
        try {
            User user = session.get(User.class, id);
            return Optional.ofNullable(user);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            throw new UsersException("Error retrieving user");
        }
    }

    @Override
    @Transactional
    public void save(User user) {
        Transaction tx = session.beginTransaction();

        try {
            session.persist(user);
            session.flush();
            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
            System.out.println(e.getMessage());
            throw new UsersException("Error saving user");
        }
    }
}
