package br.com.avf.cqrs.product.query.infrastructure.codec;

import br.com.avf.cqrs.product.commons.events.ProductCreatedEvent;
import br.com.avf.cqrs.product.query.api.protocols.ProductResponse;
import br.com.avf.cqrs.product.query.domains.ProductEntity;
import lombok.experimental.UtilityClass;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-18, Monday
 */
@UtilityClass
public class Codec {
    public static ProductEntity toEntity(ProductCreatedEvent event) {
        var entity = new ProductEntity();
        BeanUtils.copyProperties(event, entity);
        return entity;
    }

    public static ProductResponse toResponse(List<ProductEntity> products) {
        return ProductResponse.builder()
                .products(products)
                .build();
    }
}
