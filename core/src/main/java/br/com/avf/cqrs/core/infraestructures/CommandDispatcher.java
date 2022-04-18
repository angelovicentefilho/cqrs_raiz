package br.com.avf.cqrs.core.infraestructures;

import br.com.avf.cqrs.core.commands.BaseCommand;
import br.com.avf.cqrs.core.commands.CommandHandlerMethod;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-06, Wednesday
 */
public interface CommandDispatcher {
    <T extends BaseCommand> void register(Class<T> type, CommandHandlerMethod<T> handler);

    void send(BaseCommand command);
}
