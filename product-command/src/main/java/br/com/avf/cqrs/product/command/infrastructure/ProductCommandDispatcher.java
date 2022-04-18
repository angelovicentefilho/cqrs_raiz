package br.com.avf.cqrs.product.command.infrastructure;

import br.com.avf.cqrs.core.commands.BaseCommand;
import br.com.avf.cqrs.core.commands.CommandHandlerMethod;
import br.com.avf.cqrs.core.infraestructures.CommandDispatcher;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-06, Wednesday
 */
@Service
public class ProductCommandDispatcher implements CommandDispatcher {

    private final Map<Class<? extends BaseCommand>, List<CommandHandlerMethod>> routes = new HashMap<>();

    @Override
    public <T extends BaseCommand> void register(Class<T> type, CommandHandlerMethod<T> handler) {
        List<CommandHandlerMethod> handlers = routes.computeIfAbsent(type, c-> new LinkedList<>());
        handlers.add(handler);
    }

    @Override
    public void send(BaseCommand command) {

        List<CommandHandlerMethod> handlers = routes.get(command.getClass());
        if (handlers == null || handlers.isEmpty()) {
            throw new RuntimeException("Não existe um handler para esse comando!");
        }

        if (handlers.size() > 1) {
            throw new RuntimeException("Não pode enviar um commando para mais de um handler!");
        }
        handlers.get(0).handle(command);

    }
}
