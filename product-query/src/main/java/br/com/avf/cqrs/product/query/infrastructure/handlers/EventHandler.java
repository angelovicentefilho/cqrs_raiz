package br.com.avf.cqrs.product.query.infrastructure.handlers;

import br.com.avf.cqrs.product.commons.events.ProductCreatedEvent;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-18, Monday
 */
public interface EventHandler {

    void on(ProductCreatedEvent event);
}
