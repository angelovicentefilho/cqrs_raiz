package br.com.avf.cqrs.core.commands;

import br.com.avf.cqrs.core.messages.Message;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-05, Tuesday
 */
@Data
@NoArgsConstructor
public abstract class BaseCommand extends Message {
    public BaseCommand(String message) {
        super(message);
    }
}
