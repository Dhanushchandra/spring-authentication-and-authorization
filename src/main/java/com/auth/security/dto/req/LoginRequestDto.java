package com.auth.security.dto.req;

import lombok.Data;

@Data
public class LoginRequestDto {
    private String email;
    private String password;

}
