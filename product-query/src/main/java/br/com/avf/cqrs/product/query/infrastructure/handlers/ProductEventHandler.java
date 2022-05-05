package br.com.avf.cqrs.product.query.infrastructure.handlers;

import br.com.avf.cqrs.product.commons.events.ProductCreatedEvent;
import br.com.avf.cqrs.product.commons.events.ProductDeletedEvent;
import br.com.avf.cqrs.product.commons.events.ProductUpdatedEvent;
import br.com.avf.cqrs.product.query.domains.ProductRepository;
import br.com.avf.cqrs.product.query.infrastructure.codec.Codec;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-18, Monday
 */
@Service
@RequiredArgsConstructor
public class ProductEventHandler implements EventHandler {

    private final ProductRepository repository;

    @Override
    public void on(ProductCreatedEvent event) {
        var entity = Codec.toEntity(event);
        this.repository.save(entity);
    }

    @Override
    public void on(ProductUpdatedEvent event) {
        var entity = this.repository.findById(event.getId());
        entity.ifPresent(x -> this.repository.save(Codec.toEntity(event)));
    }

    @Override
    public void on(ProductDeletedEvent event) {
        var entity = this.repository.findById(event.getId());
        entity.ifPresent(x -> this.repository.deleteById(x.getId()));
    }
}
