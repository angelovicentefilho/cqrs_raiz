package br.com.avf.cqrs.product.query.api.queries;

import br.com.avf.cqrs.core.domains.BaseEntity;

import java.util.List;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-18, Monday
 */
public interface QueryHandler {

    List<BaseEntity> handle(FindAllProductsQuery query);
    List<BaseEntity> handle(FindProductByIdQuery query);
}
