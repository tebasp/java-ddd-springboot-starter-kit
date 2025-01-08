package com.wgdesign.dashboard.users.application.create;

import com.wgdesign.dashboard.users.domain.entity.User;
import com.wgdesign.dashboard.users.infrastructure.persistence.JpaUserRepository;
import com.wgdesign.shared.domain.bus.event.EventBus;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserCreator {
    private final JpaUserRepository repository;
    private final EventBus eventBus;

    public UserCreator(JpaUserRepository jpaUserRepository, EventBus eventBus) {
        this.repository = jpaUserRepository;
        this.eventBus = eventBus;
    }

    public void create(String name, Date birthDate) {
       User user = User.create(name, birthDate);

       repository.save(user);
       eventBus.publish(user.pullDomainEvents());
    }
}
