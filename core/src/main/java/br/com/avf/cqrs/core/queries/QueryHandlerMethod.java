package br.com.avf.cqrs.core.queries;

import br.com.avf.cqrs.core.domains.BaseEntity;

import java.util.List;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-06, Wednesday
 */
@FunctionalInterface
public interface QueryHandlerMethod<T> {
    List<BaseEntity> handle(T query);
}
