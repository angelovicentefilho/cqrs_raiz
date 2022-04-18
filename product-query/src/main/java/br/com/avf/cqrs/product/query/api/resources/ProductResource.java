package br.com.avf.cqrs.product.query.api.resources;

import br.com.avf.cqrs.core.infraestructures.QueryDispatcher;
import br.com.avf.cqrs.product.query.api.protocols.ProductResponse;
import br.com.avf.cqrs.product.query.api.queries.FindAllProductsQuery;
import br.com.avf.cqrs.product.query.api.queries.FindProductByIdQuery;
import br.com.avf.cqrs.product.query.domains.ProductEntity;
import br.com.avf.cqrs.product.query.infrastructure.codec.Codec;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-18, Monday
 */
@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductResource {

    private final QueryDispatcher dispatcher;

    @GetMapping
    public ResponseEntity<ProductResponse> all() {
        try {
            List<ProductEntity> products = dispatcher.send(new FindAllProductsQuery());
            if (products == null || products.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            var response = Codec.toResponse(products);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ProductResponse("Não pode localizar o produto"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable String id) {
        try {
            List<ProductEntity> products = dispatcher.send(new FindProductByIdQuery(id));
            if (products == null || products.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            var response = Codec.toResponse(products);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ProductResponse("Não pode localizar o produto"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
