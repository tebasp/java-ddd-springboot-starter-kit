package com.wgdesign.dashboard.users.infrastructure.persistence;

import com.wgdesign.dashboard.shared.infrastructure.persistence.hibernate.HibernateClient;
import com.wgdesign.dashboard.users.domain.entity.User;
import com.wgdesign.dashboard.users.domain.exception.UsersException;
import com.wgdesign.dashboard.users.domain.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.stereotype.Service;

@Service
public class JpaUserRepository implements UserRepository {
    private final EntityManagerFactory emf;
    private final EntityManager em;

    public JpaUserRepository() {
        emf = HibernateClient.getSessionFactory();
        em = emf.createEntityManager();
    }

    @Override
    public User getById(int id) {
        try {
            User user = em.find(User.class, id);
            return user;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            throw new UsersException("Error retrieving user");
        }
    }
}