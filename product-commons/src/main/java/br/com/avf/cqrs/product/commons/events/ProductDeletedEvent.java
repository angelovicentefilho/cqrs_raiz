package br.com.avf.cqrs.product.commons.events;

import br.com.avf.cqrs.core.events.BaseEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-05-04, Wednesday
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ProductDeletedEvent extends BaseEvent {
    private String id;
}
