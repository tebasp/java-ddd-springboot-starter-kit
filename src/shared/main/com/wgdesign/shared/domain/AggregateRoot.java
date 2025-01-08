package com.wgdesign.shared.domain;

import com.wgdesign.shared.domain.bus.event.DomainEvent;

import java.util.ArrayList;
import java.util.List;

public abstract class AggregateRoot {
    private List<DomainEvent> domainEvents = new ArrayList<>();

    final public List<DomainEvent> pullDomainEvents() {
        List<DomainEvent> events = domainEvents;

        domainEvents = new ArrayList<>();

        return events;
    }

    final protected void record(DomainEvent event) {
        domainEvents.add(event);
    }
}
