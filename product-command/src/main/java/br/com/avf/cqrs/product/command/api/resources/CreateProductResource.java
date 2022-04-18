package br.com.avf.cqrs.product.command.api.resources;

import br.com.avf.cqrs.core.infraestructures.CommandDispatcher;
import br.com.avf.cqrs.product.command.api.protocols.ProductRequest;
import br.com.avf.cqrs.product.command.codec.Codec;
import br.com.avf.cqrs.product.commons.helper.IdGenerator;
import br.com.avf.cqrs.product.commons.protocols.BaseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-11, Monday
 */
@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@Slf4j
public class CreateProductResource {

    private final CommandDispatcher dispatcher;

    @PostMapping
    public ResponseEntity<BaseResponse> create(@RequestBody ProductRequest request) {
        String id = IdGenerator.getId();
        var command = Codec.toCommand(request);
        command.setId(id);
        try {
            dispatcher.send(command);
            return new ResponseEntity<>(new BaseResponse("Produto criado com sucesso! ID: "+id), HttpStatus.CREATED);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(new BaseResponse("Erro enquanto cadastrava o produto '"+id+"'"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
