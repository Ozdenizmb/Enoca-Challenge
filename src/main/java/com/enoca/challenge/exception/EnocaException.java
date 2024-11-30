package com.enoca.challenge.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

import java.io.Serializable;

import static com.enoca.challenge.exception.ErrorMessages.DEFAULT_ERROR_MESSAGE;

@Getter
@Setter
public class EnocaException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String detail;
    @NotNull
    private final HttpStatus status;

    protected EnocaException(HttpStatus status, Throwable throwable) {
        super(status.name(), throwable);
        this.status = status;
        this.message = throwable.getMessage();
        this.detail = !StringUtils.hasText(throwable.getMessage()) ? throwable.getMessage() : DEFAULT_ERROR_MESSAGE;
    }

    protected EnocaException(HttpStatus status, String message) {
        super(status.name());
        this.status = status;
        this.message = message;
        this.detail = null;
    }

    protected EnocaException(HttpStatus status, String message, String errorDetail) {
        super(status.name());
        this.status = status;
        this.message = message;
        this.detail = errorDetail;
    }

    public static EnocaException withStatusAndThrowable(HttpStatus status, Throwable throwable){
        return new EnocaException(status, throwable);
    }

    public static EnocaException withStatusAndMessage(HttpStatus status, String message){
        return new EnocaException(status, message);
    }

    public static EnocaException withStatusAndDetails(HttpStatus status, String message, String errorDetail){
        return new EnocaException(status, message, errorDetail);
    }

}
