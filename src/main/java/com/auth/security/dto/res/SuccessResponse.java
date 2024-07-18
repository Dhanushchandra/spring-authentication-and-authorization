package com.auth.security.dto.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Optional;

@Data
@AllArgsConstructor
public class SuccessResponse {

    private final HttpStatus status;
    private final  int status_code;
    private final String message;
    private final Optional<Object> data;

}
