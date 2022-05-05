package br.com.avf.cqrs.product.command.api.resources;

import br.com.avf.cqrs.core.infraestructures.CommandDispatcher;
import br.com.avf.cqrs.product.command.api.protocols.ProductRequest;
import br.com.avf.cqrs.product.command.codec.Codec;
import br.com.avf.cqrs.product.commons.helper.ApiCommandDispatcher;
import br.com.avf.cqrs.product.commons.helper.IdGenerator;
import br.com.avf.cqrs.product.commons.protocols.BaseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-05-05, Thursday
 */
@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@Slf4j
public class UpdateProductResource {


    private final ApiCommandDispatcher dispatcher;

    @PutMapping("/{id}")
    public ResponseEntity<BaseResponse> update(@PathVariable String id, @RequestBody ProductRequest request) {
        var command = Codec.toUpdateCommand(request);
        command.setId(id);
        return dispatcher.dispatch(id, command, HttpStatus.OK, "Produto editado com sucesso! ID: ","Erro enquanto editado o produto '"+id+"'" );
    }


}
