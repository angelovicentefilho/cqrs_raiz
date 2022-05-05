package br.com.avf.cqrs.product.command.api.commands;

import br.com.avf.cqrs.core.commands.BaseCommand;


/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-05-04, Wednesday
 */
public class DeleteProductCommand extends BaseCommand {
    public DeleteProductCommand(String id) {
        super(id);
    }
}
