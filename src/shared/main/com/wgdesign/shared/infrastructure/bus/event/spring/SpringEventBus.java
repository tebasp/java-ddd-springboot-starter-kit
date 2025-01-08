package com.wgdesign.shared.infrastructure.bus.event.spring;

import com.wgdesign.shared.domain.bus.event.DomainEvent;
import com.wgdesign.shared.domain.bus.event.EventBus;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Primary
@Service
public class SpringEventBus implements EventBus {
    private final ApplicationEventPublisher publisher;

    public SpringEventBus(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void publish(List<DomainEvent> events) {
        events.forEach(this::publish);
    }

    private void publish(DomainEvent event) {
        this.publisher.publishEvent(event);
    }
}
