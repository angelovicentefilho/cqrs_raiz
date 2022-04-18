package br.com.avf.cqrs.product.command.codec;

import br.com.avf.cqrs.core.events.BaseEvent;
import br.com.avf.cqrs.core.events.EventModel;
import br.com.avf.cqrs.product.command.api.commands.CreateProductCommand;
import br.com.avf.cqrs.product.command.api.protocols.ProductRequest;
import br.com.avf.cqrs.product.command.domain.ProductAggregate;
import br.com.avf.cqrs.product.commons.events.ProductCreatedEvent;
import lombok.experimental.UtilityClass;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-06, Wednesday
 */
@UtilityClass
public class Codec {

    public static ProductCreatedEvent toEvent(CreateProductCommand command) {
        var event = new ProductCreatedEvent();
        BeanUtils.copyProperties(command, event);
        return event;
    }

    public static EventModel toEventModel(String aggregateId, int version, BaseEvent event) {
        return EventModel.builder()
                .aggregateIdentifier(aggregateId)
                .timestamp(new Date())
                .aggregateType(ProductAggregate.class.getTypeName())
                .version(version)
                .eventType(event.getClass().getTypeName())
                .eventData(event)
                .build();
    }

    public static CreateProductCommand toCommand(ProductRequest request) {
        var command = new CreateProductCommand();
        BeanUtils.copyProperties(request, command);
        return command;
    }
}
