package br.com.avf.cqrs.product.command.api.commands;

import br.com.avf.cqrs.core.handlers.EventSourcingHandler;
import br.com.avf.cqrs.product.command.domain.ProductAggregate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-06, Wednesday
 */
@Service
@RequiredArgsConstructor
public class ProductCommandHandler implements CommandHandler {

    private final EventSourcingHandler<ProductAggregate> eventSourcingHandler;

    @Override
    public void handle(CreateProductCommand command) {
        var aggregate = new ProductAggregate(command);
        eventSourcingHandler.save(aggregate);
    }

    @Override
    public void handle(UpdateProductCommand command) {
        var aggregate = eventSourcingHandler.getById(command.getId());
        aggregate.update(command);
        eventSourcingHandler.save(aggregate);
    }

    @Override
    public void handle(DeleteProductCommand command) {
        var aggregate = eventSourcingHandler.getById(command.getId());
        aggregate.delete(command.getId());
        eventSourcingHandler.save(aggregate);
    }

    @Override
    public void handle(RestoreDataBaseCommand command) {
        eventSourcingHandler.republishEvents();
    }

}
