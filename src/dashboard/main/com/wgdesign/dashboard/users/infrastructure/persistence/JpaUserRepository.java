package com.wgdesign.dashboard.users.infrastructure.persistence;

import com.wgdesign.dashboard.shared.infrastructure.persistence.hibernate.HibernateClient;
import com.wgdesign.dashboard.users.domain.entity.User;
import com.wgdesign.dashboard.users.domain.exception.UsersException;
import com.wgdesign.dashboard.users.domain.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JpaUserRepository implements UserRepository {
    private final EntityManagerFactory emf;
    private final EntityManager em;

    public JpaUserRepository(HibernateClient hibernateClient) {
        emf = hibernateClient.getSessionFactory();
        em = emf.createEntityManager();
    }

    @Override
    public Optional<User> getById(int id) {
        try {
            User user = em.find(User.class, id);
            return Optional.ofNullable(user);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            throw new UsersException("Error retrieving user");
        }
    }
}
