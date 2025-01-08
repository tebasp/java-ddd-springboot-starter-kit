package com.wgdesign.dashboard.users.domain.dto;

import com.wgdesign.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

public class UserCreatedDomainEvent extends DomainEvent {
    private final String name;
    private final Date birthDate;

    public UserCreatedDomainEvent() {
        super(null);

        this.name = null;
        this.birthDate = null;
    }

    public UserCreatedDomainEvent(String aggregateId, String name, Date birthDate) {
        super(aggregateId);

        this.name = name;
        this.birthDate = birthDate;
    }

    public UserCreatedDomainEvent(
            String aggregateId,
            String eventId,
            String occurredOn,
            String name,
            Date birthDate)
    {
        super(aggregateId, eventId, occurredOn);

        this.name = name;
        this.birthDate = birthDate;
    }

    @Override
    public String eventName() {
        return "user.created";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            put("name", name);
            put("birthDate", birthDate);
        }};
    }

    @Override
    public UserCreatedDomainEvent fromPrimitives(
            String aggregateId,
            HashMap<String, Serializable> body,
            String eventId,
            String occurredOn)
    {
        return new UserCreatedDomainEvent(
                aggregateId,
                eventId,
                occurredOn,
                (String) body.get("name"),
                (Date) body.get("birthDate"));
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCreatedDomainEvent that = (UserCreatedDomainEvent) o;
        return Objects.equals(name, that.name) && Objects.equals(birthDate, that.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthDate);
    }
}
