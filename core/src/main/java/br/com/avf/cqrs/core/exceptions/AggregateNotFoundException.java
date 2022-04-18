package br.com.avf.cqrs.core.exceptions;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-06, Wednesday
 */
public class AggregateNotFoundException extends RuntimeException {
    public AggregateNotFoundException() {
    }

    public AggregateNotFoundException(String message) {
        super(message);
    }

    public AggregateNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public AggregateNotFoundException(Throwable cause) {
        super(cause);
    }

    public AggregateNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
