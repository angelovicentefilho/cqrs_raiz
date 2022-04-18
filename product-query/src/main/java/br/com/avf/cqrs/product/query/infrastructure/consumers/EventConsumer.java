package br.com.avf.cqrs.product.query.infrastructure.consumers;

import br.com.avf.cqrs.product.commons.events.ProductCreatedEvent;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-18, Monday
 */
public interface EventConsumer {

    void consume(@Payload ProductCreatedEvent event, Acknowledgment ack);
}
