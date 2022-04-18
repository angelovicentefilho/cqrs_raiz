package br.com.avf.cqrs.product.query.infrastructure.consumers;

import br.com.avf.cqrs.product.commons.events.ProductCreatedEvent;
import br.com.avf.cqrs.product.query.infrastructure.handlers.EventHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-18, Monday
 */
@Service
@RequiredArgsConstructor
public class ProductEventConsumer implements EventConsumer {

    private final EventHandler handler;

    @KafkaListener(topics = "ProductCreatedEvent", groupId = "${spring.kafka.consumer.group-id}")
    @Override
    public void consume(@Payload ProductCreatedEvent event, Acknowledgment ack) {
        this.handler.on(event);
        ack.acknowledge();
    }
}
