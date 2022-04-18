package br.com.avf.cqrs.core.infraestructures;

import br.com.avf.cqrs.core.events.BaseEvent;

import java.util.List;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-06, Wednesday
 */
public interface EventStore {
    void save(String aggregateId, Iterable<BaseEvent> events, int expectedVersion);

    List<BaseEvent> getEvents(String aggregateId);

    List<String> getAggregateIds();
}
