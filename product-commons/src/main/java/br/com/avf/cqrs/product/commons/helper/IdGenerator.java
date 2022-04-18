package br.com.avf.cqrs.product.commons.helper;

import lombok.experimental.UtilityClass;

import java.util.UUID;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-11, Monday
 */
@UtilityClass
public class IdGenerator {


    public static String getId() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }

}
