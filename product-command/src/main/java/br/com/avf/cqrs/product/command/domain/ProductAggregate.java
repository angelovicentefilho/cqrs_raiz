package br.com.avf.cqrs.product.command.domain;

import br.com.avf.cqrs.core.domains.AggregateRoot;
import br.com.avf.cqrs.product.command.api.commands.CreateProductCommand;
import br.com.avf.cqrs.product.command.api.commands.UpdateProductCommand;
import br.com.avf.cqrs.product.command.codec.Codec;
import br.com.avf.cqrs.product.commons.events.ProductCreatedEvent;
import br.com.avf.cqrs.product.commons.events.ProductDeletedEvent;
import br.com.avf.cqrs.product.commons.events.ProductUpdatedEvent;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-06, Wednesday
 */
@NoArgsConstructor
public class ProductAggregate extends AggregateRoot {

    private String name;
    private Integer quantity;
    private BigDecimal price;
    private boolean active;

    public boolean isActive() {
        return this.active;
    }

    public ProductAggregate(CreateProductCommand command) {
        raiseEvent(Codec.toEvent(command));
    }

    public void apply(ProductCreatedEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.quantity = event.getQuantity();
        this.price = event.getPrice();
        this.active = true;
    }

    public void update(UpdateProductCommand command) {
        if(!this.active) {
            throw new IllegalStateException("Produto está deletado!");
        }

        if (command.getQuantity() < 0) {
            throw new IllegalArgumentException("Valor da quantidade não pode ser negativo!");
        }

        if (command.getPrice().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("O preco do produto não pode ser negativo!");
        }

        raiseEvent(Codec.toEvent(command));
    }

    public void apply(ProductUpdatedEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.quantity = event.getQuantity();
        this.price = event.getPrice();
    }

    public void delete(String id) {
        if(!this.active) {
            throw new IllegalStateException("Produto está deletado!");
        }
        raiseEvent(Codec.toEvent(id));
    }

    public void apply(ProductDeletedEvent event) {
        this.id = event.getId();
        this.active = false;
    }

}
