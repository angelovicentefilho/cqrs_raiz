package br.com.avf.cqrs.product.command.api.resources;

import br.com.avf.cqrs.core.commands.BaseCommand;
import br.com.avf.cqrs.core.infraestructures.CommandDispatcher;
import br.com.avf.cqrs.product.command.api.commands.CreateProductCommand;
import br.com.avf.cqrs.product.command.api.protocols.ProductRequest;
import br.com.avf.cqrs.product.command.codec.Codec;
import br.com.avf.cqrs.product.commons.helper.ApiCommandDispatcher;
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

    private final ApiCommandDispatcher dispatcher;

    @PostMapping
    public ResponseEntity<BaseResponse> create(@RequestBody ProductRequest request) {
        String id = IdGenerator.getId();
        var command = Codec.toCommand(request);
        command.setId(id);
        return dispatcher.dispatch(id, command, HttpStatus.CREATED, "Produto criado com sucesso! ID: ","Erro enquanto cadastrava o produto '"+id+"'" );
    }


}
