package br.com.fatecararas.f290_si_ds2_suggestionbox_ct.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.fatecararas.f290_si_ds2_suggestionbox_ct.config.exceptions.ApiError;
import br.com.fatecararas.f290_si_ds2_suggestionbox_ct.config.exceptions.ObjectNotFoundExceptionAPI;

@ControllerAdvice
public class ExceptionsConfig {

    @ExceptionHandler({
            ObjectNotFoundExceptionAPI.class,
    })
    public ResponseEntity<ApiError> notFoundException(Exception exception,
            HttpServletRequest request) {
        var error = new ApiError(
                404, exception.getLocalizedMessage(),
                "Recurso não localizado.",
                request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
