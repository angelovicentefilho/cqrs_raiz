package br.com.avf.cqrs.core.handlers;

import br.com.avf.cqrs.core.domains.AggregateRoot;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-05, Tuesday
 */
public interface EventSourcingHandler<T> {
    void save(AggregateRoot aggregate);
    T getById(String id);
    void republishEvents();
}
