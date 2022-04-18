package br.com.avf.cqrs.product.query;

import br.com.avf.cqrs.core.infraestructures.QueryDispatcher;
import br.com.avf.cqrs.product.query.api.queries.FindAllProductsQuery;
import br.com.avf.cqrs.product.query.api.queries.FindProductByIdQuery;
import br.com.avf.cqrs.product.query.api.queries.QueryHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
@RequiredArgsConstructor
public class StartProductQuery {

    private final QueryHandler handler;
    private final QueryDispatcher dispatcher;

    public static void main(String[] args) {
        SpringApplication.run(StartProductQuery.class, args);
    }

    @PostConstruct
    public void init() {
        dispatcher.register(FindProductByIdQuery.class, handler::handle);
        dispatcher.register(FindAllProductsQuery.class, handler::handle);
    }

}
