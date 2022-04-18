package br.com.avf.cqrs.product.command.domain;

import br.com.avf.cqrs.core.domains.AggregateRoot;
import br.com.avf.cqrs.product.command.api.commands.CreateProductCommand;
import br.com.avf.cqrs.product.command.codec.Codec;
import br.com.avf.cqrs.product.commons.events.ProductCreatedEvent;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-06, Wednesday
 */
@NoArgsConstructor
public class ProductAggregate extends AggregateRoot {

    private String id;
    private String name;
    private Integer quantity;
    private BigDecimal price;

    public ProductAggregate(CreateProductCommand command) {
        raiseEvent(Codec.toEvent(command));
    }

    public void apply(ProductCreatedEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.quantity = event.getQuantity();
        this.price = event.getPrice();
    }

}
