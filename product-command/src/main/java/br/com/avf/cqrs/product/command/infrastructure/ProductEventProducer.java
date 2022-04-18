package br.com.avf.cqrs.product.command.infrastructure;

import br.com.avf.cqrs.core.events.BaseEvent;
import br.com.avf.cqrs.core.producers.EventProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-06, Wednesday
 */
@Service
@RequiredArgsConstructor
public class ProductEventProducer implements EventProducer {

    private final KafkaTemplate<String, Object> kafka;

    @Override
    public void producer(String topic, BaseEvent event) {
        this.kafka.send(topic, event);
    }
}
