package br.com.avf.cqrs.product.commons.events;

import br.com.avf.cqrs.core.events.BaseEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-06, Wednesday
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ProductCreatedEvent extends BaseEvent {
    private String id;
    private String name;
    private Integer quantity;
    private BigDecimal price;
}
