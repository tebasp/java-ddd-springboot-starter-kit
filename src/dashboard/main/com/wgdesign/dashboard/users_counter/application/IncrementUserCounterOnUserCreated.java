package com.wgdesign.dashboard.users_counter.application;

import com.wgdesign.dashboard.users.domain.dto.UserCreatedDomainEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class IncrementUserCounterOnUserCreated {
    private final UserCounterIncrementer incrementer;

    public IncrementUserCounterOnUserCreated(UserCounterIncrementer incrementer) {
        this.incrementer = incrementer;
    }

    @EventListener
    public void on(UserCreatedDomainEvent event) {
        this.incrementer.increment(event.getAggregateId());
    }
}
