package com.varun.mml.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AuthenticationRequest {
    @Email(message = "Email format is incorrect")
    @NotEmpty(message = "Email is a mandatory field")
    @NotBlank(message = "Email is a mandatory field")
    private String email;
    @NotEmpty(message = "Password is a mandatory field")
    @NotBlank(message = "Password is a mandatory field")
    @Size(min = 8, message = "Password should be at least 8 characters long")
    private String password;
}
