package com.wgdesign.shared.domain.bus.event;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

public abstract class DomainEvent {
    private String aggregateId;
    private String eventId;
    private String occurredOn;

    protected DomainEvent() {}

    public DomainEvent(String aggregateId) {
        this.aggregateId = aggregateId;
        this.eventId = UUID.randomUUID().toString();
        this.occurredOn = LocalDateTime.now().toLocalDate().format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public DomainEvent(String aggregateId, String eventId, String occurredOn) {
        this.aggregateId = aggregateId;
        this.eventId = eventId;
        this.occurredOn = occurredOn;
    }

    public abstract String eventName();

    public abstract HashMap<String, Serializable> toPrimitives();

    public abstract DomainEvent fromPrimitives(
            String aggregateId,
            HashMap<String, Serializable> body,
            String eventId,
            String occurredOn);

    public String getAggregateId() {
        return aggregateId;
    }

    public String getEventId() {
        return eventId;
    }

    public String getOccurredOn() {
        return occurredOn;
    }
}
