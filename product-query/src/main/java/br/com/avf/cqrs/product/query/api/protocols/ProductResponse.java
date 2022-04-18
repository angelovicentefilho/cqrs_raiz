package br.com.avf.cqrs.product.query.api.protocols;

import br.com.avf.cqrs.product.commons.protocols.BaseResponse;
import br.com.avf.cqrs.product.query.domains.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-18, Monday
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse extends BaseResponse {

    private List<ProductEntity> products;

    public ProductResponse(String message) {
        super(message);
    }

}
