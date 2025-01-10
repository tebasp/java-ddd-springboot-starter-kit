package com.wgdesign.dashboard.users_counter.application;

import com.wgdesign.dashboard.users_counter.domain.entity.UserCounter;
import com.wgdesign.dashboard.users_counter.domain.repository.UserCounterRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserCounterIncrementer {
    private final UserCounterRepository repository;

    public UserCounterIncrementer(UserCounterRepository repository) {
        this.repository = repository;
    }

    public void increment(String id) {
        try {
            Optional<UserCounter> userCounter = repository.findById(Integer.parseInt(id));

            System.out.println("\nUserCounter: " + userCounter.toString());


            if (userCounter.isEmpty()) {
                UserCounter newUser = new UserCounter();
                newUser.setCount(1);
                repository.save(newUser);
            }

            if (userCounter.isPresent()) {
                userCounter.get().increment();
                repository.update(userCounter.get());
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
