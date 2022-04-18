package br.com.avf.cqrs.core.messages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-05, Tuesday
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class Message {
    private String id;
}
