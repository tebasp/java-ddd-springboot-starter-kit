package com.wgdesign.shared.domain.bus.event;

import java.util.List;

public interface EventBus {
    void publish(List<DomainEvent> events);
}
