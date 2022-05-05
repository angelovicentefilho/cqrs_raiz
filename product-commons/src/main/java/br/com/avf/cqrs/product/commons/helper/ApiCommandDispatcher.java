package br.com.avf.cqrs.product.commons.helper;

import br.com.avf.cqrs.core.commands.BaseCommand;
import br.com.avf.cqrs.core.infraestructures.CommandDispatcher;
import br.com.avf.cqrs.product.commons.protocols.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-05-05, Thursday
 */
@Component
@RequiredArgsConstructor
public class ApiCommandDispatcher {

    private final CommandDispatcher dispatcher;

    public ResponseEntity<BaseResponse> dispatch(String id, BaseCommand command, HttpStatus status, String success, String error) {
        try {
            dispatcher.send(command);
            return new ResponseEntity<>(new BaseResponse(success+id), status);
        } catch (Exception e) {
            return new ResponseEntity<>(new BaseResponse(error), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
