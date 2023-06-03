package br.com.fatecararas.f290_si_ds2_suggestionbox_ct.config.exceptions;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiError {
    private String timestamp = LocalDateTime.now().toString();
    private int status;
    private String error;
    private String message;
    private String path;

    public ApiError(int status, String error, String message, String path) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public ApiError() {
    }
}
