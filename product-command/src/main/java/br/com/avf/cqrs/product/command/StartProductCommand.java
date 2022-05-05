package br.com.avf.cqrs.product.command;

import br.com.avf.cqrs.core.infraestructures.CommandDispatcher;
import br.com.avf.cqrs.product.command.api.commands.CommandHandler;
import br.com.avf.cqrs.product.command.api.commands.CreateProductCommand;
import br.com.avf.cqrs.product.command.api.commands.DeleteProductCommand;
import br.com.avf.cqrs.product.command.api.commands.UpdateProductCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication(scanBasePackages = "br.com.avf.cqrs")
@RequiredArgsConstructor
public class StartProductCommand {

    private final CommandDispatcher commandDispatcher;
    private final CommandHandler commandHandler;

    public static void main(String[] args) {
        SpringApplication.run(StartProductCommand.class, args);
    }

    @PostConstruct
    public void init() {
        commandDispatcher.register(CreateProductCommand.class, commandHandler::handle);
        commandDispatcher.register(UpdateProductCommand.class, commandHandler::handle);
        commandDispatcher.register(DeleteProductCommand.class, commandHandler::handle);
    }

}
