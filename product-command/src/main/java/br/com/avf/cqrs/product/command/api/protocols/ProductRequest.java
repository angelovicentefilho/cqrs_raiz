package br.com.avf.cqrs.product.command.api.protocols;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-11, Monday
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductRequest {
    private String id;
    private String name;
    private Integer quantity;
    private BigDecimal price;
}
