package br.com.avf.cqrs.product.query.api.queries;

import br.com.avf.cqrs.core.domains.BaseEntity;
import br.com.avf.cqrs.product.query.domains.ProductEntity;
import br.com.avf.cqrs.product.query.domains.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-18, Monday
 */
@Service
@RequiredArgsConstructor
public class ProductQueryHandler implements QueryHandler {

    private final ProductRepository repository;

    @Override
    public List<BaseEntity> handle(FindAllProductsQuery query) {
        Iterable<ProductEntity> products = this.repository.findAll();
        List<BaseEntity> list = new ArrayList<>();
        products.forEach(list::add);
        return list;
    }

    @Override
    public List<BaseEntity> handle(FindProductByIdQuery query) {
        Optional<ProductEntity> optional = this.repository.findById(query.getId());
        if (!optional.isPresent()) {
            return null;
        }
        List<BaseEntity> list = new ArrayList<>();
        list.add(optional.get());
        return list;
    }
}
