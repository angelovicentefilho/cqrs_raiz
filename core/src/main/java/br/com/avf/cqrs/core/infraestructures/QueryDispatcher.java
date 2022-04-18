package br.com.avf.cqrs.core.infraestructures;

import br.com.avf.cqrs.core.domains.BaseEntity;
import br.com.avf.cqrs.core.queries.BaseQuery;
import br.com.avf.cqrs.core.queries.QueryHandlerMethod;

import java.util.List;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-06, Wednesday
 */
public interface QueryDispatcher {
    <T extends BaseQuery> void register(Class<T> type, QueryHandlerMethod<T> handler);

    <U extends BaseEntity> List<U> send(BaseQuery query);
}
