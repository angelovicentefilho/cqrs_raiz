package br.com.avf.cqrs.product.command.api.commands;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-06, Wednesday
 */
public interface CommandHandler {

    void handle(CreateProductCommand command);
    void handle(UpdateProductCommand command);
    void handle(DeleteProductCommand command);
}
