package br.com.avf.cqrs.product.command.infrastructure;

import br.com.avf.cqrs.core.domains.AggregateRoot;
import br.com.avf.cqrs.core.events.BaseEvent;
import br.com.avf.cqrs.core.handlers.EventSourcingHandler;
import br.com.avf.cqrs.core.infraestructures.EventStore;
import br.com.avf.cqrs.core.producers.EventProducer;
import br.com.avf.cqrs.product.command.domain.ProductAggregate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Comparator;
import java.util.Optional;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-06, Wednesday
 */
@Service
@RequiredArgsConstructor
public class ProductEventSourcingHandler implements EventSourcingHandler<ProductAggregate> {

    private final EventStore eventStore;
    private final EventProducer eventProducer;

    @Override
    public void save(AggregateRoot aggregate) {
        eventStore.save(aggregate.getId(), aggregate.getUncommittedChanges(), aggregate.getVersion());
        aggregate.markChangesAsCommitted();
    }

    @Override
    public ProductAggregate getById(String id) {
        var productAggregate = new ProductAggregate();
        var events = eventStore.getEvents(id);
        if (events != null && !events.isEmpty()) {
            productAggregate.replayEvents(events);
            Optional<Integer> latestVersion = events.stream().map(BaseEvent::getVersion).max(Comparator.naturalOrder());
            productAggregate.setVersion(latestVersion.get());
        }
        return productAggregate;
    }
}
