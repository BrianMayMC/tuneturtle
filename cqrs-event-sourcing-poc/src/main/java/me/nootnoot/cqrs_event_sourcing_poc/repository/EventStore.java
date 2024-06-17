package me.nootnoot.cqrs_event_sourcing_poc.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EventStore {
    private final List<Object> events = new ArrayList<>();

    public void saveEvent(Object event) {
        events.add(event);
    }

    public List<Object> getEvents() {
        return new ArrayList<>(events);
    }
}