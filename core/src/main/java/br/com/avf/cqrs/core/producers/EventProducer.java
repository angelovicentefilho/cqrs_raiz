package br.com.avf.cqrs.core.producers;

import br.com.avf.cqrs.core.events.BaseEvent;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-06, Wednesday
 */
public interface EventProducer {
    void producer(String topic, BaseEvent event);
}
