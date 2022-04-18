package br.com.avf.cqrs.product.command.domain;

import br.com.avf.cqrs.core.events.EventModel;
import br.com.avf.cqrs.core.infraestructures.EventStore;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-06, Wednesday
 */
@Repository
public interface EventStoreRepository extends MongoRepository<EventModel, String> {
    List<EventModel> findByAggregateIdentifier(String aggregateId);
}
