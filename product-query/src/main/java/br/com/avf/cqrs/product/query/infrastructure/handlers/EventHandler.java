package br.com.avf.cqrs.product.query.infrastructure.handlers;

import br.com.avf.cqrs.product.commons.events.ProductCreatedEvent;
import br.com.avf.cqrs.product.commons.events.ProductDeletedEvent;
import br.com.avf.cqrs.product.commons.events.ProductUpdatedEvent;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-18, Monday
 */
public interface EventHandler {

    void on(ProductCreatedEvent event);
    void on(ProductUpdatedEvent event);
    void on(ProductDeletedEvent event);
}
