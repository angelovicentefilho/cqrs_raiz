package br.com.avf.cqrs.product.command.api.commands;

import br.com.avf.cqrs.core.commands.BaseCommand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-06, Wednesday
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductCommand extends BaseCommand {
    private String name;
    private Integer quantity;
    private BigDecimal price;
}
