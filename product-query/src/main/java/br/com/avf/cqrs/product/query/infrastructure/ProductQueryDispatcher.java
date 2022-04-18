package br.com.avf.cqrs.product.query.infrastructure;

import br.com.avf.cqrs.core.domains.BaseEntity;
import br.com.avf.cqrs.core.infraestructures.QueryDispatcher;
import br.com.avf.cqrs.core.queries.BaseQuery;
import br.com.avf.cqrs.core.queries.QueryHandlerMethod;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-18, Monday
 */
@Service
public class ProductQueryDispatcher implements QueryDispatcher {

    private final Map<Class<? extends BaseQuery>, List<QueryHandlerMethod>> routes = new HashMap<>();

    @Override
    public <T extends BaseQuery> void register(Class<T> type, QueryHandlerMethod<T> handler) {
        List<QueryHandlerMethod> handlers = routes.computeIfAbsent(type, c -> new LinkedList<>());
        handlers.add(handler);
    }

    @Override
    public <U extends BaseEntity> List<U> send(BaseQuery query) {
        List<QueryHandlerMethod> hadlers = routes.get(query.getClass());
        if (hadlers == null || hadlers.size() <= 0) {
            throw new RuntimeException("Não existe handler para essa classe!");
        }
        if (hadlers.size() > 1) {
            throw new RuntimeException("Não posso ter mais de um handler para uma query!");
        }
        return hadlers.get(0).handle(query);
    }
}
