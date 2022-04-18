package br.com.avf.cqrs.product.query.api.queries;

import br.com.avf.cqrs.core.queries.BaseQuery;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-18, Monday
 */
@Data
@AllArgsConstructor
public class FindProductByIdQuery extends BaseQuery {
    private String id;
}
