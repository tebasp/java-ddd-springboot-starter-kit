package com.wgdesign.dashboard.users_counter.infrastructure.persistence;

import com.wgdesign.dashboard.shared.infrastructure.persistence.hibernate.HibernateClient;
import com.wgdesign.dashboard.users_counter.domain.entity.UserCounter;
import com.wgdesign.dashboard.users_counter.domain.repository.UserCounterRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import jakarta.persistence.LockModeType;
import jakarta.persistence.OptimisticLockException;
import jakarta.transaction.Transactional;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class JpaUserCounterRepository implements UserCounterRepository {
    private final Session session;

    public JpaUserCounterRepository(HibernateClient hibernateClient) {
        session = hibernateClient.getSession();
    }

    @Override
    public Optional<UserCounter> findById(Integer id) {
        try {
            UserCounter user = session.get(UserCounter.class, id);
            return Optional.ofNullable(user);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Integer count() {
        Long count = session.createQuery("SELECT COUNT(*) FROM User", Long.class).getSingleResult();

        return count.intValue();
    }

    @Override
    public void save(UserCounter userCounter) {
        Transaction tx = session.beginTransaction();

        try {
            session.persist(userCounter);
            session.flush();
            tx.commit();
        } catch (OptimisticLockException e) {
            tx.rollback();
            throw new RuntimeException("Entity was modified by another transaction. Please try again.", e);
        } catch (RuntimeException e) {
            System.out.println("Error Saving user counter" + e.getMessage());
            throw new RuntimeException("Error saving user counter", e);
        }
    }

    @Override
    public void update(UserCounter userCounter) {
        Transaction tx = session.beginTransaction();
        try {
            System.out.println("UserCounter update: " + userCounter.toString());
            session.merge(userCounter);
            session.flush();
            tx.commit();
        } catch (OptimisticLockException e) {
            tx.rollback();
            throw new RuntimeException("Entity was modified by another transaction. Please try again.", e);
        } catch (RuntimeException e) {
            System.out.println("Error Updating user counter" + e.getMessage());
            throw new RuntimeException("Error Updating user counter", e);
        }
    }


}
