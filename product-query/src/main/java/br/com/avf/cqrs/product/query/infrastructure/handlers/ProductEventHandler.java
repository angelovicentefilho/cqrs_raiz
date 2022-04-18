package br.com.avf.cqrs.product.query.infrastructure.handlers;

import br.com.avf.cqrs.product.commons.events.ProductCreatedEvent;
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
}
