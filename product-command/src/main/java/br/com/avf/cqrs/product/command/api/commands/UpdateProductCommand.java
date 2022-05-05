package br.com.avf.cqrs.product.command.api.commands;

import br.com.avf.cqrs.core.commands.BaseCommand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-05-04, Wednesday
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UpdateProductCommand extends BaseCommand {
    private String id;
    private String name;
    private Integer quantity;
    private BigDecimal price;
}
