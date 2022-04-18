package br.com.avf.cqrs.product.command.infrastructure;

import br.com.avf.cqrs.core.events.BaseEvent;
import br.com.avf.cqrs.core.events.EventModel;
import br.com.avf.cqrs.core.exceptions.AggregateNotFoundException;
import br.com.avf.cqrs.core.infraestructures.EventStore;
import br.com.avf.cqrs.product.command.codec.Codec;
import br.com.avf.cqrs.product.command.domain.EventStoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-06, Wednesday
 */
@Service
@RequiredArgsConstructor
public class ProductEventStore implements EventStore {

    private final EventStoreRepository repository;
    private final ProductEventProducer producer;


    @Override
    public void save(String aggregateId, Iterable<BaseEvent> events, int expectedVersion) {
        List<EventModel> eventModels = repository.findByAggregateIdentifier(aggregateId);
        if (expectedVersion != -1 && eventModels.get(eventModels.size()-1).getVersion() != expectedVersion) {
            throw new RuntimeException("Erro de concorrencia");
        }
        int version = expectedVersion;
        for (BaseEvent event: events) {
            version++;
            event.setVersion(version);
            var model = Codec.toEventModel(aggregateId, version, event);
            var modelPersisted = this.repository.save(model);
            if (!modelPersisted.getId().isEmpty()) {
                this.producer.producer(event.getClass().getSimpleName(), event);
            }
        }
    }

    @Override
    public List<BaseEvent> getEvents(String aggregateId) {
        List<EventModel> eventModels = repository.findByAggregateIdentifier(aggregateId);
        if (eventModels == null || eventModels.isEmpty()) {
            throw new AggregateNotFoundException("ID do produto não encontrado!");
        }
        return eventModels.stream().map(EventModel::getEventData).collect(Collectors.toList());
    }

    @Override
    public List<String> getAggregateIds() {
        List<EventModel> eventModels = repository.findAll();
        if (eventModels.isEmpty()) {
            throw new IllegalStateException("Não existe eventos para retornar!");
        }
        return eventModels.stream().map(EventModel::getAggregateIdentifier).distinct().collect(Collectors.toList());
    }
}
