package br.com.avf.cqrs.product.commons.helper;

import br.com.avf.cqrs.core.commands.BaseCommand;
import br.com.avf.cqrs.core.infraestructures.CommandDispatcher;
import br.com.avf.cqrs.product.commons.protocols.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-05-04, Wednesday
 */
@Component
@RequiredArgsConstructor
public class ApiCommandDispatcher {

    private final CommandDispatcher dispatcher;

    public ResponseEntity<BaseResponse> dispatch(String id, BaseCommand command, String success, String error) {
        try {
            dispatcher.send(command);
            return new ResponseEntity<>(new BaseResponse(success+id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new BaseResponse(error), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
