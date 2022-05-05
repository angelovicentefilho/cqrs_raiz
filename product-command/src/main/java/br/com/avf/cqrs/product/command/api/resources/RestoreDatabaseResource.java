package br.com.avf.cqrs.product.command.api.resources;

import br.com.avf.cqrs.core.infraestructures.CommandDispatcher;
import br.com.avf.cqrs.product.command.api.commands.RestoreDataBaseCommand;
import br.com.avf.cqrs.product.commons.protocols.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-05-05, Thursday
 */
@RestController
@RequestMapping("/api/v1/restore")
@RequiredArgsConstructor
public class RestoreDatabaseResource {

    private final CommandDispatcher dispatcher;

    @PostMapping
    public ResponseEntity<BaseResponse> restore() {
        dispatcher.send(new RestoreDataBaseCommand());
        return new ResponseEntity<>(new BaseResponse("Banco de dados restaurando!!"), HttpStatus.CREATED);
    }

}
