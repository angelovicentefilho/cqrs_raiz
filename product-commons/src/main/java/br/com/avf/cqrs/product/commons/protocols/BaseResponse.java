package br.com.avf.cqrs.product.commons.protocols;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-06, Wednesday
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class BaseResponse {
    private String message;
}
